package com.ns.spring.model.ui;

public class MdseModel {

	public int id;
	public String mdseCd;
	public String mdseNm;
	public String custCd;

	public MdseModel(int id, String mdseCd) {
		this.id = id;
		this.mdseCd = mdseCd;
	}
	
	public MdseModel(int id, String mdseCd, String mdseNm, String custCd) {
		this.id = id;
		this.mdseCd = mdseCd;
		this.mdseNm = mdseNm;
		this.custCd = custCd;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMdseCd() {
		return mdseCd;
	}

	public void setMdseCd(String mdseCd) {
		this.mdseCd = mdseCd;
	}

	public String getMdseNm() {
		return mdseNm;
	}

	public void setMdseNm(String mdseNm) {
		this.mdseNm = mdseNm;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
}
