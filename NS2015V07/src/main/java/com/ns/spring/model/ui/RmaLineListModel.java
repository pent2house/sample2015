package com.ns.spring.model.ui;

import java.util.ArrayList;
import java.util.List;

public class RmaLineListModel {

	private String rmaNum = "";
	private String mdseCd = "";
	private List<String> selectedCheckBox = new ArrayList<String>();
	private List<RmaLineModel> rmaLineModelList = new ArrayList<RmaLineModel>();

	public RmaLineListModel() {
	}

	public RmaLineListModel(String rmaNum) {
		this.rmaNum = rmaNum;
	}

	public RmaLineListModel(String rmaNum, List<RmaLineModel> rmaLineModelList) {
		this.rmaNum = rmaNum;
		this.rmaLineModelList = rmaLineModelList;
	}

	public String getRmaNum() {
		return rmaNum;
	}

	public void setRmaNum(String rmaNum) {
		this.rmaNum = rmaNum;
	}

	public String getMdseCd() {
		return mdseCd;
	}

	public void setMdseCd(String mdseCd) {
		this.mdseCd = mdseCd;
	}

	public List<String> getSelectedCheckBox() {
		return selectedCheckBox;
	}

	public void setSelectedCheckBox(List<String> selectedCheckBox) {
		this.selectedCheckBox = selectedCheckBox;
	}

	public List<RmaLineModel> getRmaLineModelList() {
		return rmaLineModelList;
	}

	public void setRmaLineModelList(List<RmaLineModel> rmaLineModelList) {
		this.rmaLineModelList = rmaLineModelList;
	}
}
