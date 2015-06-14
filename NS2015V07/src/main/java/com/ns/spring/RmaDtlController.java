package com.ns.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ns.spring.common.CommonBL;
import com.ns.spring.common.RmaDtlBL;
import com.ns.spring.common.gen.BLFactory;
import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.ui.MdseModel;
import com.ns.spring.model.ui.RmaLineListModel;
import com.ns.spring.model.ui.RmaLineModel;
import com.ns.spring.service.template.RmaLineService;

@Controller
public class RmaDtlController implements RtrnConstant {
	
	@Autowired(required = true)
	private RmaLineService rmaLineSvc;

	@RequestMapping("/cUrlValSubLine01Jsp/{rmaNum}")
	public ModelAndView goToSubLine01Jsp(@PathVariable("rmaNum") String rmaNum,	Model model, HttpServletRequest req) {
		List<RmaLineModel> rmaLineModelList = RmaDtlBL.getRmaLineListWithCdTblNm(rmaNum, null);
		return getMVSubLine01(rmaNum, rmaLineModelList, req);
	}

	@RequestMapping(value = "/cUrlValAttrbSubLine01Jsp", params = "backToRmaFromSubLine01", method = RequestMethod.POST)
	public String backToRmaFromSubLine01(HttpServletRequest req) {
		req.getSession().removeAttribute(CONST.RMA_NUM.getVal());
		return VIEW.REDIRECT_HOME.getVal();
	}

	@RequestMapping(value = "/cUrlValAttrbSubLine01Jsp", params = "submitLine", method = RequestMethod.POST)
	public ModelAndView submitLine(@ModelAttribute("rmaLineListModel") RmaLineListModel rmaLineListModel, Model model, HttpServletRequest req) {

		String rmaNum = rmaLineListModel.getRmaNum();
		List<RmaLineModel> currList = rmaLineListModel.getRmaLineModelList();
		if (!CommonBL.isEmpty(currList)) {
			for (RmaLineModel obj : currList) {
				String rmaLineNum = obj.getRmaLineNum();
				List<RmaLineModel> rmaLinsList = RmaDtlBL.getRmaLineListWithCdTblNm(rmaNum, rmaLineNum);
				if (CommonBL.isEmpty(rmaLinsList)) {
					// New Record
					this.rmaLineSvc.save(RmaDtlBL.getRmaLineObj(obj, rmaNum, rmaLineNum));
				}
			}
		}
		List<RmaLineModel> rmaLineModelList = RmaDtlBL.getRmaLineListWithCdTblNm(rmaNum, null);
		return getMVSubLine01(rmaNum, rmaLineModelList, req);
	}

	@RequestMapping(value = "/cUrlValAttrbSubLine01Jsp", params = "addItemSubLine01", method = RequestMethod.POST)
	public ModelAndView addItemSubLine01(@ModelAttribute("rmaLineListModel") RmaLineListModel rmaLineListModel, Model model, HttpServletRequest req) {
		
		ModelAndView modelAndView = new ModelAndView(VIEW.SUB_LINE_01.getVal());
		modelAndView.addObject(CONST.FORM_KEY.getVal(), rmaLineListModel);

		String rmaNum = rmaLineListModel.getRmaNum();
		String mdseCd = rmaLineListModel.getMdseCd();
		
		String mdseNm = CommonBL.getMdseNm(CommonBL.getMdse(mdseCd));
		List<RmaLineModel> currList = rmaLineListModel.getRmaLineModelList();
		
		RmaLineModel newRow = new RmaLineModel();
		newRow.setRmaNum(rmaNum);
		newRow.setRmaLineNum(RmaDtlBL.getNewLineNum(currList));
		newRow.setMdseCd(mdseCd);
		newRow.setMdseNm(mdseNm);
		currList.add(newRow);

		rmaLineListModel.setRmaLineModelList(currList);		
		modelAndView.addObject(CONST.LINE_LIST_MODEL.getVal(), rmaLineListModel);
		modelAndView.addObject(CONST.HDR_STS_LIST.getVal(), getList(CONST.HDR_STS_LIST.getVal()));
		return modelAndView;
	}

	@RequestMapping(value = "/cUrlValAttrbSubLine01Jsp", params = "deleteLine", method = RequestMethod.POST)
	public ModelAndView deleteLine(@ModelAttribute("rmaLineListModel") RmaLineListModel rmaLineListModel, Model model, HttpServletRequest req) {

		String rmaNum = rmaLineListModel.getRmaNum();
		List<String> selectedCheckBox = rmaLineListModel.getSelectedCheckBox();
		List<RmaLineModel> currList = rmaLineListModel.getRmaLineModelList();

		List<RmaLineModel> newList = new ArrayList<>();
		for (RmaLineModel currLine : currList) {
			String currLineNum = currLine.getRmaLineNum();
			if (RmaDtlBL.isSelectedLine(currLineNum, selectedCheckBox)) {
				RmaDtlBL.deleteRmaLine(rmaNum, currLineNum);
				continue;
			}
			newList.add(currLine);
		}
		return getMVSubLine01(rmaNum, newList, req);
	}

	private ModelAndView getMVSubLine01(String rmaNum, List<RmaLineModel> rmaLinsList, HttpServletRequest req) {

		RmaLineListModel newModel = new RmaLineListModel(rmaNum, rmaLinsList);

		ModelAndView modelAndView = new ModelAndView(VIEW.SUB_LINE_01.getVal());
		modelAndView.addObject(CONST.FORM_KEY.getVal(), newModel);
		// For item detail list
		modelAndView.addObject(CONST.LINE_LIST_MODEL.getVal(), newModel);
		// Setup Status drop down line the item list
		modelAndView.addObject(CONST.HDR_STS_LIST.getVal(), getList(CONST.HDR_STS_LIST.getVal()));
		// Item list for AJAX Auto complete
		req.getSession().setAttribute(CONST.MDSE_LIST.getVal(), getList(CONST.MDSE_LIST.getVal()));
		return modelAndView;
	}

	private List<?> getList(String key) {
		BLFactory fact = BLFactory.getInstance(key);
		return fact.getList();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/autoCompleteList", method = RequestMethod.GET)
	public @ResponseBody List<MdseModel> getTags(@RequestParam(value = "inputVal") String inputVal, HttpServletRequest req) {
		List<MdseModel> entireSessionList = (List<MdseModel>)req.getSession().getAttribute(CONST.MDSE_LIST.getVal());
		List<MdseModel> resultList = new ArrayList<MdseModel>();
		if (!CommonBL.isEmpty(entireSessionList)) {
			for (MdseModel obj : entireSessionList) {
				// Fuzzy search
				if (obj.getMdseCd().contains(inputVal)) {
					resultList.add(obj);
				}
			}
		}
		return resultList;
	}
}
