package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductRepaymentStage;
import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.dao.ProductRepaymentStageDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ProductRepaymentStageDAOImpl extends HibernateBaseTemplate<ProductRepaymentStage>
		implements ProductRepaymentStageDAO {

	public int getProductRepaymentStageCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ProductRepaymentStage";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ProductRepaymentStage where product.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ProductRepaymentStage> getPagingProductRepaymentStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ProductRepaymentStage";
		} else {
			hql = "from ProductRepaymentStage where product.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ProductRepaymentStage> getAllProductRepaymentStage() throws DAOException {
		String hql = "";
		hql = "from ProductRepaymentStage";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public List<ProductRepaymentStage> findProductRepaymentStagesByProduct(Product product) throws DAOException {
		String hql = "";
		hql = "from ProductRepaymentStage where product = :product";
		Map<String, Product> map = new HashMap<>();
		map.put("product", product);
		return super.getQueryResult(hql, map);
	}

	@Override
	public ProductRepaymentStage getProductRepaymentStage(Product product, RepaymentStage stage) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		map.put("product", product);
		map.put("stage", stage);
		hql = "from ProductRepaymentStage where product = :product and repaymentStage = :stage";
		return (ProductRepaymentStage) super.getUniqueResult(hql, map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ProductRepaymentStage getProductRepaymentStagesByProductAndStage(Product product, RepaymentStage stage) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		map.put("product", product);
		map.put("stage", stage);
		hql = "from ProductRepaymentStage where product = :product and repaymentStage = :stage";
		
		List<ProductRepaymentStage> list = super.getQueryResult(hql, map);
		
		return list.isEmpty() ? null : list.get(0);
	}

}
