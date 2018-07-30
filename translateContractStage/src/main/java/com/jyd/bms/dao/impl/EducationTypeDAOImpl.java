package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.EducationType;
import com.jyd.bms.dao.EducationTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class EducationTypeDAOImpl extends HibernateBaseTemplate<EducationType> implements EducationTypeDAO {

	public int getEducationTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from EducationType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from EducationType where educationType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<EducationType> getPagingEducationType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from EducationType";
		} else {
			hql = "from EducationType where educationType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<EducationType> getAllEducationType() throws DAOException {
		String hql = "";
		hql = "from EducationType";
		return super.getQueryResult(hql.toString());

	}

}
