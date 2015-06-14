package com.ns.spring.service.template.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.dao.template.RmaHdrDao;
import com.ns.spring.model.RMA_HDR;
import com.ns.spring.service.GenHbServiceImpl;
import com.ns.spring.service.template.RmaHdrService;

@Service("rmaHdrService")
public class RmaHdrServiceImpl extends GenHbServiceImpl<RMA_HDR, Integer> implements RmaHdrService {

	private RmaHdrDao dao;

	public RmaHdrServiceImpl() {
	}

	@Autowired
	public RmaHdrServiceImpl(@Qualifier("rmaHdrDaoImpl") GenHbDao<RMA_HDR, Integer> genericDao) {
		super(genericDao);
		this.dao = (RmaHdrDao) genericDao;
	}
	
	@Override
	@Transactional
	public List<Object[]> getListRmaHdrBySql(String id) {
		return this.dao.getListRmaHdrBySql(id);
	}
}
