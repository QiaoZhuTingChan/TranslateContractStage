package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Product;
import com.jyd.bms.tool.exception.DAOException;

public interface ProductDAO extends HibernateBase<Product> {
	public Product getProductByName(String condition) throws DAOException;
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getProductCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Product> getPagingProduct(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有产品
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Product> getAllProduct() throws DAOException;
	
}
