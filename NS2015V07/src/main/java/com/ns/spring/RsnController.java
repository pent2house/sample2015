package com.ns.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ns.spring.common.RsnBL;
import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.RMA_HDR;
import com.ns.spring.model.RTRN_RSN;
import com.ns.spring.model.ui.RtrnRsnModel;
import com.ns.spring.service.template.RtrnRsnService;

@Controller
//@RequestMapping("/cUrlValAttrbSubTpRsn01Jsp")
public class RsnController implements RtrnConstant {
	
	@Autowired(required = true)
	private RtrnRsnService rsnSvc;

	@RequestMapping(value = "/cUrlValAttrbMain01Jsp", params = "goToRsn", method = RequestMethod.POST)
	public String goToRsn(Model model, HttpServletRequest req) {
		model.addAttribute(CONST.FORM_KEY.getVal(), new RtrnRsnModel());
		model.addAttribute(CONST.RSN_LIST.getVal(), RsnBL.getRsnList(req));
		return VIEW.SUB_RSN_01.getVal();
	}

	@RequestMapping(value = "/cUrlValAttrbSubRsn01Jsp", params = "backToRmaFromRsn", method = RequestMethod.POST)
	public String backToRmaFromRsn(@ModelAttribute("rma_hdr") RMA_HDR rma) {
		return VIEW.REDIRECT_HOME.getVal();
	}

	@RequestMapping(value = "/cUrlValAttrbSubRsn01Jsp", params = "addReason", method = RequestMethod.POST)
	private String addRtrnTp(@ModelAttribute("RTRN_RSN") RTRN_RSN rsn, Model model, HttpServletRequest req) {
		if (RsnBL.hasRsnCd(rsn)) {
			this.rsnSvc.save(rsn);
			RsnBL.resetRsn(model, req);
		}		
		return VIEW.SUB_RSN_01.getVal();
	}

	@RequestMapping("/removeReason/{rtrnRsnCd}")
	public String removeRtrnRsn(@PathVariable("rtrnRsnCd") String rtrnRsnCd, Model model, HttpServletRequest req) {
		RTRN_RSN rsn = this.rsnSvc.findById(rtrnRsnCd);
		if (rsn != null) {
			this.rsnSvc.delete(rsn);
			RsnBL.resetRsn(model, req);
		}		
		return VIEW.SUB_RSN_01.getVal();
	}
}
