package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.GpsCostType;
import com.jyd.bms.dao.GpsCostTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class GpsCostTypeDAOImpl extends HibernateBaseTemplate<GpsCostType> implements GpsCostTypeDAO {

	public int getGpsCostTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from GpsCostType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from GpsCostType where gpsCostType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<GpsCostType> getPagingGpsCostType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from GpsCostType";
		} else {
			hql = "from GpsCostType where gpsCostType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<GpsCostType> getAllGpsCostType() throws DAOException {
		String hql = "";
		hql = "from GpsCostType";
		return super.getQueryResult(hql.toString());

	}

}
