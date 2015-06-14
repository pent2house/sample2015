package com.ns.spring.dao.template.impl;

import org.springframework.stereotype.Repository;

import com.ns.spring.dao.GenHbDaoImpl;
import com.ns.spring.dao.template.RmaHdrStsDao;
import com.ns.spring.model.RMA_HDR_STS;

@Repository
public class RmaHdrStsDaoImpl extends GenHbDaoImpl<RMA_HDR_STS, String> implements RmaHdrStsDao {

}
