package com.ns.spring.aop.test;

import com.ns.spring.constant.RtrnConstant;
import com.ns.spring.service.template.MdseService;
import com.ns.spring.service.template.RmaHdrStsService;

//@Component
public class DaoCommon implements RtrnConstant {
	
	private static final DaoCommon instance = new DaoCommon();

	private RmaHdrStsService hdrStsSvc;
	
	private MdseService mdseSvc;
	
	private DaoCommon() {		
	}
	
	public static DaoCommon getInstance() {
		if( instance == null ) {
			return new DaoCommon();
		}
		return instance;
	}

//	@Autowired(required = true)
	public void setHdrStsSvc(RmaHdrStsService hdrStsSvc) {
		this.hdrStsSvc = hdrStsSvc;
	}

//	@Autowired(required = true)
	public void setMdseSvc(MdseService mdseSvc) {
		this.mdseSvc = mdseSvc;
	}
	
	public RmaHdrStsService getHdrStsSvc() {
		return hdrStsSvc;
	}

	public MdseService getMdseSvc() {
		return mdseSvc;
	}
	
//	public static MDSE getMdse(String key) {
//		return mdseSvc.findById(key);
//	}

//	@SuppressWarnings("unchecked")
//	public static List<MdseModel> getMdselList(HttpServletRequest req) {
//		List<MdseModel> mdseList = (List<MdseModel>)req.getSession().getAttribute(CONST.MDSE_LIST.getVal());
//		if (DaoCommon.isEmpty(mdseList)) {
//			// Get fresh data from DB
//			mdseList = getMdseModelList();
//			req.getSession().setAttribute(CONST.MDSE_LIST.getVal(), mdseList);
//		}
//		return mdseList;
//	}
//
//	public static List<MdseModel> getMdseModelList() {
//		List<MdseModel> mdseModelList = new ArrayList<>();
//		List<MDSE> mdseList = mdseSvc.findAll();
//		if (!DaoCommon.isEmpty(mdseList)) {
//			for (int i = 0; i < mdseList.size(); i++) {
//				MDSE obj = (MDSE) mdseList.get(i);
//				mdseModelList.add(new MdseModel(i, obj.getMdseCd()));
//			}
//		}
//		return mdseModelList;
//	}
//
//	public static String getMdseNm(MDSE mdse) {
//		if (mdse != null) {
//			return mdse.getMdseNm();
//		}
//		return "";
//	}
//
//	@SuppressWarnings("unchecked")
//	public static List<RmaHdrStsModel> getStsList(HttpServletRequest req) {
//		List<RmaHdrStsModel> stsList = (List<RmaHdrStsModel>) req.getSession().getAttribute(CONST.HDR_STS_LIST.getVal());
//		if (DaoCommon.isEmpty(stsList)) {
//			// Get fresh data from DB
//			stsList = getRmaHdrStsModelList();
//			req.getSession().setAttribute(CONST.HDR_STS_LIST.getVal(), stsList);
//		}
//		return stsList;
//	}
//
//	public static List<RmaHdrStsModel> getRmaHdrStsModelList(){
//		List<RmaHdrStsModel> hdrStsList = new ArrayList<>();
//		List<RMA_HDR_STS> stsList = hdrStsSvc.findAll();
//		if (!DaoCommon.isEmpty(stsList)) {
//			for (RMA_HDR_STS obj : stsList) {
//				hdrStsList.add(new RmaHdrStsModel(obj.getRmaHdrStsCd(), obj.getRmaHdrStsNm()));
//			}
//		}
//		return hdrStsList;
//	}
//
//	public static void rmaHdrStsCombo(Model model, HttpServletRequest req) {
//		model.addAttribute(CONST.HDR_STS_LIST.getVal(), getStsList(req));
//	}
//
//	public static boolean hasValue(String str) {
//		if (str != null && str.length() > 0) {
//			return true;
//		}
//		return false;
//	}
//
//	public static boolean isEmpty(List<?> list) {
//		if (list != null && list.size() > 0) {
//			// List is not emplty
//			return false;
//		}
//		return true;
//	}
}
