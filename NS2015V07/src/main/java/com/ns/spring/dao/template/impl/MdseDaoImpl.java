package com.ns.spring.dao.template.impl;

import org.springframework.stereotype.Repository;

import com.ns.spring.dao.GenHbDaoImpl;
import com.ns.spring.dao.template.MdseDao;
import com.ns.spring.model.MDSE;

@Repository
public class MdseDaoImpl extends GenHbDaoImpl<MDSE, String> implements MdseDao {

}
