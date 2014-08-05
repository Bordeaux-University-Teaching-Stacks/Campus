package com.intuitiv.campus.dao;

import java.util.List;

import com.intuitiv.campus.entity.Campus;

/**
 * <b>CampusDao</b> is the public interface who describe the campus DAO
 * @author Meidi
 *
 */
public interface CampusDao {

	/**
	 * List all of the campus
	 * @return List<Campus>
	 */
	public List<Campus> list(Class<Campus> c);

	/**
	 * Find a campus by Id
	 * @param id : the identifier of the campus
	 * @return Campus
	 */
	public Campus find(int id);
}
