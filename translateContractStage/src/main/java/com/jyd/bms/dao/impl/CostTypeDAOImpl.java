package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.CostType;
import com.jyd.bms.dao.CostTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class CostTypeDAOImpl extends HibernateBaseTemplate<CostType> implements CostTypeDAO {

	public int getCostTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CostType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CostType where costType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<CostType> getPagingCostType(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CostType";
		} else {
			hql = "from CostType where costType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<CostType> getAllCostType() throws DAOException {
		String hql = "";
		hql = "from CostType";
		return super.getQueryResult(hql.toString());

	}

}
