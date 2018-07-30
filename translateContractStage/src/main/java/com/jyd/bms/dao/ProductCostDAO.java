package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductCost;
import com.jyd.bms.tool.exception.DAOException;

public interface ProductCostDAO extends HibernateBase<ProductCost> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getProductCostCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ProductCost> getPagingProductCost(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有产品费用
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProductCost> getAllProductCost() throws DAOException;

	public List<ProductCost> findProductCostsByProduct(Product product)throws DAOException;

}
