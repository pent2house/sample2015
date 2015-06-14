package com.ns.spring.service.template;

import java.util.List;

import com.ns.spring.model.RMA_HDR;
import com.ns.spring.service.GenHbService;

public interface RmaHdrService extends GenHbService<RMA_HDR, Integer> {

	public List<Object[]> getListRmaHdrBySql(String id);
}
