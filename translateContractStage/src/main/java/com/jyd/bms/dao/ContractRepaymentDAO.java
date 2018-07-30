package com.jyd.bms.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractRepaymentDAO extends HibernateBase<ContractRepayment> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractRepaymentCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractRepayment> getPagingContractRepayment(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有合同偿还[金融]
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractRepayment> getAllContractRepayment() throws DAOException;

	public List<ContractRepayment> findContractRepaymentByStage(ContractStage stage) throws DAOException;

	public List<ContractRepayment> findContractRepaymentByStageAll(ContractStage stage) throws DAOException;

	public ContractRepayment findContractRepaymentByStageAndLast(ContractStage stage) throws DAOException;

	public List<ContractRepayment> findContractRepaymentByStoreAndDate(Store store, Date begin, Date end)
			throws DAOException;

	public List<ContractRepayment> findContractRepaymentByDate(Date begin, Date end) throws DAOException;

	public void delAll(ContractStage stage) throws DAOException;

	public int excuteBatchInsertContractRepayment(Set<ContractRepayment> contractRepaymentList);
}
