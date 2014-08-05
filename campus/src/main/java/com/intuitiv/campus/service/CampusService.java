package com.intuitiv.campus.service;

import java.util.List;

import com.intuitiv.campus.entity.Campus;

/**
 * <b>CampusService</b> the interface for campus service provider
 * @author Meidi
 *
 */
public interface CampusService {

	/**
	 * List all of the campus
	 * @return a list of campus
	 */
	public List<Campus> list();

	/**
	 * Find a campus by Id
	 * @param id : the unique identifier of a campus
	 * @return a campus
	 */
	public Campus find(int id);
}
