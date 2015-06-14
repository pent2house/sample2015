package com.ns.spring.service.template;

import java.util.List;

import com.ns.spring.model.RTRN_RSN;
import com.ns.spring.service.GenHbService;

public interface RtrnRsnService extends GenHbService<RTRN_RSN, String> {

	public List<Object[]> getListRsnsBoundTpBySql(String tpCd);
	public List<Object[]> getListRsnsUnBoundTpBySql(String tpCd);
}
