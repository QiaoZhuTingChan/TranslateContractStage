package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.EvectionType;
import com.jyd.bms.dao.EvectionTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class EvectionTypeDAOImpl extends HibernateBaseTemplate<EvectionType> implements EvectionTypeDAO {

	public int getEvectionTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from EvectionType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from EvectionType where evectionType like :condition";
			Map<String, String> map = new HashMap<String, String>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<EvectionType> getPagingEvectionType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, String> map = new HashMap<String, String>();
		if (condition.equals("")) {
			hql = "from EvectionType";
		} else {
			hql = "from EvectionType where evectionType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<EvectionType> getAllEvectionType() throws DAOException {
		String hql = "";
		hql = "from EvectionType";
		return super.getQueryResult(hql.toString());

	}

}
