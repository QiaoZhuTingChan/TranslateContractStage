package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.ProductRepaymentStage;
import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.tool.exception.DAOException;

public interface ProductRepaymentStageDAO extends HibernateBase<ProductRepaymentStage> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getProductRepaymentStageCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ProductRepaymentStage> getPagingProductRepaymentStage(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有产品的还款分期
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProductRepaymentStage> getAllProductRepaymentStage() throws DAOException;

	public List<ProductRepaymentStage> findProductRepaymentStagesByProduct(Product product) throws DAOException;

	/**
	 * @category 产品分期
	 * @return
	 * @throws DAOException
	 */
	public ProductRepaymentStage getProductRepaymentStage(Product product, RepaymentStage stage) throws DAOException;

	/**
	 *  根据产品跟期数，查找服务费期数
	 * @param product
	 * @param stage
	 * @return
	 * @throws DAOException 
	 */
	public ProductRepaymentStage getProductRepaymentStagesByProductAndStage(Product product, RepaymentStage stage) throws DAOException;
}
