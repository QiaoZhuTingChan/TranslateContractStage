package com.jyd.bms.dao;

import java.util.List;
import java.util.Set;

import com.jyd.bms.bean.CusContractCost;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;

public interface CusContractCostDAO extends HibernateBase<CusContractCost> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getCusContractCostCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<CusContractCost> getPagingCusContractCost(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有客户合同的费用
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<CusContractCost> getAllCusContractCost() throws DAOException;

	public List<CusContractCost> getCusContractCostByContract(CustomerContract contract) throws DAOException;

	public void deleteAll(CustomerContract contract) throws DAOException;

	public int excuteBatchInsertCusContractCost(Set<CusContractCost> cusContractCostList);
}
