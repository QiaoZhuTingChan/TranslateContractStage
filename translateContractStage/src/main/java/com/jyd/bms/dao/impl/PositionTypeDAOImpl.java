package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.PositionType;
import com.jyd.bms.dao.PositionTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class PositionTypeDAOImpl extends HibernateBaseTemplate<PositionType> implements PositionTypeDAO {

	public int getPositionTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from PositionType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from PositionType where positionType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<PositionType> getPagingPositionType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from PositionType";
		} else {
			hql = "from PositionType where positionType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<PositionType> getAllPositionType() throws DAOException {
		String hql = "";
		hql = "from PositionType";
		return super.getQueryResult(hql.toString());

	}

	public PositionType getPositionTypeByName(String condition) throws DAOException {
		String hql = "";
		hql = "from PositionType where positionType = :condition";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		return (PositionType) super.getQueryResult(hql.toString());

	}

	@Override
	public List<PositionType> getPositionsByDepartment(String department) {
		String hql = "from PositionType where employees.";
		hql = "";
		return null;
	}

	@Override
	public List<PositionType> getPositionTypeByPara(String condition) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (!condition.equals("")) {
			hql = "from PositionType where positionType like :condition";
			map.put("condition", "%" + condition + "%");
			return super.getQueryResult(hql, map);
		} else {
			hql = "from PositionType";
			return super.getQueryResult(hql);
		}
	}

}
