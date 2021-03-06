package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.LoanType;
import com.jyd.bms.dao.LoanTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class LoanTypeDAOImpl extends HibernateBaseTemplate<LoanType> implements LoanTypeDAO {

	public int getLoanTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from LoanType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from LoanType where loanType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<LoanType> getPagingLoanType(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from LoanType";
		} else {
			hql = "from LoanType where loanType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<LoanType> getAllLoanType() throws DAOException {
		String hql = "";
		hql = "from LoanType";
		return super.getQueryResult(hql.toString());

	}

}
