package com.ns.spring.dao.template.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ns.spring.dao.GenHbDaoImpl;
import com.ns.spring.dao.template.RtrnTpRsnDao;
import com.ns.spring.model.RTRN_TP_RSN_CMBN;

@Repository
public class RtrnTpRsnDaoImpl extends GenHbDaoImpl<RTRN_TP_RSN_CMBN, String> implements RtrnTpRsnDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public RTRN_TP_RSN_CMBN getTpRsnCmbnByHql(String rtrnTpCd, String rtrnRsnCd) {

		String hqlStr = "from RTRN_TP_RSN_CMBN " 
				+ "where rtrn_tp_cd = :rtrnTpCd "
				+ "and   rtrn_rsn_cd = :rtrnRsnCd ";
		
		Query query = super.getCurrSession().createQuery(hqlStr);
		query.setParameter("rtrnTpCd", rtrnTpCd);
		query.setParameter("rtrnRsnCd", rtrnRsnCd);

		List<RTRN_TP_RSN_CMBN> list = query.list();
		if (list != null && list.size() > 0) {
			return (RTRN_TP_RSN_CMBN) list.get(0);
		}
		return null;
	}
}
