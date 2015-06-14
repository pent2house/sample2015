package com.ns.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ns.spring.common.RmaBL;
import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.model.ui.RmaHdrModel;

@Controller
public class WSController implements RtrnConstant {

	/****** bean defined in servlet-context.xml ******/
//	@Autowired(required = true)
//	@Qualifier(value = "employee")
//	private AopTest emp;
//	
//	@Autowired(required = true)
//	@Qualifier(value = "employeeService")
//	private AopTestService empSrv;	
//	
//	@Autowired(required = true)
//	private RmaHdrService hdrSvc;

	/**************************************************************************/

	@RequestMapping(value = "/ns-home/json", method = RequestMethod.GET)
	public @ResponseBody List<RmaHdrModel> getAll(HttpServletRequest req) {
//		List<JSONObject> entityList = new ArrayList<JSONObject>();

		// Float f = new Float("0");
		// float celsius = (f - 32) * 5 / 9;

		List<RmaHdrModel> list = RmaBL.getRmaHdrListWCdTblNm(req);
		List<JSONObject> entities = new ArrayList<JSONObject>();
		for (RmaHdrModel rma : list) {
			JSONObject jsonObject = new JSONObject();
			// jsonObject.put("F Value", f);
			// jsonObject.put("C Value", celsius);
			jsonObject.put("id", rma.getId());
			jsonObject.put("rmaNum", rma.getRmaNum());
			jsonObject.put("rmaHdrStsCd", rma.getRmaHdrStsCd());
			entities.add(jsonObject);
		}
		return list;
	}
}
