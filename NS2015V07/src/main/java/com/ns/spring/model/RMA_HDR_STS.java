package com.ns.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RMA_HDR_STS")
public class RMA_HDR_STS {

	@Id
	@Column(name = "rma_hdr_sts_cd")
	private String rmaHdrStsCd;

	@Column(name = "rma_hdr_sts_nm")
	private String rmaHdrStsNm;

	@Column(name = "sort_num")
	private int sortNum;

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

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}

	public String toString() {
		return "RMA_HDR_STS Code:" + this.rmaHdrStsCd + ", Name:" + this.rmaHdrStsNm;
	}
}
