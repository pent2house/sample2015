package com.ns.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RTRN_RSN")
public class RTRN_RSN {

	@Id
	@Column(name = "rtrn_rsn_cd")
	private String rtrnRsnCd;
	
	@Column(name = "rtrn_rsn_nm")	
	private String rtrnRsnNm;
	
	@Column(name = "sort_num")	
	private int sortNum;

	public String getRtrnRsnCd() {
		return rtrnRsnCd;
	}

	public void setRtrnRsnCd(String rtrnRsnCd) {
		this.rtrnRsnCd = rtrnRsnCd;
	}

	public String getRtrnRsnNm() {
		return rtrnRsnNm;
	}

	public void setRtrnRsnNm(String rtrnRsnNm) {
		this.rtrnRsnNm = rtrnRsnNm;
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}

	public String toString() {
		return "Reason Code:" + this.rtrnRsnCd + ", Name:" + this.rtrnRsnNm;
	}
}
