package com.ns.spring.constant;

public interface RtrnConstant {
	
	enum URL {

		DUMMY_EMP("/rest/emp/dummy"),
		GET_EMP("/rest/emp/{id}"),
		GET_ALL_EMP("/rest/emps"),
		CREATE_EMP("/rest/emp/create"),
		DELETE_EMP("/rest/emp/delete/{id}")
		;

		private String code;

		URL(String code) {
			this.code = code;
		}

		public String getVal() {
			return code;
		}		
	}

	public static final String DUMMY_EMP = "/rest/emp/dummy";
	public static final String GET_EMP = "/rest/emp/{id}";
	public static final String GET_ALL_EMP = "/rest/emps";
	public static final String CREATE_EMP = "/rest/emp/create";
	public static final String DELETE_EMP = "/rest/emp/delete/{id}";
	
	enum CONST {

		FORM_KEY("rmaMapKey"),
		RMA_NUM("RMA_NUM"),
		HDR_LIST("HDR_LIST"),
		TP_LIST("TP_LIST"),
		RSN_LIST("RSN_LIST"),
		MDSE_LIST("MDSE_LIST"),
		LINE_LIST_MODEL("rmaLineListModel"),
		RSN_LIST_BOUND("RSN_LIST_BOUND"),
		RSN_LIST_UNBOUND("RSN_LIST_UNBOUND"),
		HDR_STS_LIST("HDR_STS_LIST"),
		TP_SELECTED("TP_SELECTED")
		;

		private String code;

		CONST(String code) {
			this.code = code;
		}

		public String getVal() {
			return code;
		}
	}
	
	enum VIEW {
		
		MAIN_01("main_01"),
		SUB_LINE_01("sub_line_01"),
		SUB_TP_01("sub_tp_01"),
		SUB_RSN_01("sub_rsn_01"),
		SUB_TP_RSN_01("sub_tp_rsn_01"),
		REDIRECT_HOME("redirect:/ns-home")
		;

		private String code;

		VIEW(String code) {
			this.code = code;
		}

		public String getVal() {
			return code;
		}
	}
}
