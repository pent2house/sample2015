package com.ns.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ns.spring.model.ui.RmaHdrModel;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "RMA_HDR")
public class RMA_HDR {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rma_num")
	private String rmaNum;
	
	@Column(name = "rma_hdr_sts_cd")
	private String rmaHdrStsCd;

	@Column(name = "rtrn_tp_cd")
	private String rtrnTpCd;

	@Column(name = "rtrn_rsn_cd")
	private String rtrnRsnCd;

	@Column(name = "sell_to_cust_cd")
	private String sellToCustCd;

	@OneToMany(mappedBy = "rmaHdr", targetEntity = RMA_LINE.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<RMA_LINE> rmaLines;
	
	public RMA_HDR(){}

	public RMA_HDR(RmaHdrModel hdr) {
		this.id = hdr.getId();
		this.rmaNum = hdr.getRmaNum();
		this.rmaHdrStsCd = hdr.getRmaHdrStsCd();
		this.rtrnTpCd = hdr.getRtrnTpCd();
		this.rtrnRsnCd = hdr.getRtrnRsnCd();
		this.sellToCustCd = hdr.getSellToCustCd();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRmaNum() {
		return rmaNum;
	}

	public void setRmaNum(String rmaNum) {
		this.rmaNum = rmaNum;
	}

	public String getRmaHdrStsCd() {
		return rmaHdrStsCd;
	}

	public void setRmaHdrStsCd(String rmaHdrStsCd) {
		this.rmaHdrStsCd = rmaHdrStsCd;
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

	public String getSellToCustCd() {
		return sellToCustCd;
	}

	public void setSellToCustCd(String sellToCustCd) {
		this.sellToCustCd = sellToCustCd;
	}

	public List<RMA_LINE> getRmaLines() {
		return rmaLines;
	}

	public void setRmaLines(List<RMA_LINE> rmaLines) {
		this.rmaLines = rmaLines;
	}
	
	public String toString() {
		return "ID:" + this.id + ", RMA_NUM:" + this.rmaNum + ", Status:" + this.rmaHdrStsCd + ", Type:" + this.rtrnTpCd + ", Reason:" + this.rtrnRsnCd;
	}
}
