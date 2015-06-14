package com.ns.spring.dao.template.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ns.spring.dao.GenHbDaoImpl;
import com.ns.spring.dao.template.RmaLineDao;
import com.ns.spring.model.RMA_LINE;

@Repository
public class RmaLineDaoImpl extends GenHbDaoImpl<RMA_LINE, String> implements RmaLineDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListRmaLineBySql(String rmaNum, String rmaLineNum) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("SELECT\n");
		sb.append("  rl.rma_num\n");
		sb.append(" ,rl.rma_line_num\n");
		sb.append(" ,rl.rma_line_sts_cd\n");
		sb.append(" ,sts.rma_hdr_sts_nm\n");
		sb.append(" ,rl.mdse_cd\n");
		sb.append(" ,mdse.mdse_nm\n");
		sb.append(" ,rl.qty\n");
		sb.append(" ,rl.rma_id\n");
		sb.append("FROM RMA_LINE rl\n");
		sb.append("LEFT OUTER JOIN RMA_HDR_STS sts\n");
		sb.append("ON rl.rma_line_sts_cd = sts.rma_hdr_sts_cd\n");
		sb.append("LEFT OUTER JOIN MDSE mdse\n");
		sb.append("ON rl.mdse_cd = mdse.mdse_cd\n");
		sb.append("WHERE rl.rma_num = :rmaNum\n");
		if (rmaLineNum != null) {
			sb.append("AND rl.rma_line_num = :rmaLineNum\n");
		}		
		sb.append("ORDER BY\n");
		sb.append("  rl.rma_num\n");
		sb.append(" ,rl.rma_line_num\n");

		Query query = super.getCurrSession().createSQLQuery(sb.toString());
		query.setParameter("rmaNum", rmaNum);
		if (rmaLineNum != null) {
			query.setParameter("rmaLineNum", rmaLineNum);
		}
		List<Object[]> list = query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public RMA_LINE getRmaLineByHql(String rmaNum, String rmaLineNum) {

		String hqlStr = "from RMA_LINE " 
				+ "where rma_num = :rmaNum "
				+ "and   rma_line_num = :rmaLineNum ";
		
		Query query = super.getCurrSession().createQuery(hqlStr);
		query.setParameter("rmaNum", rmaNum);
		query.setParameter("rmaLineNum", rmaLineNum);

		List<RMA_LINE> list = query.list();
		if (list != null && list.size() > 0) {
			return (RMA_LINE) list.get(0);
		}
		return null;
	}
}
