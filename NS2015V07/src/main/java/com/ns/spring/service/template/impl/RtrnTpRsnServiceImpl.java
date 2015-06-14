package com.ns.spring.service.template.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.dao.template.RtrnTpRsnDao;
import com.ns.spring.model.RTRN_TP_RSN_CMBN;
import com.ns.spring.service.GenHbServiceImpl;
import com.ns.spring.service.template.RtrnTpRsnService;

@Service("rtrnTpRsnService")
public class RtrnTpRsnServiceImpl extends GenHbServiceImpl<RTRN_TP_RSN_CMBN, String> implements RtrnTpRsnService {

	private RtrnTpRsnDao dao;

	public RtrnTpRsnServiceImpl() {
	}

	@Autowired
	public RtrnTpRsnServiceImpl(@Qualifier("rtrnTpRsnDaoImpl") GenHbDao<RTRN_TP_RSN_CMBN, String> genericDao) {
		super(genericDao);
		this.dao = (RtrnTpRsnDao) genericDao;
	}
	
	@Override
	@Transactional
	public RTRN_TP_RSN_CMBN getTpRsnCmbnByHql(String rtrnTpCd, String rtrnRsnCd) {
		return this.dao.getTpRsnCmbnByHql(rtrnTpCd, rtrnRsnCd);
	}
}
