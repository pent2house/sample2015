package com.ns.spring.model.ui;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ns.spring.model.RMA_HDR;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RmaHdrModel {

	private int id;
	private String rmaNum = "";
	private String rmaHdrStsCd = "";
	private String rmaHdrStsNm = "";
	private String rtrnTpCd = "";
	private String rtrnTpNm = "";
	private String rtrnRsnCd = "";
	private String rtrnRsnNm = "";
	private String sellToCustCd = "";
	private String mdseCd = "";
	private List<RmaLineModel> rmaLines = new ArrayList<RmaLineModel>();
	private int radioBtn;
	private List<String> selectedCheckBox = new ArrayList<String>();
	
	public RmaHdrModel(){}

	public RmaHdrModel(RMA_HDR hdr) {
		this.id = hdr.getId();
		this.rmaNum = hdr.getRmaNum();
		this.rmaHdrStsCd = hdr.getRmaHdrStsCd();
		this.rtrnTpCd = hdr.getRtrnTpCd();
		this.rtrnRsnCd = hdr.getRtrnRsnCd();
		this.sellToCustCd = hdr.getSellToCustCd();
	}
	
	public RmaHdrModel(Object[] array) {
		this.id = (Integer)array[0];
		this.rmaNum = (String)array[1];
		this.rmaHdrStsCd = (String)array[2];
		this.rmaHdrStsNm = (String)array[3];
		this.rtrnTpCd = (String)array[4];
		this.rtrnTpNm = (String)array[5];
		this.rtrnRsnCd = (String)array[6];
		this.rtrnRsnNm = (String)array[7];
		this.sellToCustCd = (String)array[8];
	}

//	public RmaHdrModel(
//			int id, 
//			String rmaNum, 
//			String rmaHdrStsCd,
//			String rtrnTpCd, 
//			String rtrnRsnCd, 
//			String sellToCustCd,
//			int radioBtn, 
//			List<String> selectedCheckBox) {
//		this.id = id;
//		this.rmaNum = rmaNum;
//		this.rmaHdrStsCd = rmaHdrStsCd;
//		this.rtrnTpCd = rtrnTpCd;
//		this.rtrnRsnCd = rtrnRsnCd;
//		this.sellToCustCd = sellToCustCd;
//		this.radioBtn = radioBtn;
//		this.selectedCheckBox = selectedCheckBox;
//	}
//
//	public RmaHdrModel(
//			String rmaNum, 
//			String rmaHdrStsCd,
//			String rtrnTpCd, 
//			String rtrnRsnCd, 
//			String sellToCustCd,
//			int radioBtn, 
//			List<String> selectedCheckBox) {
//		this.rmaNum = rmaNum;
//		this.rmaHdrStsCd = rmaHdrStsCd;
//		this.rtrnTpCd = rtrnTpCd;
//		this.rtrnRsnCd = rtrnRsnCd;
//		this.sellToCustCd = sellToCustCd;
//		this.radioBtn = radioBtn;
//		this.selectedCheckBox = selectedCheckBox;
//	}

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

	public String getRmaHdrStsNm() {
		return rmaHdrStsNm;
	}

	public void setRmaHdrStsNm(String rmaHdrStsNm) {
		this.rmaHdrStsNm = rmaHdrStsNm;
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

	public String getSellToCustCd() {
		return sellToCustCd;
	}

	public void setSellToCustCd(String sellToCustCd) {
		this.sellToCustCd = sellToCustCd;
	}

	public String getMdseCd() {
		return mdseCd;
	}

	public void setMdseCd(String mdseCd) {
		this.mdseCd = mdseCd;
	}

	public List<RmaLineModel> getRmaLines() {
		return rmaLines;
	}

	public void setRmaLines(List<RmaLineModel> rmaLines) {
		this.rmaLines = rmaLines;
	}

	public int getRadioBtn() {
		return radioBtn;
	}

	public void setRadioBtn(int radioBtn) {
		this.radioBtn = radioBtn;
	}

	public List<String> getSelectedCheckBox() {
		return selectedCheckBox;
	}

	public void setSelectedCheckBox(List<String> selectedCheckBox) {
		this.selectedCheckBox = selectedCheckBox;
	}
}
