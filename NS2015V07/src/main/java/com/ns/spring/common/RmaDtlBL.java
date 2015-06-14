package com.ns.spring.common;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.RMA_LINE;
import com.ns.spring.model.RmaLinePk;
import com.ns.spring.model.ui.RmaLineModel;
import com.ns.spring.service.template.RmaLineService;

@Component
public class RmaDtlBL implements RtrnConstant {

	private static RmaLineService rmaLineSvc;
	
	@Autowired(required = true)
	public void setRmaLineSvc(RmaLineService rmaLineSvc) {
		this.rmaLineSvc = rmaLineSvc;
	}

	public static List<RmaLineModel> getRmaLineListWithCdTblNm(String rmaNum, String rmaLineNum) {
		List<RmaLineModel> modelList = new ArrayList<>();
		List<Object[]> rmaLineList = rmaLineSvc.getListRmaLineBySql(rmaNum, rmaLineNum);
		if (!CommonBL.isEmpty(rmaLineList)) {
			for (Object[] array : rmaLineList) {
				modelList.add(new RmaLineModel(array));
			}
		}
		return modelList;
	}

	public static void deleteRmaLine(String rmaNum, String rmaLineNum) {
		RMA_LINE obj = rmaLineSvc.getRmaLineByHql(rmaNum, rmaLineNum);
		if (obj != null) {
			rmaLineSvc.delete(obj);
		}		
	}

	public static boolean isSelectedLine(String lineNum, List<String> selectedLines) {
		for (String selected : selectedLines) {
			if (CommonBL.hasValue(lineNum) && lineNum.equals(selected)) {
				return true;
			}
		}
		return false;
	}

	public static String getNewLineNum(List<RmaLineModel> currList) {
		int maxLineNum = getMaxLineNum(currList);
		DecimalFormat df = new DecimalFormat("00000");
		return df.format((double) (maxLineNum + 1));
	}

	public static int getMaxLineNum(List<RmaLineModel> currList) {
		int max = 0;
		if (!CommonBL.isEmpty(currList)) {
			for (RmaLineModel obj : currList) {
				int lineNumLong = Integer.parseInt(obj.getRmaLineNum());
				if (lineNumLong > max) {
					max = lineNumLong;
				}
			}
		}
		return max;
	}

	public static RMA_LINE getRmaLineObj(RmaLineModel obj, String rmaNum, String rmaLineNum) {
		RMA_LINE rmaLine = new RMA_LINE();
		rmaLine.setRmaLinePk(new RmaLinePk(rmaNum, rmaLineNum));
		rmaLine.setRmaHdr(RmaBL.getRmaHdrObj(rmaNum));
		rmaLine.setRmaLineStsCd(getStsCd(obj.getRmaLineStsCd()));
		rmaLine.setMdseCd(obj.getMdseCd());
		rmaLine.setQty(obj.getQty());
		return rmaLine;
	}

	public static String getStsCd(String stsCd) {
		if (!CommonBL.hasValue(stsCd)) {
			// Default status code if not selected
			return "01";
		}
		return stsCd;
	}
}
