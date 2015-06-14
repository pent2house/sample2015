package com.ns.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RTRN_TP_RSN_CMBN")
public class RTRN_TP_RSN_CMBN implements Serializable {

	private static final long serialVersionUID = 4677612728077605784L;

	@Id
	@Column(name = "rtrn_tp_cd")
	private String rtrnTpCd;
	
	@Id
	@Column(name = "rtrn_rsn_cd")
	private String rtrnRsnCd;
	
	public String getRtrnTpCd() {
		return rtrnTpCd;
	}

	public void setRtrnTpCd(String rtrnTpCd) {
		this.rtrnTpCd = rtrnTpCd;
	}

	public String getRtrnRsnCd() {
		return rtrnRsnCd;
	}

	public void setRtrnRsnCd(String rtrnRsnCd) {
		this.rtrnRsnCd = rtrnRsnCd;
	}
	
	public String toString() {
		return "Type" + this.rtrnTpCd + ", Reason:" + this.rtrnRsnCd;
	}
}
