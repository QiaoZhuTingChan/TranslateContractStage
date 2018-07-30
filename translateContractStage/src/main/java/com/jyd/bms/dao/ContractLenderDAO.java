package com.jyd.bms.dao;

import java.util.List;
import java.util.Set;

import com.jyd.bms.bean.ContractLender;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractLenderDAO extends HibernateBase<ContractLender> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractLenderCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLender> getPagingContractLender(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有合同的出借人
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLender> getAllContractLender() throws DAOException;

	public List<ContractLender> getContractLenderByContract(CustomerContract contract) throws DAOException;

	public void deleteAll(CustomerContract contract) throws DAOException;

	public int excuteBatchInsertContractLender(Set<ContractLender> contractLenderList);
}
