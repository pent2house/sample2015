package com.ns.spring.common.gen;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ns.spring.common.CommonBL;
import com.ns.spring.constant.RtrnConstant.CONST;
import com.ns.spring.model.MDSE;
import com.ns.spring.model.RMA_HDR_STS;
import com.ns.spring.model.RTRN_TP;
import com.ns.spring.model.ui.MdseModel;
import com.ns.spring.model.ui.RmaHdrStsModel;
import com.ns.spring.model.ui.RtrnTpModel;
import com.ns.spring.service.template.MdseService;
import com.ns.spring.service.template.RmaHdrStsService;
import com.ns.spring.service.template.RtrnTpService;

@Component
public class MdseCommonBL implements BLService {

	private static MdseService mdseSvc;
	
	@Autowired(required = true)
	public void setMdseSvc(MdseService mdseSvc) {
		this.mdseSvc = mdseSvc;
	}

	@Override
	public List<MdseModel> getList() {
		List<MdseModel> mdseModelList = new ArrayList<>();
		List<MDSE> mdseList = mdseSvc.findAll();
		if (!CommonBL.isEmpty(mdseList)) {
			for (int i = 0; i < mdseList.size(); i++) {
				MDSE obj = (MDSE) mdseList.get(i);
				mdseModelList.add(new MdseModel(i, obj.getMdseCd()));
			}
		}
		return mdseModelList;
	}
}
