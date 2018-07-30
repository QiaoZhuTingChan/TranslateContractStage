package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dao.SalaryItemDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class SalaryItemDaoImpl extends HibernateBaseTemplate<SalaryItem> implements SalaryItemDAO {

	public List<SalaryItem> getAllSalaryItem() throws DAOException {
		String hql = "";
		hql = "from SalaryItem";
		return super.getQueryResult(hql.toString());
	}

	@Override
	public int getSalaryItemCount(String condition) throws DAOException {
		String hql = "";
		Map parameterMap = new HashMap();
		if (condition.equals("")) {
			hql = "select count(*) from SalaryItem";
		} else {
			parameterMap.put("condition", "%" + condition + "%");
			hql = "select count(*) from SalaryItem where salaryItem like :condition";
		}
		List<Long> lstCount = super.getQueryResult(hql, parameterMap);
		return lstCount.get(0).intValue();
	}

	@Override
	public List<SalaryItem> getPagingSalaryItem(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		Map parameterMap = new HashMap();
		if (condition.equals("")) {
			hql = "from SalaryItem";
		} else {
			parameterMap.put("condition", "%" + condition + "%");
			hql = "from SalaryItem where salaryItem like :condition";
		}
		return super.getPagingQueryResult(hql, parameterMap, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaryItem> getSalaryItemByEigthType() throws DAOException {
		String hql = "";
		hql += "from SalaryItem where type = 8";
		List<SalaryItem> list = super.getQueryResult(hql);

		return list;
	}

	@Override
	public SalaryItem getSalaryItemByCode(String code) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		hql = "from SalaryItem where code = :code";
		return (SalaryItem) super.getUniqueResult(hql, map);
	}

}
