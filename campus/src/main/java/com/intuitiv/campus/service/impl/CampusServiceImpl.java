package com.intuitiv.campus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuitiv.campus.dao.CampusDao;
import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.service.CampusService;

/**
 * <b>CampusServiceImpl</b> is the implementation of the campus service
 * @author Meidi
 *
 */
@Service("CampusService")
public class CampusServiceImpl implements CampusService {

	/**
	 * The campus DAO
	 */
	@Autowired
	CampusDao campusDao;

	/** {@inheritDoc}
	 */
	@Override
	public List<Campus> list() {
		return campusDao.list(Campus.class);
	}

	/** {@inheritDoc}
	 */
	@Override
	public Campus find(int id) {
		return campusDao.find(id);
	}

}
