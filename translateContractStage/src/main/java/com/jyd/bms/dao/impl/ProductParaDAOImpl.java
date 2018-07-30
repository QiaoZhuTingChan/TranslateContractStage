package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductPara;
import com.jyd.bms.dao.ProductParaDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ProductParaDAOImpl extends HibernateBaseTemplate<ProductPara> implements ProductParaDAO {

	public int getProductParaCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ProductPara";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ProductPara where product.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ProductPara> getPagingProductPara(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ProductPara";
		} else {
			hql = "from ProductPara where product.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ProductPara> getAllProductPara() throws DAOException {
		String hql = "";
		hql = "from ProductPara";
		return super.getQueryResult(hql.toString());

	}

	/**
	 * 根据产品查找产品参数
	 */
	public List<ProductPara> findProductParasByProduct(Product product) throws DAOException {
		String hql = "";
		hql = "from ProductPara where product = :product";
		Map<String, Product> map = new HashMap<>();
		map.put("product", product);
		return super.getQueryResult(hql, map);
	}

	@Override
	public ProductPara getProductParasByProductAndPrepose(Product product) throws DAOException {
		String hql = "";
		hql = "from ProductPara where product = :product and productParameter.id = 1";
		Map<String, Product> map = new HashMap<>();
		map.put("product", product);
		List<ProductPara> list = super.getQueryResult(hql, map);
		return list.isEmpty() ? null : list.get(0);
	}


}
