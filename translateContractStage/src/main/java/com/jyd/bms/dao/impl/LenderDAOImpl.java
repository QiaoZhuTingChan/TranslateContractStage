package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Lender;
import com.jyd.bms.dao.LenderDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class LenderDAOImpl extends HibernateBaseTemplate<Lender> implements LenderDAO {

	public int getLenderCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Lender";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Lender where name like :condition or idCard like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<Lender> getPagingLender(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Lender";
		} else {
			hql = "from Lender where name like :condition or idCard like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Lender> getAllLender() throws DAOException {
		String hql = "";
		hql = "from Lender";
		return super.getQueryResult(hql.toString());

	}

}
