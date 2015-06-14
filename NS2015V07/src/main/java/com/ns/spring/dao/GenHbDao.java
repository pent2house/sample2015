package com.ns.spring.dao;

import java.io.Serializable;
import java.util.List;

import com.ns.spring.exception.NSException;

public interface GenHbDao<E, K extends Serializable> {

	public List<E> findAll();	
	public E findById(K key) throws NSException;
	public void save(E obj);
	public void update(E obj);
	public void saveOrUpdate(E obj);
	public void delete(E obj);

}
