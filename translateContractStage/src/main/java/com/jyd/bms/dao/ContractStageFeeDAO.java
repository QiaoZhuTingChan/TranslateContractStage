package com.jyd.bms.dao;

import java.util.List;
import java.util.Set;

import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.ContractStageFee;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractStageFeeDAO extends HibernateBase<ContractStageFee> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractStageFeeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStageFee> getPagingContractStageFee(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有合同分期费用
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStageFee> getAllContractStageFee() throws DAOException;

	public List<ContractStageFee> findContractStageFeeByContractStage(ContractStage contractStage) throws DAOException;

	/**
	 * @category 删除逾期费用
	 * @param contractStage
	 * @throws DAOException
	 */
	public void deleteAll(ContractStage stage) throws DAOException;

	/**
	 * @category 额外费用
	 * @param stage
	 * @return
	 * @throws DAOException
	 */
	public Double getExtraCharges(ContractStage stage) throws DAOException;

	/**
	 * 根据合同分期拿到合同分期费用
	 * @param penultimate 先息后本倒数第二期
	 * @return
	 * @throws DAOException
	 */
	public ContractStageFee getContractStageFeeByContractStage(ContractStage penultimate)throws DAOException;

	public int excuteBatchInsertContractStageFee(Set<ContractStageFee> contractStageFeeList);
	
}
