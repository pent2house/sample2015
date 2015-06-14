package com.ns.spring.dao.template.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ns.spring.dao.GenHbDaoImpl;
import com.ns.spring.dao.template.RmaHdrDao;
import com.ns.spring.model.RMA_HDR;

@Repository
public class RmaHdrDaoImpl extends GenHbDaoImpl<RMA_HDR, Integer> implements RmaHdrDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListRmaHdrBySql(String id) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("SELECT\n");
		sb.append("  ra.id\n");
		sb.append(" ,ra.rma_num\n");
		sb.append(" ,ra.rma_hdr_sts_cd\n");
		sb.append(" ,sts.rma_hdr_sts_nm\n");
		sb.append(" ,ra.rtrn_tp_cd\n");
		sb.append(" ,tp.rtrn_tp_nm\n");
		sb.append(" ,ra.rtrn_rsn_cd\n");
		sb.append(" ,rsn.rtrn_rsn_nm\n");
		sb.append(" ,ra.sell_to_cust_cd\n");
		sb.append("FROM RMA_HDR ra\n");
		sb.append("LEFT OUTER JOIN rma_hdr_sts sts\n");
		sb.append("ON ra.rma_hdr_sts_cd = sts.rma_hdr_sts_cd\n");
		sb.append("LEFT OUTER JOIN rtrn_tp tp\n");
		sb.append("ON ra.rtrn_tp_cd = tp.rtrn_tp_cd\n");
		sb.append("LEFT OUTER JOIN rtrn_rsn rsn\n");
		sb.append("ON ra.rtrn_rsn_cd = rsn.rtrn_rsn_cd\n");
		if (id != null) {
			sb.append(" WHERE ra.rma_num = :rmaNum\n");
		}
		sb.append("ORDER BY\n");
		sb.append("  ra.rma_hdr_sts_cd\n");

		Query query = super.getCurrSession().createSQLQuery(sb.toString());
		if (id != null) {
			query.setParameter("rmaNum", id);
		}
		List<Object[]> list = query.list();
		return list;
	}	
}
