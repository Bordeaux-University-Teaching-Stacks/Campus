package com.intuitiv.campus.dao.impl;

import org.springframework.stereotype.Repository;

import com.intuitiv.campus.dao.AbstractDao;
import com.intuitiv.campus.dao.CampusDao;
import com.intuitiv.campus.entity.Campus;

@Repository("CampusDao")
public class CampusDaoImpl extends AbstractDao<Campus, Integer> implements CampusDao {

	public CampusDaoImpl() {
		super();
	}

	@Override
	public Campus find(int id) {
		return this.find(Campus.class, id);
	}
}
