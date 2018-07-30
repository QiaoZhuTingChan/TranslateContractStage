package com.jyd.bms.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractStageDAO extends HibernateBase<ContractStage> {

	public List<ContractStage> getPagingContractStageByStore(int firstResult, int maxResults, Store store)
			throws DAOException;

	public int getContractStageCountByStore(Map map) throws DAOException;

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractStageCount(Integer para, String customer, Date startDate, Date endDate) throws DAOException;
	
	public int getContractStageByCus(CustomerContract contract) throws DAOException;
	
	public int getContractStageCountByStore(Integer para, String customer, Date startDate, Date endDate, Store store)
			throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStage> getPagingContractStage(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<ContractStage> getPagingContractStageByStore(int firstResult, int maxResults, String condition,
			Store store) throws DAOException;

	/**
	 * 合同的所有分期
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStage> getAllContractStage() throws DAOException;

	/**
	 * 查找合同分期
	 * 
	 * @param contract
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStage> findContractStageByContract(CustomerContract contract) throws DAOException;

	/**
	 * 查找合同分期时间
	 * 
	 * @param repaymentDate
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStage> findContractStageByDate(Date repaymentDate) throws DAOException;

	/**
	 * 通过分期查找合同的费用
	 * 
	 * @param repaymentDate
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<ContractStage> findContractStageByDateAndStore(Date repaymentDate, Store store) throws DAOException;

	/**
	 * 查找逾期费用
	 * 
	 * @return
	 * @throws DAOException
	 */

	public List<ContractStage> findContractStageByContractAndStages(CustomerContract contract, int stage)
			throws DAOException;

	public List<ContractStage> findLateTimeContractStage() throws DAOException;

	public ContractStage findContractStageByContractAndStage(CustomerContract contract, int stage) throws DAOException;

	public ContractStage findContractStageByContractAndCurrentMonth(CustomerContract contract) throws DAOException;

	public ContractStage findContractStageByContractAndLastMonth(CustomerContract contract) throws DAOException;

	public ContractStage findContractStageByContractAndState(CustomerContract contract) throws DAOException;

	public ContractStage findContractStageByContractAndLast(CustomerContract contract) throws DAOException;

	public List<ContractStage> getContractStageByPara(int firstResult, int maxResults, Integer para, String customer,
			String startDate, String endDate) throws DAOException, ParseException;

	public List<ContractStage> getContractStageByParaAndStore(int firstResult, int maxResults, Integer para,
			String customer, String startDate, String endDate, Store store) throws DAOException, ParseException;

	public List<ContractStage> getContractStageByContract(CustomerContract contract) throws DAOException;

	/**
	 * @category 剩余利息期数
	 * @param contract
	 * @return
	 * @throws DAOException
	 */
	public int getSurplusInterestStage(CustomerContract contract) throws DAOException;

	/**
	 * @category 剩余本金期数
	 * @param contract
	 * @return
	 * @throws DAOException
	 */
	public int getSurplusPrincipalStage(CustomerContract contract) throws DAOException;

	/**
	 * @category 本金存金量
	 * @param contract
	 * @return
	 * @throws DAOException
	 */
	public double getPrincipalDeposit(CustomerContract contract) throws DAOException;

	public int getRepaidMax(CustomerContract contract) throws DAOException;

	public void deleteAll(CustomerContract contract) throws DAOException;

	public ContractStage getNextByContractStage(ContractStage stage, CustomerContract contract) throws DAOException;

	public int excuteBatchInsertContractStage(Set<ContractStage> contractStageList);
}
