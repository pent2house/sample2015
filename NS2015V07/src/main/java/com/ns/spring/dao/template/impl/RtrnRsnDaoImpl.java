package com.ns.spring.dao.template.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ns.spring.dao.GenHbDaoImpl;
import com.ns.spring.dao.template.RtrnRsnDao;
import com.ns.spring.model.RTRN_RSN;

@Repository
public class RtrnRsnDaoImpl extends GenHbDaoImpl<RTRN_RSN, String> implements RtrnRsnDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListRsnsBoundTpBySql(String tpCd) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("SELECT \n");
		sb.append("  a.rtrn_rsn_cd \n");
		sb.append(" ,a.rtrn_rsn_nm \n");
		sb.append(" ,a.sort_num \n");
		sb.append(" ,b.rtrn_tp_cd \n");
		sb.append(" FROM rtrn_rsn a \n");
		sb.append(" LEFT OUTER JOIN rtrn_tp_rsn_cmbn b \n");
		sb.append(" ON a.rtrn_rsn_cd = b.rtrn_rsn_cd \n");
		sb.append(" WHERE b.rtrn_tp_cd = :tpCd \n");
		sb.append(" ORDER BY \n");
		sb.append("  a.sort_num \n");
		sb.append(" ,b.rtrn_tp_cd \n");
		sb.append(" ,a.rtrn_rsn_cd \n");

		Query query = super.getCurrSession().createSQLQuery(sb.toString());
		query.setParameter("tpCd", tpCd);

		List<Object[]> list = query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListRsnsUnBoundTpBySql(String tpCd) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("SELECT \n");
		sb.append(" a1.rtrn_rsn_cd \n");
		sb.append(",a1.rtrn_rsn_nm \n");
		sb.append(",a1.sort_num \n");
		sb.append(",'' as rtrn_tp_cd \n");
		sb.append("FROM rtrn_rsn a1 \n");
		sb.append("WHERE NOT EXISTS ( \n");
		sb.append("   SELECT '*' \n");
		sb.append("   FROM rtrn_rsn a2 \n");
		sb.append("   JOIN rtrn_tp_rsn_cmbn cmb \n");
		sb.append("   ON a2.rtrn_rsn_cd = cmb.rtrn_rsn_cd \n");
		sb.append("   WHERE cmb.rtrn_tp_cd  = :tpCd \n");
		sb.append("   AND a2.rtrn_rsn_cd = a1.rtrn_rsn_cd \n");
		sb.append(") \n");
		sb.append("ORDER BY a1.sort_num");

		Query query = super.getCurrSession().createSQLQuery(sb.toString());
		query.setParameter("tpCd", tpCd);

		List<Object[]> list = query.list();
		return list;
	}
}
