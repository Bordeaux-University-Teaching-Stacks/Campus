package com.intuitiv.campus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuitiv.campus.common.CampusException;
import com.intuitiv.campus.common.CipherUtils;
import com.intuitiv.campus.dao.UserDao;
import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;
import com.intuitiv.campus.service.UserService;

/**
 * <b>UserServiceImpl</b> the implementation of the user service
 * @author Meidi
 *
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

	/**
	 * The user's DAO
	 */
	@Autowired
	private UserDao userDao;

	/** {@inheritDoc}
	 */
	@Override
	public boolean emailExists(String email) throws CampusException {
		if (userDao.findByEmail(email) != null)
			return true;
		return false;
	}

	/** {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() {
		return userDao.list(User.class);
	}

	/** {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsersByCampus(Campus campus) {
		return userDao.getAllUsersByCampus(campus);
	}

	/** {@inheritDoc}
	 */
	@Override
	public User getUserByMail(String email) {
		return userDao.findByEmail(email);
	}

	/** {@inheritDoc}
	 */
	@Override
	public boolean passwordMatchWithEmail(String email, String password) {
		if (userDao.findByEmail(email) != null && userDao.findByEmail(email).getPassword().equals(CipherUtils.encrypt(password)))
			return true;
		return false;
	}

	/** {@inheritDoc}
	 */
	@Override
	public User save(User user) {
		// TODO : find a solution for a lonely transaction instead of two
		user.setPassword(CipherUtils.encrypt(user.getPassword()));
		return userDao.find(userDao.save(user));
	}

	/** {@inheritDoc}
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}



}
