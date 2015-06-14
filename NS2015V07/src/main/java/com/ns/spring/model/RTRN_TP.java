package com.ns.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RTRN_TP")
public class RTRN_TP {

	@Id
	@Column(name = "rtrn_tp_cd")
	private String rtrnTpCd;

	@Column(name = "rtrn_tp_nm")
	private String rtrnTpNm;

	@Column(name = "sort_num")
	private int sortNum;

	@ManyToMany(targetEntity = RTRN_RSN.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "RTRN_TP_RSN_CMBN", 
				joinColumns = { @JoinColumn(name = "rtrn_tp_cd") }, 
				inverseJoinColumns = { @JoinColumn(name = "rtrn_rsn_cd") })
	private Set<RTRN_RSN> rtrnRsns = new HashSet<RTRN_RSN>();

	public String getRtrnTpCd() {
		return rtrnTpCd;
	}

	public void setRtrnTpCd(String rtrnTpCd) {
		this.rtrnTpCd = rtrnTpCd;
	}

	public String getRtrnTpNm() {
		return rtrnTpNm;
	}

	public void setRtrnTpNm(String rtrnTpNm) {
		this.rtrnTpNm = rtrnTpNm;
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}

	public Set<RTRN_RSN> getRtrnRsns() {
		return rtrnRsns;
	}

	public void setRtrnRsns(Set<RTRN_RSN> rtrnRsns) {
		this.rtrnRsns = rtrnRsns;
	}

	public String toString() {
		return "Type Code:" + this.rtrnTpCd + ", Name:" + this.rtrnTpNm;
	}
}
