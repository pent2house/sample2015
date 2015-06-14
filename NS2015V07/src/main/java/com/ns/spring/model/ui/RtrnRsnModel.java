package com.ns.spring.model.ui;

import java.util.List;

/**
 * @author nobukimi
 *
 */
public class RtrnRsnModel {

	private String rtrnRsnCd;

	private String rtrnRsnNm;

	private int sortNum;

	private String rtrnTpCd;

//	private List<String> selectedCheckBox;

	private List<RtrnRsnModel> rtrnRsnModelList;

	public RtrnRsnModel() {
	}

	public RtrnRsnModel(String rtrnRsnCd, String rtrnRsnNm, String rtrnTpCd) {
		this.rtrnRsnCd = rtrnRsnCd;
		this.rtrnRsnNm = rtrnRsnNm;
		this.rtrnTpCd = rtrnTpCd;
	}

	public RtrnRsnModel(String rtrnRsnCd, String rtrnRsnNm, int sortNum, String rtrnTpCd) {
		this.rtrnRsnCd = rtrnRsnCd;
		this.rtrnRsnNm = rtrnRsnNm;
		this.sortNum = sortNum;
		this.rtrnTpCd = rtrnTpCd;
	}

	public RtrnRsnModel(Object[] array) {
		this.rtrnRsnCd = (String)array[0];
		this.rtrnRsnNm = (String)array[1];
		this.rtrnTpCd = (String)array[3];
	}

	public String getRtrnRsnCd() {
		return rtrnRsnCd;
	}

	public void setRtrnRsnCd(String rtrnRsnCd) {
		this.rtrnRsnCd = rtrnRsnCd;
	}

	public String getRtrnRsnNm() {
		return rtrnRsnNm;
	}

	public void setRtrnRsnNm(String rtrnRsnNm) {
		this.rtrnRsnNm = rtrnRsnNm;
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}

	public String getRtrnTpCd() {
		return rtrnTpCd;
	}

	public void setRtrnTpCd(String rtrnTpCd) {
		this.rtrnTpCd = rtrnTpCd;
	}

//	public List<String> getSelectedCheckBox() {
//		return selectedCheckBox;
//	}
//
//	public void setSelectedCheckBox(List<String> selectedCheckBox) {
//		this.selectedCheckBox = selectedCheckBox;
//	}

	public List<RtrnRsnModel> getRtrnRsnModelList() {
		return rtrnRsnModelList;
	}

	public void setRtrnRsnModelList(List<RtrnRsnModel> rtrnRsnModelList) {
		this.rtrnRsnModelList = rtrnRsnModelList;
	}

	public String toString() {
		return "Reason Code:" + this.rtrnRsnCd + ", Name:" + this.rtrnRsnNm + ", Type:" + this.rtrnTpCd;
	}
}
