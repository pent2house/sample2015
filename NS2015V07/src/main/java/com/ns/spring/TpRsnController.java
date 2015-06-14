package com.ns.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ns.spring.common.CommonBL;
import com.ns.spring.common.RmaBL;
import com.ns.spring.common.RsnBL;
import com.ns.spring.common.TpBL;
import com.ns.spring.common.TpRsnBL;
import com.ns.spring.common.gen.BLFactory;
import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.RTRN_RSN;
import com.ns.spring.model.RTRN_TP;
import com.ns.spring.model.RTRN_TP_RSN_CMBN;
import com.ns.spring.model.ui.RmaHdrModel;
import com.ns.spring.model.ui.RtrnRsnModel;
import com.ns.spring.model.ui.RtrnTpModel;
import com.ns.spring.service.template.RtrnRsnService;
import com.ns.spring.service.template.RtrnTpRsnService;
import com.ns.spring.service.template.RtrnTpService;

@Controller
public class TpRsnController implements RtrnConstant {

	@Autowired(required = true)
	private RtrnTpService tpSvc;

	@Autowired(required = true)
	private RtrnRsnService rsnSvc;

	@Autowired(required = true)
	private RtrnTpRsnService tpRsnSvc;

	@RequestMapping(value = "/cUrlValAttrbMain01Jsp", params = "goToTpRsn", method = RequestMethod.POST)
	public ModelAndView goToTpRsn(ModelMap model, HttpServletRequest req) {
		return getMVSubTpRsn01(model, req);
	}

	@RequestMapping(value = "/cUrlValAttrbSubTpRsn01Jsp", params = "backToRmaFromTpRsn", method = RequestMethod.POST)
	public ModelAndView backToRmaFromTpRsn(Model model, HttpServletRequest req) {
		return getMVMain01(req);
	}

	@RequestMapping(value = "/cUrlValAttrbSubTpRsn01Jsp", params = "toBoundRsnList", method = RequestMethod.POST)
	public ModelAndView toBoundRsnList(@ModelAttribute("RtrnTpModel") RtrnTpModel tp, ModelMap model, HttpServletRequest req) {

		String tpSelected = (String) req.getSession().getAttribute(CONST.TP_SELECTED.getVal());
		if (CommonBL.hasValue(tpSelected)) {
			RTRN_TP tpObj = this.tpSvc.findById(tpSelected);
			if (tpObj != null) {
				List<String> selectedCheckBox = TpRsnBL.getRsnToBound(tp, req);
				if (!CommonBL.isEmpty(selectedCheckBox)) {
					Set<RTRN_RSN> rtrnRsns = new HashSet<RTRN_RSN>();
					for (String code : selectedCheckBox) {
						RTRN_RSN rsnObj = this.rsnSvc.findById(code);
						if (rsnObj != null) {
							rtrnRsns.add(rsnObj);
							tpObj.setRtrnRsns(rtrnRsns);
							this.tpSvc.saveOrUpdate(tpObj);
						}
					}
				}
			}
		}
		return getMVSubTpRsn01(model, req);
	}

	@RequestMapping(value = "/cUrlValAttrbSubTpRsn01Jsp", params = "toUnBoundRsnList", method = RequestMethod.POST)
	public ModelAndView toUnBoundRsnList(@ModelAttribute("RtrnTpModel") RtrnTpModel tp, ModelMap model, HttpServletRequest req) {

		String tpSelected = (String) req.getSession().getAttribute(CONST.TP_SELECTED.getVal());
		if (CommonBL.hasValue(tpSelected)) {
			List<String> selectedCheckBox = tp.getSelectedCheckBox();
			if (!CommonBL.isEmpty(selectedCheckBox)) {
				for (String code : selectedCheckBox) {
					RTRN_TP_RSN_CMBN tpRsnObj = this.tpRsnSvc.getTpRsnCmbnByHql(tpSelected, code);
					if (tpRsnObj != null) {
						this.tpRsnSvc.delete(tpRsnObj);
					}
				}
			}
		}
		return getMVSubTpRsn01(model, req);
	}

