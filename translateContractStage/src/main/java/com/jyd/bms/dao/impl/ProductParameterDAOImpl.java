package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ProductParameter;
import com.jyd.bms.dao.ProductParameterDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ProductParameterDAOImpl extends HibernateBaseTemplate<ProductParameter> implements ProductParameterDAO {

	public int getProductParameterCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ProductParameter";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ProductParameter where parameterType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ProductParameter> getPagingProductParameter(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ProductParameter";
		} else {
			hql = "from ProductParameter where parameterType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ProductParameter> getAllProductParameter() throws DAOException {
		String hql = "";
		hql = "from ProductParameter";
		return super.getQueryResult(hql.toString());

	}

}
