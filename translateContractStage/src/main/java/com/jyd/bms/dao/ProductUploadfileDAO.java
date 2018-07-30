package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductUploadfile;
import com.jyd.bms.tool.exception.DAOException;

public interface ProductUploadfileDAO extends HibernateBase<ProductUploadfile> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getProductUploadfileCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ProductUploadfile> getPagingProductUploadfile(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询产品文件上传类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProductUploadfile> getAllProductUploadfile() throws DAOException;

	public List<ProductUploadfile> findProductUploadfilesByProduct(Product product)throws DAOException;

}
