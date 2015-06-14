package com.ns.spring.dao.template.impl;

import org.springframework.stereotype.Repository;

import com.ns.spring.dao.GenHbDaoImpl;
import com.ns.spring.dao.template.RtrnTpDao;
import com.ns.spring.model.RTRN_TP;

@Repository
public class RtrnTpDaoImpl extends GenHbDaoImpl<RTRN_TP, String> implements RtrnTpDao {

}
