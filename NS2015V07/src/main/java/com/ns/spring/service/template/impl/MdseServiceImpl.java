package com.ns.spring.service.template.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.dao.template.MdseDao;
import com.ns.spring.model.MDSE;
import com.ns.spring.service.GenHbServiceImpl;
import com.ns.spring.service.template.MdseService;

@Service("mdseService")
public class MdseServiceImpl extends GenHbServiceImpl<MDSE, String> implements MdseService {

	private MdseDao dao;

	public MdseServiceImpl() {
	}

	@Autowired
	public MdseServiceImpl(@Qualifier("mdseDaoImpl") GenHbDao<MDSE, String> genericDao) {
		super(genericDao);
		this.dao = (MdseDao) genericDao;
	}
}
