package com.ns.spring.model.ui;

import java.util.List;

public class RtrnTpModel {

	private String rtrnTpCd;

	private String rtrnTpNm;

	private int sortNum;

	private String radioBtn;

	private List<String> selectedCheckBox;

	public RtrnTpModel() {
	}

	public RtrnTpModel(String rtrnTpCd, String rtrnTpNm) {
		this.rtrnTpCd = rtrnTpCd;
		this.rtrnTpNm = rtrnTpNm;
	}

	public RtrnTpModel(String rtrnTpCd, String rtrnTpNm, int sortNum) {
		this.rtrnTpCd = rtrnTpCd;
		this.rtrnTpNm = rtrnTpNm;
		this.sortNum = sortNum;
	}

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

	public String getRadioBtn() {
		return radioBtn;
	}

	public void setRadioBtn(String radioBtn) {
		this.radioBtn = radioBtn;
	}

	public List<String> getSelectedCheckBox() {
		return selectedCheckBox;
	}

	public void setSelectedCheckBox(List<String> selectedCheckBox) {
		this.selectedCheckBox = selectedCheckBox;
	}

	public String toString() {
		return "Type Code:" + this.rtrnTpCd + ", Name:" + this.rtrnTpNm;
	}
}
