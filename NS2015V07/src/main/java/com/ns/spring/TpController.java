package com.ns.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ns.spring.aop.Loggable;
import com.ns.spring.common.TpBL;
import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.RMA_HDR;
import com.ns.spring.model.RTRN_TP;
import com.ns.spring.model.ui.RtrnTpModel;
import com.ns.spring.service.template.RtrnTpService;

@Controller
//@RequestMapping("/cUrlValAttrbSubTpRsn01Jsp")
public class TpController implements RtrnConstant {
	
	@Autowired(required = true)
	private RtrnTpService tpSvc;

	@Loggable
	@RequestMapping(value = "/cUrlValAttrbMain01Jsp", params = "goToTp", method = RequestMethod.POST)
	public String goToTp(Model model, HttpServletRequest req) {
		model.addAttribute(CONST.FORM_KEY.getVal(), new RtrnTpModel());
		model.addAttribute(CONST.TP_LIST.getVal(), TpBL.getTypeList(req));
		return VIEW.SUB_TP_01.getVal();
	}

	@RequestMapping(value = "/cUrlValAttrbSubTp01Jsp", params = "backToRmaFromTp", method = RequestMethod.POST)
	public String backToRmaFromTp(@ModelAttribute("rma_hdr") RMA_HDR rma) {
		return VIEW.REDIRECT_HOME.getVal();
	}

	@RequestMapping(value = "/cUrlValAttrbSubTp01Jsp", params = "addType", method = RequestMethod.POST)
	private String addRtrnTp(@ModelAttribute("RTRN_TP") RTRN_TP tp, Model model, HttpServletRequest req) {
		if (hasTpCd(tp)) {
			this.tpSvc.save(tp);
			resetTp(model, req);
		}
		return VIEW.SUB_TP_01.getVal();
	}
	
	private boolean hasTpCd(RTRN_TP tp) {
		String code = tp.getRtrnTpCd();
		if( code != null && code.length() > 0 ) {
			return true;
		}
		return false;
	}

	@RequestMapping("/removeType/{rtrnTpCd}")
	public String removeRtrnTp(@PathVariable("rtrnTpCd") String rtrnTpCd, Model model, HttpServletRequest req) {
		RTRN_TP tp = this.tpSvc.findById(rtrnTpCd);
		if (tp != null) {
			this.tpSvc.delete(tp);
			resetTp(model, req);
		}		
		return VIEW.SUB_TP_01.getVal();
	}

	private void resetTp(Model model, HttpServletRequest req) {
		model.addAttribute(CONST.FORM_KEY.getVal(), new RtrnTpModel());
		req.getSession().removeAttribute(CONST.TP_LIST.getVal());
		model.addAttribute(CONST.TP_LIST.getVal(), TpBL.getTypeList(req));
	}
}
