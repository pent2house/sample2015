package com.ns.spring.service.template.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.dao.template.RmaLineDao;
import com.ns.spring.model.RMA_LINE;
import com.ns.spring.service.GenHbServiceImpl;
import com.ns.spring.service.template.RmaLineService;

@Service("rmaLineService")
public class RmaLineServiceImpl extends GenHbServiceImpl<RMA_LINE, String> implements RmaLineService {

	private RmaLineDao dao;

	public RmaLineServiceImpl() {
	}

	@Autowired
	public RmaLineServiceImpl(@Qualifier("rmaLineDaoImpl") GenHbDao<RMA_LINE, String> genericDao) {
		super(genericDao);
		this.dao = (RmaLineDao) genericDao;
	}
	
	@Override
	@Transactional
	public List<Object[]> getListRmaLineBySql(String rmaNum, String rmaLineNum) {
		return this.dao.getListRmaLineBySql(rmaNum, rmaLineNum);
	}

	@Override
	@Transactional
	public RMA_LINE getRmaLineByHql(String rmaNum, String rmaLineNum) {
		return this.dao.getRmaLineByHql(rmaNum, rmaLineNum);
	}
}
