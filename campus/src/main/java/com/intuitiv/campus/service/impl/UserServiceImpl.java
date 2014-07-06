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

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean emailExists(String email) throws CampusException {
		if (userDao.findByEmail(email) != null)
			return true;
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.list(User.class);
	}

	@Override
	public List<User> getAllUsersByCampus(Campus campus) {
		return userDao.getAllUsersByCampus(campus);
	}

	@Override
	public User getUserByMail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public boolean passwordConfirmMatchPassword(String password, String passwordConfirm) {
		if(password.equals(passwordConfirm))
			return true;
		return false;
	}

	@Override
	public boolean passwordMatchWithEmail(String email, String password) {
		if (userDao.findByEmail(email) != null && userDao.findByEmail(email).getPassword().equals(CipherUtils.encrypt(password)))
			return true;
		return false;
	}

	@Override
	public User save(User user) {
		return userDao.find(userDao.save(user));
	}



}
