package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductStore;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface ProductStoreDAO extends HibernateBase<ProductStore> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getProductStoreCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ProductStore> getPagingProductStore(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有产品门店
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProductStore> getAllProductStore() throws DAOException;

	/**
	 * @category 通过门店查产品
	 */
	public List<ProductStore> getProductByStore(Store store) throws DAOException;

	public List<ProductStore> findProductStoresByProduct(Product product)throws DAOException;
}
