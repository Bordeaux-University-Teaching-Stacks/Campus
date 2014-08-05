package com.intuitiv.campus.dao;

import java.util.List;

import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;

/**
 * <b>UserDao</b> is the public interface who describe the user DAO
 * @author Meidi
 *
 */
public interface UserDao {

	/**
	 * List every objects of the selected type from the data source
	 *
	 * @return List<User>
	 */
	public List<User> list(Class<User> c);

	/**
	 * List all the users of a campus
	 * @param campus : the campus where the users to get are
	 * @return List<User>
	 */
	public List<User> getAllUsersByCampus(Campus campus);

	/**
	 * Find an object identified by an ID
	 *
	 * @param id : the user unique identifier
	 * @return User
	 */
	public User find(Long id);

	/**
	 * Find a user identified by his email
	 * @param email : the user unique email
	 * @return User
	 */
	public User findByEmail(String email);

	/**
	 * Create a new user
	 *
	 * @param user : the new user to create
	 * @return the unique identifier of the new user
	 */
	public Long save(User user);

	/**
	 * Update a user already existing
	 * 
	 */
	public void update(User obj);

	/**
	 * Delete an existing user
	 *
	 * @param user : the user to delete
	 */
	public void delete(User user);

}
