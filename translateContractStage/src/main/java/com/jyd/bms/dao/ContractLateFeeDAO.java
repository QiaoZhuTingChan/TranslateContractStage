package com.jyd.bms.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jyd.bms.bean.ContractLateFee;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractLateFeeDAO extends HibernateBase<ContractLateFee> {

	public List<ContractLateFee> getContractLateFeeByContractRepayDate(CustomerContract contract) throws DAOException;

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractLateFeeCount(String condition) throws DAOException;

	public int getContractLateFeeCountByStore(String condition, Store store) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLateFee> getPagingContractLateFee(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<ContractLateFee> getPagingContractLateFeeByStore(int firstResult, int maxResults, String condition,
			Store store) throws DAOException;

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLateFee> getAllContractLateFee() throws DAOException;

	/**
	 * 查找当天所有门店的逾期记录
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLateFee> findContractLateFeeByToday() throws DAOException;

	/**
	 * 查找当天某门店的逾期记录
	 * 
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLateFee> findContractLateFeeByTodayAndStore(Store store) throws DAOException;

	/**
	 * 获取同一天内相同的逾期记录条数
	 * 
	 * @param contract
	 * @return
	 * @throws DAOException
	 */
	public int getSameContractLateFeeCountByDay(CustomerContract contract) throws DAOException;

	public ContractLateFee findContractLateFeeByContractAndLast(CustomerContract contract, Date date)
			throws DAOException;

	public ContractLateFee findContractLateFeeByContractAndDate(CustomerContract contract) throws DAOException;

	public List<ContractLateFee> findContractLateFeeByContractStagesAndLast(List<ContractStage> contractStages)
			throws DAOException;

	public ContractLateFee findContractLateFeeByContractDate(CustomerContract contract, Date date) throws DAOException;

	public List<ContractLateFee> getContractLateFeeByContract(CustomerContract contract) throws DAOException;

	/**
	 * @category 查询当期是否逾期
	 * @param stage
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLateFee> findContractLateFeeByContractStage(ContractStage stage) throws DAOException;

	/**
	 * 分页查询
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @param state
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLateFee> getPagingContractLateFeeParam(int firstResult, int maxResults,
			Map<String, Object> mapPara) throws DAOException, ParseException;

	/**
	 * @category 统计
	 * @param condition
	 * @param state
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	public int getContractLateFeeParamCount(Map<String, Object> mapPara) throws DAOException, ParseException;

}
