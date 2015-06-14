package com.ns.spring.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ns.spring.common.gen.BLFactory;
import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.MDSE;
import com.ns.spring.service.template.MdseService;

@Component
public class CommonBL implements RtrnConstant {
	
	private static MdseService mdseSvc;

	@Autowired(required = true)
	public void setMdseSvc(MdseService mdseSvc) {
		this.mdseSvc = mdseSvc;
	}
	
	public static MDSE getMdse(String key) {
		return mdseSvc.findById(key);
	}

	public static String getMdseNm(MDSE mdse) {
		if (mdse != null) {
			return mdse.getMdseNm();
		}
		return "";
	}

	public static void rmaHdrStsCombo(Model model, HttpServletRequest req) {
		BLFactory fact = BLFactory.getInstance(CONST.HDR_STS_LIST.getVal());
		model.addAttribute(CONST.HDR_STS_LIST.getVal(), fact.getList());
	}

	public static boolean hasValue(String str) {
		if (str != null && str.length() > 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(List<?> list) {
		if (list != null && list.size() > 0) {
			// List is not emplty
			return false;
		}
		return true;
	}
}
