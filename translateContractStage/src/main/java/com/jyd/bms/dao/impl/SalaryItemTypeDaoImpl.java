package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.SalaryItemType;
import com.jyd.bms.dao.SalaryItemTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class SalaryItemTypeDaoImpl extends HibernateBaseTemplate<SalaryItemType> implements SalaryItemTypeDAO {

	public int getSalaryItemTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from SalaryItemType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from SalaryItemType where salaryItemType like :condition";
			Map<String, String> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}

	}

	public List<SalaryItemType> getPagingSalaryItemType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, String> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from SalaryItemType order by sortIndex desc";
		} else {
			hql = "from SalaryItemType where salaryItemType like :condition order by sortIndex desc";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<SalaryItemType> getAllSalaryItemType() throws DAOException {
		String hql = "";
		hql = "from SalaryItemType order by sortIndex desc";
		return super.getQueryResult(hql.toString());
	}

}
