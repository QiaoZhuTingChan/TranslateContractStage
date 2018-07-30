package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductPara;
import com.jyd.bms.tool.exception.DAOException;

public interface ProductParaDAO extends HibernateBase<ProductPara> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getProductParaCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ProductPara> getPagingProductPara(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有产品参数
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProductPara> getAllProductPara() throws DAOException;

	
	public List<ProductPara> findProductParasByProduct(Product product)throws DAOException;

	/**
	 * 根据产品跟前置参数类型，查找前置值
	 * @param product
	 * @return
	 * @throws DAOException
	 */
	public ProductPara getProductParasByProductAndPrepose(Product product)throws DAOException;

}
