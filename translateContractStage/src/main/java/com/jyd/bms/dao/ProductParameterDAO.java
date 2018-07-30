package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ProductParameter;
import com.jyd.bms.tool.exception.DAOException;

public interface ProductParameterDAO extends HibernateBase<ProductParameter> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getProductParameterCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ProductParameter> getPagingProductParameter(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有产品参数类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProductParameter> getAllProductParameter() throws DAOException;

}
