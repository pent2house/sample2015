package com.ns.spring.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.exception.NSException;

@Service
public abstract class GenHbServiceImpl<E, K extends Serializable> implements GenHbService<E, K> {

	private GenHbDao<E, K> genDao;

	public GenHbServiceImpl(GenHbDao<E, K> genDao) {
		this.genDao = genDao;
	}

	public GenHbServiceImpl() {
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(E obj) {
		genDao.save(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(E obj) {
		genDao.update(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(E obj) {
		genDao.saveOrUpdate(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(E obj) {
		genDao.delete(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<E> findAll() {
		return genDao.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public E findById(K key) {
		try {
			return genDao.findById(key);
		} catch (NSException e) {
			return null;
		}		
	}
}
