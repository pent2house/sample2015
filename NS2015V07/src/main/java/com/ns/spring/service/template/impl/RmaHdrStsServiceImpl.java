package com.ns.spring.service.template.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.dao.template.RmaHdrStsDao;
import com.ns.spring.model.RMA_HDR_STS;
import com.ns.spring.service.GenHbServiceImpl;
import com.ns.spring.service.template.RmaHdrStsService;

@Service("rmaHdrStsService")
public class RmaHdrStsServiceImpl extends GenHbServiceImpl<RMA_HDR_STS, String> implements RmaHdrStsService {

	private RmaHdrStsDao dao;

	public RmaHdrStsServiceImpl() {
	}

	@Autowired
	public RmaHdrStsServiceImpl(@Qualifier("rmaHdrStsDaoImpl") GenHbDao<RMA_HDR_STS, String> genericDao) {
		super(genericDao);
		this.dao = (RmaHdrStsDao) genericDao;
	}
}
