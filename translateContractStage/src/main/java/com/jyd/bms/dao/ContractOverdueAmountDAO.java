package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContractLender;
import com.jyd.bms.bean.ContractOverdueAmount;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractOverdueAmountDAO extends HibernateBase<ContractOverdueAmount> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractOverdueAmountCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractOverdueAmount> getPagingContractOverdueAmount(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有合同未缴款项 
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractOverdueAmount> getAllContractOverdueAmount() throws DAOException;
	public List<ContractOverdueAmount> getContractOverdueAmountByContract(CustomerContract contract)throws DAOException;

}
