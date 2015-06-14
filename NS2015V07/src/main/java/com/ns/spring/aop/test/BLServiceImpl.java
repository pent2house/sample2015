package com.ns.spring.aop.test;

import org.springframework.stereotype.Component;

import com.ns.spring.common.gen.BLService;

@Component
public abstract class BLServiceImpl implements BLService {

//	private static RmaHdrStsService hdrStsSvc;
//	
//	@Autowired(required = true)
//	public void setHdrStsSvc(RmaHdrStsService hdrStsSvc) {
//		this.hdrStsSvc = hdrStsSvc;
//	}
//	
//	public RmaHdrStsService getRmaHdrStsService() {
//		return this.hdrStsSvc;
//	}

	public BLServiceImpl() {
	}
}
