package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.RepaymentType;
import com.jyd.bms.dao.RepaymentTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class RepaymentTypeDAOImpl extends HibernateBaseTemplate<RepaymentType> implements RepaymentTypeDAO {

	public int getRepaymentTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from RepaymentType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from RepaymentType where repaymentType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<RepaymentType> getPagingRepaymentType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from RepaymentType";
		} else {
			hql = "from RepaymentType where repaymentType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<RepaymentType> getAllRepaymentType() throws DAOException {
		String hql = "";
		hql = "from RepaymentType";
		return super.getQueryResult(hql.toString());

	}

}
