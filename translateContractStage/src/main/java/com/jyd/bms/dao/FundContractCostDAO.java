package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.FundContract;
import com.jyd.bms.bean.FundContractCost;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-25 14:19:55 by GeneratedTool
 * @author mjy
 */
public interface FundContractCostDAO extends HibernateBase<FundContractCost> {
	public int getFundContractCostCount(String condition) throws DAOException;

	public List<FundContractCost> getPagingFundContractCost(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<FundContractCost> getAllFundContractCost() throws DAOException;

	public List<FundContractCost> getAllFundContractCostByfundContract(FundContract fundContract) throws DAOException;
}