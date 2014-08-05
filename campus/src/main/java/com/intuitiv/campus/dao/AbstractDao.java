package com.intuitiv.campus.dao;

import java.io.Serializable;
import java.util.List;

import com.intuitiv.campus.common.HibernateSessionUtils;

/**
 * <b>AbstractDao</b> is the CRUD template for DAO implementation
 * @author Meidi
 *
 * @param <T> : the type of the object to access in the database
 * @param <PK> : the primary key of the object to access in the database
 */
public abstract class AbstractDao<T, PK extends Serializable> extends HibernateSessionUtils implements Dao<T, PK> {

	/** {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T find(Class<T> c, PK id) {
		return (T) getHibernateTemplate().get(c, id);
	}

	/** {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(Class<T> c) {
		return getHibernateTemplate().find("from " + c.getCanonicalName());
	}

	/** {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PK save(T obj) {
		return (PK) getHibernateTemplate().save(obj);
	}

	/** {@inheritDoc}
	 */
	@Override
	public void update(T obj) {
		getHibernateTemplate().update(obj);
	}

	/** {@inheritDoc}
	 */
	@Override
	public void delete(T obj) {
		getHibernateTemplate().delete(obj);
	}

}
