package com.ns.spring.service.template;

import com.ns.spring.model.RTRN_TP_RSN_CMBN;
import com.ns.spring.service.GenHbService;

public interface RtrnTpRsnService extends GenHbService<RTRN_TP_RSN_CMBN, String> {

	public RTRN_TP_RSN_CMBN getTpRsnCmbnByHql(String rtrnTpCd, String rtrnRsnCd);
}
