package com.ns.spring.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.ui.RtrnRsnModel;
import com.ns.spring.model.ui.RtrnTpModel;

@Component
public class TpRsnBL implements RtrnConstant {

	@SuppressWarnings("unchecked")
	public static List<String> getRsnToBound(RtrnTpModel tp, HttpServletRequest req) {

		List<String> selectedCheckBox = tp.getSelectedCheckBox();
		List<String> rsnListToBound = new ArrayList<String>();
		if (!CommonBL.isEmpty(selectedCheckBox)) {
			for (String code : selectedCheckBox) {
				rsnListToBound.add(code);
			}
			List<RtrnRsnModel> boundRsnList = (List<RtrnRsnModel>) req.getSession().getAttribute(CONST.RSN_LIST_BOUND.getVal());
			if (!CommonBL.isEmpty(boundRsnList)) {
				for (RtrnRsnModel rsn : boundRsnList) {
					String code = (String) rsn.getRtrnRsnCd();
					rsnListToBound.add(code);
				}
			}
		}
		return rsnListToBound;
	}

	public static void setNewRsnList(List<RtrnRsnModel> newList, List<RtrnRsnModel> list) {
		for (RtrnRsnModel obj : list) {
			newList.add(obj);
		}
	}
}
