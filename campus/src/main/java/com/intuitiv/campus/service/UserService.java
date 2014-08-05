package com.intuitiv.campus.service;

import java.util.List;

import com.intuitiv.campus.common.CampusException;
import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;

/**
 * <b>UserService</b> the interface for user service provider
 * @author Meidi
 *
 */
public interface UserService {

	/**
	 * Check if the entered email exists in the database
	 * @return <b>true :</b> if the email exists <br/>
	 * <b>false :</b> if the email doesn't exist
	 */
	public boolean emailExists(String email) throws CampusException;

	/**
	 * Return all of the users
	 * @return a list of users
	 */
	public List<User> getAllUsers();

	/**
	 * Return all the users of a campus
	 * @param campus : the common campus of the users to get
	 * @return a list of users
	 */
	public List<User> getAllUsersByCampus(Campus campus);

	/**
	 * Return a user thanks to his mail
	 * @param email : the email of a user
	 * @return a user
	 */
	public User getUserByMail(String email);

	/**
	 * Check if the entered password match with the database password for the provided email
	 * @param email : the view entered email
	 * @param password : the view entered password
	 * @return <b>true :</b> if the encrypted entered password match with the email attached password in the database <br/>
	 * <b>false :</b> if the encrypted entered password doesn't match with the email attached password in the database
	 */
	public boolean passwordMatchWithEmail(String email, String password);

	/**
	 * Saves the new user and return it
	 * @param user : the new user to create
	 * @return the new user from the database
	 */
	public User save(User user);

	/**
	 * Update an existing user
	 * @param user : the user to update
	 */
	public void update(User user);

}
