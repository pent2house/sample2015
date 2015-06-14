package com.ns.spring.common.gen;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ns.spring.common.CommonBL;
import com.ns.spring.constant.RtrnConstant.CONST;
import com.ns.spring.model.RMA_HDR_STS;
import com.ns.spring.model.ui.RmaHdrStsModel;
import com.ns.spring.service.template.RmaHdrStsService;

@Component
public class RtrnCommonBL implements BLService {
	
	private static RmaHdrStsService hdrStsSvc;
	
	@Autowired(required = true)
	public void setHdrStsSvc(RmaHdrStsService hdrStsSvc) {
		this.hdrStsSvc = hdrStsSvc;
	}

	@Override
	public List<RmaHdrStsModel> getList() {
		List<RmaHdrStsModel> hdrStsList = new ArrayList<>();
		List<RMA_HDR_STS> stsList = this.hdrStsSvc.findAll();
		if (!CommonBL.isEmpty(stsList)) {
			for (RMA_HDR_STS obj : stsList) {
				hdrStsList.add(new RmaHdrStsModel(obj.getRmaHdrStsCd(), obj.getRmaHdrStsNm()));
			}
		}
		return hdrStsList;
	}

	@SuppressWarnings("unchecked")
	private List<RmaHdrStsModel> getStsList(HttpServletRequest req) {
		List<RmaHdrStsModel> stsList = (List<RmaHdrStsModel>) req.getSession().getAttribute(CONST.HDR_STS_LIST.getVal());
		if (CommonBL.isEmpty(stsList)) {
			// Get fresh data from DB
			stsList = getList();
			req.getSession().setAttribute(CONST.HDR_STS_LIST.getVal(), stsList);
		}
		return stsList;
	}
}
