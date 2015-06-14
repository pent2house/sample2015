package com.ns.spring.service.template;

import java.util.List;

import com.ns.spring.model.RMA_LINE;
import com.ns.spring.service.GenHbService;

public interface RmaLineService extends GenHbService<RMA_LINE, String> {

	public List<Object[]> getListRmaLineBySql(String rmaNum, String rmaLineNum);
	public RMA_LINE getRmaLineByHql(String rmaNum, String rmaLineNum);
}
