package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.EvectionType;
import com.jyd.bms.bean.OverTimeType;
import com.jyd.bms.dao.OverTimeTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class OverTimeTypeDAOImpl extends HibernateBaseTemplate<OverTimeType> implements OverTimeTypeDAO{

	@Override
	public int getOverTimeTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from OverTimeType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from OverTimeType where overTimeType like :condition";
			Map<String, String> map = new HashMap<String, String>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@Override
	public List<OverTimeType> getPagingOverTimeType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, String> map = new HashMap<String, String>();
		if (condition.equals("")) {
			hql = "from OverTimeType";
		} else {
			hql = "from OverTimeType where overTimeType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	
	}

	@Override
	public List<OverTimeType> getAllOverTimeType() throws DAOException {
		String hql = "";
		hql = "from OverTimeType";
		return super.getQueryResult(hql.toString());
	}

	

	
}
