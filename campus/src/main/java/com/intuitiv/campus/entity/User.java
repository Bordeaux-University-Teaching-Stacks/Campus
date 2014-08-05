package com.intuitiv.campus.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * User entity with validators
 * @author Meidi
 *
 */
@Entity
@Table(name = "user")
public class User {

	/**
	 * Password validation pattern
	 * 
	 * Must got one Upper case
	 * Must got one Lower case
	 * Must have more than 5 characters
	 * Must have less than 13 characters
	 */
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z]).{6,12})";

	/**
	 * Birth validation pattern
	 * 
	 */
	private static final String BIRTH_PATTERN = "dd/MM/yyyy";

	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user", unique = true, nullable = false)
	private Long id;

	/**
	 * Email of the user
	 */
	@Column(name = "email", unique = true, nullable = false)
	@Email(message="L''email fourni n'est pas valide")
	@NotEmpty(message="Obligatoire")
	private String email;

	/**
	 * Password of the user
	 */
	@Column(name = "password", nullable = false)
	@Pattern(regexp=PASSWORD_PATTERN, message="Doit contenir 1 lettre majuscule, 1 chiffre et faire entre 6 et 12 caractères")
	@NotEmpty(message="Obligatoire")
	private String password;

	/**
	 * Birth date of the user
	 */
	@Column(name = "birth", nullable = false)
	@DateTimeFormat(pattern=BIRTH_PATTERN)
	@Past(message="Date de naissance invalide")
	@NotNull(message="Obligatoire")
	private Date birth;

	/**
	 * Name of the user
	 */
	@Column(name = "name", nullable = false)
	@NotEmpty(message="Obligatoire")
	private String name;

	/**
	 * Surname of the user
	 */
	@Column(name = "surname", nullable = false)
	@NotEmpty(message="Obligatoire")
	private String surname;

	/**
	 * User's sex boolean value
	 */
	@Column(name = "sex", nullable = false)
	private char sex;

	/**
	 * Url of the user picture
	 */
	@Column(name = "photo", nullable = true)
	private String photo;

	/**
	 * Campus of the user
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_campus")
	@NotNull
	private Campus campus;

	/**
	 * Tell if the user accepted the legals
	 */
	@Column(name="legals")
	@AssertTrue(message="Obligatoire")
	private boolean legals;

	/**
	 * Tell if the user must receive the newsletter
	 */
	@Column(name="newsletter")
	private boolean newsletter;

	/**
	 * Default constructor
	 */
	public User() {

	}

	/**
	 * Explicit constructor
	 * @param name : the user's name
	 * @param surname : the user's surname
	 * @param birth : the user's birth date
	 * @param sex : the user's sex
	 * @param email : the user's email
	 * @param password : the user's password
	 * @param campus : the user's campus
	 */
	public User(String name, String surname, Date birth, char sex,
			String email, String password, Campus campus) {
		this.name = name;
		this.surname = surname;
		this.birth = birth;
		this.sex = sex;
		this.email = email;
		this.password = password;
		this.campus = campus;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Campus getCampus() {
		return this.campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public char getSex() {
		return this.sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public boolean getLegals() {
		return legals;
	}

	public void setLegals(boolean legals) {
		this.legals = legals;
	}

	public boolean getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	/**
	 * This calculate and return the age of the user's
	 * @return the user's calculated age
	 */
	public long getAge() {
		Calendar birth = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		birth.setTime(this.birth);
		int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
			age--;
		} else if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)) {
			age--;
		}
		return age;
	}
}
