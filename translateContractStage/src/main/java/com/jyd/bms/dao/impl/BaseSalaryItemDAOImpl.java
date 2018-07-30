package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.BaseSalaryItem;
import com.jyd.bms.dao.BaseSalaryItemDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class BaseSalaryItemDAOImpl extends HibernateBaseTemplate<BaseSalaryItem> implements BaseSalaryItemDAO{

	
	public int getBaseSalaryItemCount(String condition) throws DAOException {
		String hql = "";
		if(condition.equals("")) {
			hql = "select count(*) from BaseSalaryItem";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		}else {
			hql = "select count(*) from BaseSalaryItem where baseSalaryItem like :condition";
			Map<String, String> map = new HashMap<>();
			map.put("condition", "%"+condition+"%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	
	public List<BaseSalaryItem> getPagingBaseSalaryItem(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, String> map = new HashMap<>();
		if(condition.equals("")) {
			hql = "from BaseSalaryItem";
		}else {
			hql = "from BaseSalaryItem where baseSalaryItem like :condition";
			map.put("condition", "%"+condition+"%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	
	public List<BaseSalaryItem> getAllBaseSalaryItem() throws DAOException {
		String hql = "";
		hql = "from BaseSalaryItem";
		return super.getQueryResult(hql.toString());
	}

	
}
