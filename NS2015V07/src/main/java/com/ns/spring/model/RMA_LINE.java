package com.ns.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "RMA_LINE")
public class RMA_LINE {

	@Id
	private RmaLinePk rmaLinePk;

	@Column(name = "rma_line_sts_cd")
	private String rmaLineStsCd;

	@Column(name = "mdse_cd")
	private String mdseCd;

	@Column(name = "qty")
	private int qty;

	@ManyToOne
	@JoinColumn(name = "rma_id")
	private RMA_HDR rmaHdr;
	
	public RMA_LINE(){}

	public RmaLinePk getRmaLinePk() {
		return rmaLinePk;
	}

	public void setRmaLinePk(RmaLinePk rmaLinePk) {
		this.rmaLinePk = rmaLinePk;
	}

	public String getRmaLineStsCd() {
		return rmaLineStsCd;
	}

	public void setRmaLineStsCd(String rmaLineStsCd) {
		this.rmaLineStsCd = rmaLineStsCd;
	}

	public String getMdseCd() {
		return mdseCd;
	}

	public void setMdseCd(String mdseCd) {
		this.mdseCd = mdseCd;
	}

	public RMA_HDR getRmaHdr() {
		return rmaHdr;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setRmaHdr(RMA_HDR rmaHdr) {
		this.rmaHdr = rmaHdr;
	}

	public String toString() {
		return "PK:" + this.rmaLinePk.toString() + ", Line Status:" + this.rmaLineStsCd + ", Mdse:" + this.mdseCd + ", Qty:" + this.qty;
	}
}
