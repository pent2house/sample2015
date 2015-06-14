package com.ns.spring.model.ui;

import java.util.ArrayList;
import java.util.List;

public class RmaLineModel {

	private String rmaNum = "";
	private String rmaLineNum = "";
	private String rmaLineStsCd = "";
	private String rmaLineStsNm = "";
	private String mdseCd = "";
	private String mdseNm = "";
	private int qty;
	private int rmaId;
	private List<String> selectedCheckBox = new ArrayList<String>();
	
	public RmaLineModel(){}
	
	public RmaLineModel(Object[] array) {
		this.rmaNum = (String)array[0];
		this.rmaLineNum = (String)array[1];
		this.rmaLineStsCd = (String)array[2];
		this.rmaLineStsNm = (String)array[3];
		this.mdseCd = (String)array[4];
		this.mdseNm = (String)array[5];
		this.qty = (Integer)array[6];
		this.rmaId = (Integer)array[7];
	}

	public RmaLineModel(
			String rmaNum, 
			String rmaLineNum, 
			String rmaLineStsCd,
			String mdseCd, 
			int qty, 
			int rmaId) {
		this.rmaNum = rmaNum;
		this.rmaLineNum = rmaLineNum;
		this.rmaLineStsCd = rmaLineStsCd;
		this.mdseCd = mdseCd;
		this.qty = qty;
		this.rmaId = rmaId;
	}

	public RmaLineModel(String rmaNum) {
		this.rmaNum = rmaNum;
	}

	public String getRmaNum() {
		return rmaNum;
	}

	public void setRmaNum(String rmaNum) {
		this.rmaNum = rmaNum;
	}

	public String getRmaLineNum() {
		return rmaLineNum;
	}

	public void setRmaLineNum(String rmaLineNum) {
		this.rmaLineNum = rmaLineNum;
	}

	public String getRmaLineStsCd() {
		return rmaLineStsCd;
	}

	public void setRmaLineStsCd(String rmaLineStsCd) {
		this.rmaLineStsCd = rmaLineStsCd;
	}

	public String getRmaLineStsNm() {
		return rmaLineStsNm;
	}

	public void setRmaLineStsNm(String rmaLineStsNm) {
		this.rmaLineStsNm = rmaLineStsNm;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getRmaId() {
		return rmaId;
	}

	public void setRmaId(int rmaId) {
		this.rmaId = rmaId;
	}
	
	public List<String> getSelectedCheckBox() {
		return selectedCheckBox;
	}

	public void setSelectedCheckBox(List<String> selectedCheckBox) {
		this.selectedCheckBox = selectedCheckBox;
	}
}
