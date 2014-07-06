package com.intuitiv.campus.service;

import java.util.List;

import com.intuitiv.campus.common.CampusException;
import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;

public interface UserService {

	/**
	 * Check if the entered email exists in the database
	 * @return
	 */
	public boolean emailExists(String email) throws CampusException;

	/**
	 * Return all of the users
	 * @return
	 */
	public List<User> getAllUsers();

	/**
	 * Return all the users of a campus
	 * @param campus
	 * @return
	 */
	public List<User> getAllUsersByCampus(Campus campus);

	/**
	 * Return a user thanks to his mail
	 * @param email
	 * @return
	 */
	public User getUserByMail(String email);

	/**
	 * Check if password confirm match with password
	 * @param password
	 * @param passwordConfirm
	 * @return
	 */
	public boolean passwordConfirmMatchPassword(String password, String passwordConfirm);

	/**
	 * Check if the entered password match with the database password for the provided email
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean passwordMatchWithEmail(String email, String password);

	/**
	 * Saves the new user and return it
	 * @param user
	 * @return
	 */
	public User save(User user);

}
