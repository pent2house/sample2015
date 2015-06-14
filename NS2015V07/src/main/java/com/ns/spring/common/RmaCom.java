package com.ns.spring.common;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.RMA_HDR;
import com.ns.spring.model.ui.RmaHdrModel;
import com.ns.spring.service.template.RmaHdrService;

//@Component
public class RmaCom implements RtrnConstant {

//	private RmaHdrService hdrSvc;
//
//	@Autowired(required = true)
//	public void setHdrSvc(RmaHdrService hdrSvc) {
//		this.hdrSvc = hdrSvc;
//	}
//
//	public List<Object[]> getRmaHdrListObj(String rmaNum) {
//		return hdrSvc.getListRmaHdrBySql(rmaNum);
//	}
//
//	public RMA_HDR saveHdr(RmaHdrModel rma, HttpServletRequest req) {
//		RMA_HDR obj = new RMA_HDR(rma);
//		if (rma.getId() == 0) {
//			hdrSvc.save(obj);
//			// Set RMA# with formatted
//			DecimalFormat df = new DecimalFormat("000000");
//			obj.setRmaNum("RMA" + df.format((double) obj.getId()));
//		}
//		hdrSvc.update(obj);
//		req.getSession().removeAttribute(CONST.HDR_LIST.getVal());
//		return obj;
//	}
//
//	public RMA_HDR getRmaHdrObj(String rmaNum) {
//		List<Object[]> rmaHdrList = getRmaHdrListObj(rmaNum);
//		if (!CommonBL.isEmpty(rmaHdrList)) {
//			Object[] objArr = rmaHdrList.get(0);
//			int id = (Integer) objArr[0];
//			return hdrSvc.findById(id);
//		}
//		return null;
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<RmaHdrModel> getRmaHdrListWCdTblNm(HttpServletRequest req) {
//		List<RmaHdrModel> hdrList = (List<RmaHdrModel>) req.getSession().getAttribute(CONST.HDR_LIST.getVal());
//		if (CommonBL.isEmpty(hdrList)) {
//			// Get fresh data from DB
//			hdrList = getRmaHdrListWithCdTblNm(null);
//			req.getSession().setAttribute(CONST.HDR_LIST.getVal(), hdrList);
//		}
//		return hdrList;
//	}
//
//	public RmaHdrModel getRmaHdrModel(String rmaNum) {
//		List<RmaHdrModel> rmaHdrModelList = getRmaHdrListWithCdTblNm(rmaNum);
//		return rmaHdrModelList.get(0);
//	}
//
//	public List<RmaHdrModel> getRmaHdrListWithCdTblNm(String rmaNum) {
//		List<RmaHdrModel> modelList = new ArrayList<>();
//		List<Object[]> rmaHdrList = getRmaHdrListObj(rmaNum);
//		if (!CommonBL.isEmpty(rmaHdrList)) {
//			for (Object[] array : rmaHdrList) {
//				modelList.add(new RmaHdrModel(array));
//			}
//		}
//		return modelList;
//	}
}
