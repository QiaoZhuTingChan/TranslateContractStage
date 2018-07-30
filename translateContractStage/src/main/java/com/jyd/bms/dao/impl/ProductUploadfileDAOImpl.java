package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductUploadfile;
import com.jyd.bms.dao.ProductUploadfileDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ProductUploadfileDAOImpl extends HibernateBaseTemplate<ProductUploadfile> implements ProductUploadfileDAO {

	public int getProductUploadfileCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ProductUploadfile";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ProductUploadfile where product.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ProductUploadfile> getPagingProductUploadfile(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ProductUploadfile";
		} else {
			hql = "from ProductUploadfile where product.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ProductUploadfile> getAllProductUploadfile() throws DAOException {
		String hql = "";
		hql = "from ProductUploadfile";
		return super.getQueryResult(hql.toString());

	}

	/**
	 * 根据产品查找产品上传文件
	 */
	public List<ProductUploadfile> findProductUploadfilesByProduct(Product product) throws DAOException {
		String hql = "";
		hql = "from ProductUploadfile where product = :product";
		Map<String, Product> map = new HashMap<>();
		map.put("product", product);
		return super.getQueryResult(hql, map);
	}

}
