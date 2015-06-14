package com.ns.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MDSE")
public class MDSE {

	@Id
	@Column(name = "mdse_cd")
	private String mdseCd;

	@Column(name = "mdse_nm")
	private String mdseNm;

	@Column(name = "cust_cd")
	private String custCd;

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

	public String toString() {
		return "MDSE Code:" + this.mdseCd + ", Name:" + this.mdseNm;
	}
}
