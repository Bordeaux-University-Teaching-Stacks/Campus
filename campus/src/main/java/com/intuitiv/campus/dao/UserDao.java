package com.intuitiv.campus.dao;

import java.util.List;

import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;

public interface UserDao {

	/**
	 * List every objects of the selected type from the data source
	 *
	 * @return
	 */
	public List<User> list(Class<User> c);

	/**
	 * List all the users of a campus
	 * @param campus
	 * @return
	 */
	public List<User> getAllUsersByCampus(Campus campus);

	/**
	 * Find an object identified by an ID
	 *
	 * @param id
	 * @return
	 */
	public User find(Long id);

	/**
	 * Find a user identifiend by his email
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);

	/**
	 * Save an object in the data source
	 *
	 * @param obj
	 */
	public Long save(User obj);

	/**
	 * Update an object present in the data source
	 * 
	 * @retrun
	 */
	public void update(User obj);

	/**
	 * Delete an object from the data source
	 *
	 * @param obj
	 */
	public void delete(User obj);

}
