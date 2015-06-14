package com.ns.spring.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.RTRN_TP;
import com.ns.spring.model.ui.RtrnTpModel;
import com.ns.spring.service.template.RtrnTpService;

@Component
public class TpBL implements RtrnConstant {

	private static RtrnTpService tpSvc;
	
	@Autowired(required = true)
	public void setTpSvc(RtrnTpService tpSvc) {
		this.tpSvc = tpSvc;
	}

	public static RtrnTpModel getTpByKey(String code) {
		RTRN_TP tp = tpSvc.findById(code);
		if (tp != null) {
			String tpCd = tp.getRtrnTpCd();
			if (code.equals(tpCd)) {
				return new RtrnTpModel(tp.getRtrnTpCd(), tp.getRtrnTpNm());
			}
		}
		return null;
	}

	public static List<RtrnTpModel> getRtrnTpModelList() {
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
	public static List<RtrnTpModel> getTypeList(HttpServletRequest req) {
		List<RtrnTpModel> rtrnTpModelList = (List<RtrnTpModel>)req.getSession().getAttribute(CONST.TP_LIST.getVal());
		if (CommonBL.isEmpty(rtrnTpModelList)) {
			// Get fresh data from DB
			rtrnTpModelList = getRtrnTpModelList();
			req.getSession().setAttribute(CONST.TP_LIST.getVal(), rtrnTpModelList);
		}
		return rtrnTpModelList;
	}

	public static void rtrnTpCombo(Model model, HttpServletRequest req) {
		model.addAttribute(CONST.TP_LIST.getVal(), getTypeList(req));
	}
}
