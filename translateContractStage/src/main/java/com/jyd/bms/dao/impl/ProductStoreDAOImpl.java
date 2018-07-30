package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductStore;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ProductStoreDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ProductStoreDAOImpl extends HibernateBaseTemplate<ProductStore> implements ProductStoreDAO {

	public int getProductStoreCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ProductStore";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ProductStore where product.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ProductStore> getPagingProductStore(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ProductStore";
		} else {
			hql = "from ProductStore where product.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ProductStore> getAllProductStore() throws DAOException {
		String hql = "";
		hql = "from ProductStore";
		return super.getQueryResult(hql.toString());

	}
	/**
	 * @category 查找产品通过门店
	 * @return　产品门店
	 * @throws DAOException
	 */
	public List<ProductStore> getProductByStore(Store store) throws DAOException {
		String hql = "";
		hql = "from ProductStore where store = :store";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		return super.getQueryResult(hql, map);
	}

	@Override
	public List<ProductStore> findProductStoresByProduct(Product product) throws DAOException {
		String hql = "";
		hql = "from ProductStore where product = :product";
		Map<String, Product> map = new HashMap<>();
		map.put("product", product);
		return super.getQueryResult(hql, map);
	}
}
