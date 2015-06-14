package com.ns.spring.common.gen;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ns.spring.common.CommonBL;
import com.ns.spring.constant.RtrnConstant.CONST;
import com.ns.spring.model.RMA_HDR_STS;
import com.ns.spring.model.RTRN_TP;
import com.ns.spring.model.ui.RmaHdrStsModel;
import com.ns.spring.model.ui.RtrnTpModel;
import com.ns.spring.service.template.RmaHdrStsService;
import com.ns.spring.service.template.RtrnTpService;

@Component
public class TpCommonBL implements BLService {

	private static RtrnTpService tpSvc;

	@Autowired(required = true)
	public void setTpSvc(RtrnTpService tpSvc) {
		this.tpSvc = tpSvc;
	}

	@Override
	public List<RtrnTpModel> getList() {
		List<RtrnTpModel> rtrnTpList = new ArrayList<>();
		List<RTRN_TP> rtrnTps = tpSvc.findAll();
		if (!CommonBL.isEmpty(rtrnTps)) {
			for (RTRN_TP tp : rtrnTps) {
				rtrnTpList.add(new RtrnTpModel(tp.getRtrnTpCd(), tp.getRtrnTpNm(), tp.getSortNum()));
			}
		}
		return rtrnTpList;
	}

	@SuppressWarnings("unchecked")
	private List<RtrnTpModel> getTypeList(HttpServletRequest req) {
		List<RtrnTpModel> rtrnTpModelList = (List<RtrnTpModel>)req.getSession().getAttribute(CONST.TP_LIST.getVal());
		if (CommonBL.isEmpty(rtrnTpModelList)) {
			// Get fresh data from DB
			rtrnTpModelList = getList();
			req.getSession().setAttribute(CONST.TP_LIST.getVal(), rtrnTpModelList);
		}
		return rtrnTpModelList;
	}
}
