package com.jyd.bms.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category 合同GPS费用抽象类
 * @author mjy
 */
@Entity
public interface ContractGpsLateFeeDAO extends HibernateBase<ContractGpsLateFee> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractGpsLateFeeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractGpsLateFee> getPagingContractGpsLateFee(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractGpsLateFee> getAllContractGpsLateFee() throws DAOException;

	/**
	 * 查找当天某门店的费用记录
	 * 
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<ContractGpsLateFee> findContractGpsLateFeeByStore(Store store) throws DAOException;

	/**
	 * 获取同一天内相同的费用记录条数
	 * 
	 * @param contract
	 * @return
	 * @throws DAOException
	 */
	public int getSameContractGpsLateFeeCountByDay(CustomerContract contract) throws DAOException;

	public int getCountByCustomerContract(CustomerContract contract) throws DAOException;

	public List<ContractGpsLateFee> findContractGpsLateFeeListByCustomerContract(CustomerContract contract)
			throws DAOException;

	public ContractGpsLateFee findContractGpsLateFeeByCustomerContract(CustomerContract contract) throws DAOException;

	public void deleteAll(CustomerContract contract) throws DAOException;

	public int excuteBatchInsertContractGpsLateFee(Set<ContractGpsLateFee> contractGpsLateFeeList);
}
