package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ProcessType;
import com.jyd.bms.dao.ProcessTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ProcessTypeDAOImpl extends HibernateBaseTemplate<ProcessType> implements ProcessTypeDAO {

	public int getProcessTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ProcessType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ProcessType where name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ProcessType> getPagingProcessType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ProcessType";
		} else {
			hql = "from ProcessType where name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ProcessType> getAllProcessType() throws DAOException {
		String hql = "";
		hql = "from ProcessType";
		return super.getQueryResult(hql.toString());

	}

}
