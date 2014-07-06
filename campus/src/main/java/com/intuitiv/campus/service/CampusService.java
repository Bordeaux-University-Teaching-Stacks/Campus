package com.intuitiv.campus.service;

import java.util.List;

import com.intuitiv.campus.entity.Campus;

public interface CampusService {

	/**
	 * List all of the campus
	 * @return
	 */
	public List<Campus> list();

	/**
	 * Find a campus by Id
	 * @param id
	 * @return
	 */
	public Campus find(int id);
}
