package com.intuitiv.campus.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "campus", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id_campus") })
public class Campus {

	/**
	 * Unique Identifier
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_campus", unique = true, nullable = false)
	private int id;

	/**
	 * Campus name
	 */
	@Column(name = "name")
	@NotNull
	@NotEmpty
	private String name;

	/**
	 * Users of a campus
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_campus")
	private Set<User> users;

	public Campus(){

	}

	public Campus(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
