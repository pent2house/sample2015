package com.ns.spring.common.gen;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.ns.spring.common.CommonBL;
import com.ns.spring.common.gen.BLService;
import com.ns.spring.constant.RtrnConstant.CONST;
import com.ns.spring.model.ui.RmaHdrStsModel;

@Component
public abstract class AbsBLServiceImpl implements BLService {

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

	public AbsBLServiceImpl() {
	}
	
	@SuppressWarnings("unchecked")
	public List<?> getAbsList(String attrKey, HttpServletRequest req) {
		List<?> stsList = (List<?>) req.getSession().getAttribute(attrKey);
		if (isEmpty(stsList)) {
			// Get fresh data from DB
//			stsList = getList();
			req.getSession().setAttribute(attrKey, stsList);
		}
		return stsList;
	}

	public boolean isEmpty(List<?> list) {
		if (list != null && list.size() > 0) {
			// List is not emplty
			return false;
		}
		return true;
	}
}
