package com.intuitiv.campus.dao.impl;

import org.springframework.stereotype.Repository;

import com.intuitiv.campus.dao.AbstractDao;
import com.intuitiv.campus.dao.CampusDao;
import com.intuitiv.campus.entity.Campus;

/**
 * <b>CampusDaoImpl</b> is an implementation of the CampusDao interface<br/>
 * It stands for Data Access on Campus Objects
 * @author Meidi
 *
 */
@Repository("CampusDao")
public class CampusDaoImpl extends AbstractDao<Campus, Integer> implements CampusDao {

	/**
	 * Default constructor
	 */
	public CampusDaoImpl() {
		super();
	}

	/** {@inheritDoc}
	 */
	@Override
	public Campus find(int id) {
		return this.find(Campus.class, id);
	}
}