	@RequestMapping(value = "/cUrlValAttrbSubTpRsn01Jsp", method = RequestMethod.POST)
	public String onChangeTpRsn(@RequestParam("rtrnTpCd") String rtrnTpCd, Model model, HttpServletRequest req) {
		createRtrnTpCombo(model, req);
		refreshCombos(model, req);
		model.addAttribute(CONST.TP_SELECTED.getVal(), rtrnTpCd);
		RtrnTpModel tpObj = TpBL.getTpByKey(rtrnTpCd);
		if (tpObj != null) {
			model.addAttribute("rtrnTpCd", rtrnTpCd);
		}
		return VIEW.SUB_TP_RSN_01.getVal();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/onChangeTpCdTpRsn01")
	public @ResponseBody List<RtrnRsnModel> refreshTypeComb(@RequestParam(value = "tpCd") String rtrnTpCd, Model model, HttpServletRequest req) {

		model.addAttribute(CONST.FORM_KEY.getVal(), new RtrnTpModel());
		model.addAttribute("rtrnTpCd", rtrnTpCd);
		model.addAttribute(CONST.TP_SELECTED.getVal(), rtrnTpCd);
		req.getSession().setAttribute(CONST.TP_SELECTED.getVal(), rtrnTpCd);
		initBoundUnboundRsnList(rtrnTpCd, req);

		List<RtrnRsnModel> rsnBoundList = (List<RtrnRsnModel>)req.getSession().getAttribute(CONST.RSN_LIST_BOUND.getVal());
		List<RtrnRsnModel> rsnUnBoundList = (List<RtrnRsnModel>)req.getSession().getAttribute(CONST.RSN_LIST_UNBOUND.getVal());
		List<RtrnRsnModel> rsnList = new ArrayList<RtrnRsnModel>();
		TpRsnBL.setNewRsnList(rsnList, rsnBoundList);
		TpRsnBL.setNewRsnList(rsnList, rsnUnBoundList);		
		return rsnList;
	}

	private ModelAndView getMVMain01(HttpServletRequest req) {		

		ModelAndView modelAndView = new ModelAndView(VIEW.MAIN_01.getVal());
		modelAndView.addObject(CONST.FORM_KEY.getVal(), new RmaHdrModel());
		modelAndView.addObject(CONST.HDR_LIST.getVal(), RmaBL.getRmaHdrListWCdTblNm(req));		
		modelAndView.addObject(CONST.TP_LIST.getVal(), TpBL.getTypeList(req));
		modelAndView.addObject(CONST.RSN_LIST.getVal(), RsnBL.getRsnList(req));
		setModelViewListByKey(modelAndView, CONST.HDR_STS_LIST.getVal());

		return modelAndView;
	}

	private void setModelViewListByKey(ModelAndView modelAndView, String key) {
		BLFactory fact = BLFactory.getInstance(key);
		modelAndView.addObject(key, fact.getList());
	}

	private void refreshCombos(Model model, HttpServletRequest req) {
		model.addAttribute(CONST.FORM_KEY.getVal(), new RtrnTpModel());
		model.addAttribute(CONST.TP_LIST.getVal(), TpBL.getRtrnTpModelList());
		model.addAttribute(CONST.RSN_LIST.getVal(), RsnBL.getRtrnRsnModelList());
	}

	private ModelAndView getMVSubTpRsn01(ModelMap model, HttpServletRequest req) {
		String tpSelectedMain01 = (String) req.getSession().getAttribute(CONST.TP_SELECTED.getVal());
		List<RtrnTpModel> rtrnTpModelList = TpBL.getTypeList(req);

		ModelAndView modelAndView = new ModelAndView(VIEW.SUB_TP_RSN_01.getVal());
		modelAndView.addObject(CONST.FORM_KEY.getVal(), new RtrnTpModel());
		modelAndView.addObject(CONST.TP_SELECTED.getVal(), tpSelectedMain01);
		modelAndView.addObject(CONST.TP_LIST.getVal(), rtrnTpModelList);
		
		initBoundUnboundRsnList(tpSelectedMain01, req);
		modelAndView.addObject(CONST.RSN_LIST_BOUND.getVal(), req.getSession().getAttribute(CONST.RSN_LIST_BOUND.getVal()));
		modelAndView.addObject(CONST.RSN_LIST_UNBOUND.getVal(), req.getSession().getAttribute(CONST.RSN_LIST_UNBOUND.getVal()));

		return modelAndView;
	}

	private void initBoundUnboundRsnList(String tpSelected, HttpServletRequest req) {		
		req.getSession().setAttribute(CONST.RSN_LIST_BOUND.getVal(), RsnBL.getRsnsBoundTp(tpSelected));
		req.getSession().setAttribute(CONST.RSN_LIST_UNBOUND.getVal(), RsnBL.getRsnsUnBoundTp(tpSelected));
	}

	private void createRtrnTpCombo(Model model, HttpServletRequest req) {
		model.addAttribute(CONST.TP_LIST.getVal(), TpBL.getTypeList(req));
	}
}
