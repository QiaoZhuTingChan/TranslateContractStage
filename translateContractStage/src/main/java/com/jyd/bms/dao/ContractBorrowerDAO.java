package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContractBorrower;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractBorrowerDAO extends HibernateBase<ContractBorrower> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getBorrowerCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractBorrower> getPagingBorrower(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractBorrower> getAllBorrower() throws DAOException;

	public List<ContractBorrower> getContractBorrowerByContract(CustomerContract contract) throws DAOException;

	public void deleteAll(CustomerContract contract) throws DAOException;
}
