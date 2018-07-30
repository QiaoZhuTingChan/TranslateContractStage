package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.DepartmentType;
import com.jyd.bms.dao.DepartmentTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class DepartmentTypeDAOImpl extends HibernateBaseTemplate<DepartmentType> implements DepartmentTypeDAO {

	public int getDepartmentTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from DepartmentType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from DepartmentType where departmentType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<DepartmentType> getPagingDepartmentType(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from DepartmentType";
		} else {
			hql = "from DepartmentType where departmentType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<DepartmentType> getAllDepartmentType() throws DAOException {
		String hql = "";
		hql = "from DepartmentType";
		return super.getQueryResult(hql.toString());

	}

}
