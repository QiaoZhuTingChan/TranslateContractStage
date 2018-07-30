package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ProductType;
import com.jyd.bms.dao.ProductTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ProductTypeDAOImpl extends HibernateBaseTemplate<ProductType> implements ProductTypeDAO {

	public int getProductTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ProductType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ProductType where productType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ProductType> getPagingProductType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ProductType";
		} else {
			hql = "from ProductType where productType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ProductType> getAllProductType() throws DAOException {
		String hql = "";
		hql = "from ProductType";
		return super.getQueryResult(hql.toString());

	}

}
