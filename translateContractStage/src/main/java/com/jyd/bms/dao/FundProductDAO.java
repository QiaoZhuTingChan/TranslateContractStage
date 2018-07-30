package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.FundProduct;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-25 14:16:51 by GeneratedTool
 * @author mjy
 */
public interface FundProductDAO extends HibernateBase<FundProduct> {
	public int getFundProductCount(String condition) throws DAOException;

	public List<FundProduct> getPagingFundProduct(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<FundProduct> getAllFundProduct() throws DAOException;
}