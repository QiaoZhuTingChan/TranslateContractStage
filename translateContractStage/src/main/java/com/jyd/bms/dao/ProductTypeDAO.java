package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ProductType;
import com.jyd.bms.tool.exception.DAOException;

public interface ProductTypeDAO extends HibernateBase<ProductType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getProductTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ProductType> getPagingProductType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有产品类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProductType> getAllProductType() throws DAOException;

}
