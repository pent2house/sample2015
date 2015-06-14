package com.ns.spring.dao.template;

import com.ns.spring.dao.GenHbDao;
import com.ns.spring.model.RTRN_TP_RSN_CMBN;

public interface RtrnTpRsnDao extends GenHbDao<RTRN_TP_RSN_CMBN, String> {
	
	public RTRN_TP_RSN_CMBN getTpRsnCmbnByHql(String rtrnTpCd, String rtrnRsnCd);
}
