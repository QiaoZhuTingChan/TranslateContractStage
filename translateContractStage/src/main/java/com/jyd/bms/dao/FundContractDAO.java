package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.FundContract;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-25 14:05:15 by GeneratedTool
 * @author mjy
 */
public interface FundContractDAO extends HibernateBase<FundContract> {
	public int getFundContractCount(String condition) throws DAOException;

	public List<FundContract> getPagingFundContract(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<FundContract> getAllFundContract() throws DAOException;
}