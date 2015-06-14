package com.ns.spring.service.template.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.dao.template.RtrnRsnDao;
import com.ns.spring.model.RTRN_RSN;
import com.ns.spring.service.GenHbServiceImpl;
import com.ns.spring.service.template.RtrnRsnService;

@Service("rtrnRsnService")
public class RtrnRsnServiceImpl extends GenHbServiceImpl<RTRN_RSN, String> implements RtrnRsnService {

	private RtrnRsnDao dao;

	public RtrnRsnServiceImpl() {
	}

	@Autowired
	public RtrnRsnServiceImpl(@Qualifier("rtrnRsnDaoImpl") GenHbDao<RTRN_RSN, String> genericDao) {
		super(genericDao);
		this.dao = (RtrnRsnDao) genericDao;
	}

	@Override
	@Transactional
	public List<Object[]> getListRsnsBoundTpBySql(String tpCd) {
		return this.dao.getListRsnsBoundTpBySql(tpCd);
	}
	
	@Override
	@Transactional
	public List<Object[]> getListRsnsUnBoundTpBySql(String tpCd) {
		return this.dao.getListRsnsUnBoundTpBySql(tpCd);
	}
}
