package com.ns.spring.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.RTRN_RSN;
import com.ns.spring.model.ui.RtrnRsnModel;
import com.ns.spring.service.template.RtrnRsnService;

@Component
public class RsnBL implements RtrnConstant {

	private static RtrnRsnService rsnSvc;

	@Autowired(required = true)
	public void setRsnSvc(RtrnRsnService rsnSvc) {
		this.rsnSvc = rsnSvc;
	}

	@SuppressWarnings("unchecked")
	public static List<RtrnRsnModel> getRsnList(HttpServletRequest req) {
		List<RtrnRsnModel> rsnModelList = (List<RtrnRsnModel>)req.getSession().getAttribute(CONST.RSN_LIST.getVal());
		if (CommonBL.isEmpty(rsnModelList)) {
			// Get fresh data from DB
			rsnModelList = getRtrnRsnModelList();
			req.getSession().setAttribute(CONST.RSN_LIST.getVal(), rsnModelList);
		}
		return rsnModelList;
	}

	public static List<RtrnRsnModel> getRtrnRsnModelList() {
		List<RtrnRsnModel> rtrnRsnList = new ArrayList<>(); 
		List<RTRN_RSN> rtrnRsns = rsnSvc.findAll();
		if (!CommonBL.isEmpty(rtrnRsns)) {
			for (RTRN_RSN rsn : rtrnRsns) {
				rtrnRsnList.add(new RtrnRsnModel(rsn.getRtrnRsnCd(), rsn.getRtrnRsnNm(), rsn.getSortNum(), ""));
			}
		}
		return rtrnRsnList;
	}

	public static void resetRsn(Model model, HttpServletRequest req) {
		model.addAttribute(CONST.FORM_KEY.getVal(), new RtrnRsnModel());
		req.getSession().removeAttribute(CONST.RSN_LIST.getVal());
		model.addAttribute(CONST.RSN_LIST.getVal(), getRsnList(req));
	}

	public static boolean hasRsnCd(RTRN_RSN rsn) {
		String code = rsn.getRtrnRsnCd();
		if( code != null && code.length() > 0 ) {
			return true;
		}
		return false;
	}

	public static List<RtrnRsnModel> getRsnsBoundTp(String tpCd) {
		List<RtrnRsnModel> rsnList = new ArrayList<>();
		List<Object[]> listRsnsWithTp = rsnSvc.getListRsnsBoundTpBySql(tpCd);
		for (Object[] array : listRsnsWithTp) {
			rsnList.add(new RtrnRsnModel(array));
		}
		return rsnList;
	}

	public static List<RtrnRsnModel> getRsnsUnBoundTp(String tpCd) {
		List<RtrnRsnModel> rsnList = new ArrayList<>();
		List<Object[]> listRsnsWithTp = rsnSvc.getListRsnsUnBoundTpBySql(tpCd);
		for (Object[] array : listRsnsWithTp) {
			rsnList.add(new RtrnRsnModel(array));
		}
		return rsnList;
	}

	public static void rtrnRsnCombo(Model model, HttpServletRequest req) {
		model.addAttribute(CONST.RSN_LIST.getVal(), getRsnList(req));
	}

	public static void initBoundUnboundRsnList(String tpSelected, HttpServletRequest req) {		
		req.getSession().setAttribute(CONST.RSN_LIST_BOUND.getVal(), getRsnsBoundTp(tpSelected));
		req.getSession().setAttribute(CONST.RSN_LIST_UNBOUND.getVal(), getRsnsUnBoundTp(tpSelected));
	}
}
