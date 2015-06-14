package com.ns.spring.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RmaLinePk implements Serializable {

	private static final long serialVersionUID = -403250971215465050L;

	private String rma_num;

	private String rma_line_num;

	public RmaLinePk() {
	}

	public RmaLinePk(String rma_num, String rma_line_num) {
		this.rma_num = rma_num;
		this.rma_line_num = rma_line_num;
	}

	public String getRma_num() {
		return rma_num;
	}

	public void setRma_num(String rma_num) {
		this.rma_num = rma_num;
	}

	public String getRma_line_num() {
		return rma_line_num;
	}

	public void setRma_line_num(String rma_line_num) {
		this.rma_line_num = rma_line_num;
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
		RmaLinePk other = (RmaLinePk) obj;
		if (rma_num == null) {
			if (other.rma_num != null) {
				return false;
			}
		} else if (!rma_num.equals(other.rma_num)) {
			return false;
		}
		if (rma_line_num == null) {
			if (other.rma_line_num != null) {
				return false;
			}
		} else if (!rma_line_num.equals(other.rma_line_num)) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rma_num == null) ? 0 : rma_num.hashCode());
		result = prime * result	+ ((rma_line_num == null) ? 0 : rma_line_num.hashCode());
		return result;
	}

	public String toString() {
		return "RmaLinePk:RMA#:" + this.rma_num + ", Line#:" + this.rma_line_num;
	}
}
