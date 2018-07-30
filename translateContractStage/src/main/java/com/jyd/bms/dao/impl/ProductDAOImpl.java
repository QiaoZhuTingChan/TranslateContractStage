package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Product;
import com.jyd.bms.dao.ProductDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ProductDAOImpl extends HibernateBaseTemplate<Product> implements ProductDAO {

	public int getProductCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Product";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Product where name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<Product> getPagingProduct(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Product";
		} else {
			hql = "from Product where name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Product> getAllProduct() throws DAOException {
		String hql = "";
		hql = "from Product";
		return super.getQueryResult(hql.toString());
	}

	@Override
	public Product getProductByName(String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		hql="from Product where name=:condition";
		List<Product> pro=super.getQueryResult(hql,map);
		return pro.isEmpty() ? null : pro.get(0);
	}
}
