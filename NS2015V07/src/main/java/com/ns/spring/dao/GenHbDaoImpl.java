package com.ns.spring.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ns.spring.exception.NSException;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenHbDaoImpl<E, K extends Serializable> implements GenHbDao<E, K> {

	private SessionFactory sessionFactory;
	private Class<E> clazz;

	public GenHbDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		this.clazz = (Class<E>) pt.getActualTypeArguments()[0];
	}

	public Class<E> getCurrClazz() {
		return clazz;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	protected Session getCurrSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(E obj) {
		this.getCurrSession().persist(obj);
	}

	@Override
	public void update(E obj) {
		this.getCurrSession().update(obj);
	}

	@Override
	public void saveOrUpdate(E obj) {
		this.getCurrSession().saveOrUpdate(obj);
	}

	@Override
	public void delete(E obj) {
		this.getCurrSession().delete(obj);
	}

	@Override
	public List<E> findAll() {
		List<E> list = this.getCurrSession().createCriteria(getCurrClazz()).list();
		return list;
	}

	@Override
	public E findById(K key) throws NSException {
		Session session = this.getCurrSession();
		try {
			E p = (E) session.load(getCurrClazz(), key);
			return p;
		} catch (ObjectNotFoundException e) {
			throw new NSException("No result");
		}
	}
}
