package com.ns.spring.model;

import java.io.Serializable;

public class RtrnTpRsnPk implements Serializable {

	private static final long serialVersionUID = 4677612728077605784L;
	
	private String rtrnTpCd;
	
	private String rtrnRsnCd;
	
	public RtrnTpRsnPk() {
	}

	public RtrnTpRsnPk(String rtrnTpCd, String rtrnRsnCd) {
		this.rtrnTpCd = rtrnTpCd;
		this.rtrnRsnCd = rtrnRsnCd;
	}

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
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RtrnTpRsnPk other = (RtrnTpRsnPk) obj;
		if (rtrnTpCd == null) {
			if (other.rtrnTpCd != null) {
				return false;
			}
		} else if (!rtrnTpCd.equals(other.rtrnTpCd)) {
			return false;
		}
		if (rtrnRsnCd == null) {
			if (other.rtrnRsnCd != null) {
				return false;
			}
		} else if (!rtrnRsnCd.equals(other.rtrnRsnCd)) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rtrnTpCd == null) ? 0 : rtrnTpCd.hashCode());
		result = prime * result	+ ((rtrnRsnCd == null) ? 0 : rtrnRsnCd.hashCode());
		return result;
	}

	public String toString() {
		return "RtrnTpRsnPk#:" + this.rtrnTpCd + ", Line#:" + this.rtrnRsnCd;
	}
}
