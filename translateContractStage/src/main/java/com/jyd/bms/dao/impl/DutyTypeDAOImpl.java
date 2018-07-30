package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.DutyType;
import com.jyd.bms.dao.DutyTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class DutyTypeDAOImpl extends HibernateBaseTemplate<DutyType> implements DutyTypeDAO {

	public int getDutyTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from DutyType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from DutyType where dutyType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<DutyType> getPagingDutyType(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from DutyType";
		} else {
			hql = "from DutyType where dutyType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<DutyType> getAllDutyType() throws DAOException {
		String hql = "";
		hql = "from DutyType";
		return super.getQueryResult(hql.toString());

	}

}
