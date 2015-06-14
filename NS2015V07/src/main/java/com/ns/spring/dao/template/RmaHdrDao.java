package com.ns.spring.dao.template;

import java.util.List;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.model.RMA_HDR;

public interface RmaHdrDao extends GenHbDao<RMA_HDR, Integer> {

	public List<Object[]> getListRmaHdrBySql(String id);
}
