package com.ns.spring.dao.template;

import java.util.List;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.model.RMA_LINE;

public interface RmaLineDao extends GenHbDao<RMA_LINE, String> {

	public List<Object[]> getListRmaLineBySql(String rmaNum, String rmaLineNum);
	public RMA_LINE getRmaLineByHql(String rmaNum, String rmaLineNum);
}
