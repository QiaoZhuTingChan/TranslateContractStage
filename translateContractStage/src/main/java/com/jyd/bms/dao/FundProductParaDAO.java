package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.FundProduct;
import com.jyd.bms.bean.FundProductPara;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-25 14:19:07 by GeneratedTool
 * @author mjy
 */
public interface FundProductParaDAO extends HibernateBase<FundProductPara> {
	public int getFundProductParaCount(String condition) throws DAOException;

	public List<FundProductPara> getPagingFundProductPara(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<FundProductPara> getAllFundProductPara() throws DAOException;

	/**
	 * 根据资金方产品查产品参数
	 * 
	 * @param fundProduct
	 * @return
	 * @throws DAOException
	 */
	public List<FundProductPara> getAllFundProductParaByFundProduct(FundProduct fundProduct) throws DAOException;

}