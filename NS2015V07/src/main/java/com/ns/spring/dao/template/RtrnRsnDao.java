package com.ns.spring.dao.template;

import java.util.List;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.model.RTRN_RSN;

public interface RtrnRsnDao extends GenHbDao<RTRN_RSN, String> {

	public List<Object[]> getListRsnsBoundTpBySql(String tpCd);
	public List<Object[]> getListRsnsUnBoundTpBySql(String tpCd);
}
