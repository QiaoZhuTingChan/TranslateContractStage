package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.RepaymentAccount;
import com.jyd.bms.dao.RepaymentAccountDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class RepaymentAccountDAOImpl extends HibernateBaseTemplate<RepaymentAccount> implements RepaymentAccountDAO {

	public int getRepaymentAccountCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from RepaymentAccount";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from RepaymentAccount where name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<RepaymentAccount> getPagingRepaymentAccount(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from RepaymentAccount";
		} else {
			hql = "from RepaymentAccount where name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<RepaymentAccount> getAllRepaymentAccount() throws DAOException {
		String hql = "";
		hql = "from RepaymentAccount";
		return super.getQueryResult(hql.toString());

	}

}
