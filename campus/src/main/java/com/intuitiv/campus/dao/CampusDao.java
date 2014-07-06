package com.intuitiv.campus.dao;

import java.util.List;

import com.intuitiv.campus.entity.Campus;

public interface CampusDao {

	/**
	 * List all of the campus
	 * @return
	 */
	public List<Campus> list(Class<Campus> c);

	/**
	 * Find a campus by Id
	 * @param id
	 * @return
	 */
	public Campus find(int id);
}
