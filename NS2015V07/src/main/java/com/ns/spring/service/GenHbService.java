package com.ns.spring.service;

import java.io.Serializable;
import java.util.List;

public interface GenHbService<E, K extends Serializable> {

	public List<E> findAll();	
	public E findById(K key);
	public void save(E obj);
	public void update(E obj);
	public void saveOrUpdate(E obj);
	public void delete(E obj);

}
