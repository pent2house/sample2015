package com.ns.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ns.spring.aop.Loggable;
import com.ns.spring.aop.test.AopTest;
import com.ns.spring.aop.test.AopTestService;
import com.ns.spring.common.CommonBL;
import com.ns.spring.common.RmaBL;
import com.ns.spring.common.RsnBL;
import com.ns.spring.common.TpBL;
import com.ns.spring.common.gen.BLFactory;
import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.RMA_HDR;
import com.ns.spring.model.ui.RmaHdrModel;
import com.ns.spring.model.ui.RtrnRsnModel;
import com.ns.spring.service.template.RmaHdrService;

@Controller
public class RmaController implements RtrnConstant {

	/****** bean defined in servlet-context.xml ******/
	@Autowired(required = true)
	@Qualifier(value = "aopTest")
	private AopTest aopTest;
	
	@Autowired(required = true)
	@Qualifier(value = "aopTestService")
	private AopTestService aopSrv;
	
	@Autowired(required = true)
	private RmaHdrService hdrSvc;

	/**************************************************************************/
	
	@Loggable
	@RequestMapping(value = "/ns-home", method = RequestMethod.GET)
	public ModelAndView initList(Model model, HttpServletRequest req) {
		
		String name = this.aopTest.getName();
		System.out.print("\n NAME 1111: " +name);
		System.out.print("\n");
		
		AopTest e2 = this.aopSrv.getAopTest();
		String name2 = e2.getName();
		System.out.print("\n Name 2222: " +name2);
		System.out.print("\n");
		
		String name3 = this.aopTest.getName();
		System.out.print("\n Name 3333: " +name3);
		System.out.print("\n");
		return getMVMain01(req);
	}
	
	private ModelAndView getMVMain01(HttpServletRequest req) {		

		ModelAndView modelAndView = new ModelAndView(VIEW.MAIN_01.getVal());
		modelAndView.addObject(CONST.FORM_KEY.getVal(), new RmaHdrModel());
		modelAndView.addObject(CONST.HDR_LIST.getVal(), RmaBL.getRmaHdrListWCdTblNm(req));
//		modelAndView.addObject(CONST.TP_LIST.getVal(), TpBL.getTypeList(req));
		setModelViewListByKey(modelAndView, CONST.TP_LIST.getVal());
		modelAndView.addObject(CONST.RSN_LIST.getVal(), RsnBL.getRsnList(req));
		setModelViewListByKey(modelAndView, CONST.HDR_STS_LIST.getVal());

		return modelAndView;
	}

	private void setModelViewListByKey(ModelAndView modelAndView, String key) {
		BLFactory fact = BLFactory.getInstance(key);
		modelAndView.addObject(key, fact.getList());
	}

	// For add and update RMA both
	@RequestMapping(value = "/cUrlValAttrbMain01Jsp", params = "submitHdr", method = RequestMethod.POST)
	public String submitHdr(@ModelAttribute("RmaHdrModel") RmaHdrModel rma, HttpServletRequest req) {
		RmaBL.saveHdr(rma, req);
		return VIEW.REDIRECT_HOME.getVal();
	}

	/** The request sent by the client was syntactically incorrect. */
	@RequestMapping(value = "/submitHdrByJsonMain01", method = RequestMethod.POST)
	public @ResponseBody RmaHdrModel submitHdrByJson(@RequestBody RmaHdrModel rma, HttpServletRequest req) {		
		RMA_HDR obj = RmaBL.saveHdr(rma, req);
		return RmaBL.getRmaHdrModel(obj.getRmaNum());
	}

	@RequestMapping(value = "/onCheckRadioRmaMain01")
	public @ResponseBody RmaHdrModel onCheckRadioRma(@RequestParam(value = "idx") int idx, Model model, HttpServletRequest req) {
		RmaHdrModel rmaHdrModel = new RmaHdrModel(this.hdrSvc.findById(idx));
		model.addAttribute(CONST.FORM_KEY.getVal(), rmaHdrModel);
		return rmaHdrModel;
	}
	
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id, HttpServletRequest req) {
		this.hdrSvc.delete(this.hdrSvc.findById(id));
		req.getSession().removeAttribute(CONST.HDR_LIST.getVal());
		return VIEW.REDIRECT_HOME.getVal();
	}

	// When "edit" link clicked each row
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model, HttpServletRequest req) {

		RMA_HDR obj = this.hdrSvc.findById(id);
		RmaHdrModel rmaHdrModel = RmaBL.getRmaHdrModel(obj.getRmaNum());
		model.addAttribute(CONST.FORM_KEY.getVal(), rmaHdrModel);
		model.addAttribute(CONST.HDR_LIST.getVal(), RmaBL.getRmaHdrListWCdTblNm(req));
		resetComboBoxes(model, req);
		return VIEW.MAIN_01.getVal();
	}

	private void resetComboBoxes(Model model, HttpServletRequest req) {
		TpBL.rtrnTpCombo(model, req);
		RsnBL.rtrnRsnCombo(model, req);
		CommonBL.rmaHdrStsCombo(model, req);
	}

	@RequestMapping(value = "/onChangeTpCdRsnMain01")
	public @ResponseBody List<RtrnRsnModel> refreshRsn(@RequestParam(value = "tpCd") String rtrnTpCd, Model model, HttpServletRequest req) {

		List<RtrnRsnModel> hdrStsList = RsnBL.getRsnsBoundTp(rtrnTpCd);
		model.addAttribute("rtrnTpCd", rtrnTpCd);
		req.getSession().setAttribute(CONST.TP_SELECTED.getVal(), rtrnTpCd);
		return hdrStsList;
	}
}
