package com.ns.spring.service.template.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.dao.template.RtrnTpDao;
import com.ns.spring.model.RTRN_TP;
import com.ns.spring.service.GenHbServiceImpl;
import com.ns.spring.service.template.RtrnTpService;

@Service("rtrnTpService")
public class RtrnTpServiceImpl extends GenHbServiceImpl<RTRN_TP, String> implements RtrnTpService {

	private RtrnTpDao dao;

	public RtrnTpServiceImpl() {
	}

	@Autowired
	public RtrnTpServiceImpl(@Qualifier("rtrnTpDaoImpl") GenHbDao<RTRN_TP, String> genericDao) {
		super(genericDao);
		this.dao = (RtrnTpDao) genericDao;
	}
}
