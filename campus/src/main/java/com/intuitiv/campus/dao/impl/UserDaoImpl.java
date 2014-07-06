package com.intuitiv.campus.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.intuitiv.campus.dao.AbstractDao;
import com.intuitiv.campus.dao.UserDao;
import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;

@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

	private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl() {
		super();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsersByCampus(Campus campus) {
		return getHibernateTemplate().find("from Campus c where c.id =?", campus.getId());
	}

	@Override
	public User find(Long id) {
		return this.find(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		try{
			return (User) getHibernateTemplate().find("from User u where u.email =?", email).get(0);
		} catch(Exception e){
			LOGGER.warn("No data found");
			return null;
		}
	}
}
