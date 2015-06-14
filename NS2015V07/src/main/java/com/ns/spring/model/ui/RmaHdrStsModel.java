package com.ns.spring.model.ui;

public class RmaHdrStsModel {

	private String rmaHdrStsCd;

	private String rmaHdrStsNm;

	public RmaHdrStsModel(String rmaHdrStsCd, String rmaHdrStsNm) {
		this.rmaHdrStsCd = rmaHdrStsCd;
		this.rmaHdrStsNm = rmaHdrStsNm;
	}
	
	public String getRmaHdrStsCd() {
		return rmaHdrStsCd;
	}

	public void setRmaHdrStsCd(String rmaHdrStsCd) {
		this.rmaHdrStsCd = rmaHdrStsCd;
	}

	public String getRmaHdrStsNm() {
		return rmaHdrStsNm;
	}

	public void setRmaHdrStsNm(String rmaHdrStsNm) {
		this.rmaHdrStsNm = rmaHdrStsNm;
	}
}
