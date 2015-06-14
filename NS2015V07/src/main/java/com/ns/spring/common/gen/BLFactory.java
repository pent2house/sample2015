package com.ns.spring.common.gen;

import java.util.List;

import com.ns.spring.constant.RtrnConstant;

public class BLFactory implements RtrnConstant {

	private BLService svc;

	private BLFactory(String param) {
		if (CONST.HDR_STS_LIST.getVal().equals(param)) {
			this.svc = new RtrnCommonBL();
		} else if (CONST.TP_LIST.getVal().equals(param)) {
			this.svc = new TpCommonBL();
		} else if (CONST.MDSE_LIST.getVal().equals(param)) {
			this.svc = new MdseCommonBL();
		}
	}

	// static factory
	public static BLFactory getInstance(String param) {
		return new BLFactory(param);
	}

	public List<?> getList() {
		return this.svc.getList();
	}
}
