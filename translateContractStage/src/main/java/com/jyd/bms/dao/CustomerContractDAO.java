package com.jyd.bms.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface CustomerContractDAO extends HibernateBase<CustomerContract> {

	public int getCustomerContractByParaCount(String condition) throws DAOException;

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getCustomerContractCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<CustomerContract> getPagingCustomerContract(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有客户合同
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<CustomerContract> getAllCustomerContract() throws DAOException;

	/**
	 * 查询以门店开始加日期当天最大的
	 * 
	 * @return
	 * @throws DAOException
	 */
	public String getCustomerContractNum(String contractNum) throws DAOException;

	/**
	 * @category 根据合同编号查合同
	 * @param contractNum
	 * @return
	 * @throws DAOException
	 */
	public CustomerContract getContractByNum(String contractNum) throws DAOException;

	public CustomerContract getContractByIdNum(String contractNum) throws DAOException;

	/**
	 * 获取门店合同数量
	 * 
	 * @param condition
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public int getStoreCustomerContractCount(String condition, Store store) throws DAOException;

	/**
	 * 获取门店合同分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<CustomerContract> getPagingStoreCustomerContract(int firstResult, int maxResults, String condition,
			Store store) throws DAOException;

	public List<CustomerContract> findCustomerContractByEmp(Employee emp) throws DAOException;

	public List<CustomerContract> findPagingCustomerContractByEmp(Employee emp, String condition, int firstResult,
			int maxResults) throws DAOException;

	public List<CustomerContract> findPagingCustomerContractByEmp(List<Employee> emps, String condition,
			int firstResult, int maxResults) throws DAOException;

	public int findCustomerContractCountByEmp(Employee emp, String condition) throws DAOException;

	public int findCustomerContractCountByEmp(List<Employee> emps, String condition) throws DAOException;

	public List<CustomerContract> findCustomerContractByStoreAndDate(Store store, Date begin, Date end)
			throws DAOException;

	public List<CustomerContract> findCustomerContractByDate(Date begin, Date end) throws DAOException;

	public List<CustomerContract> findCustomerContractByStoreAndDateAndSellerDefaultDate(Store store, Date begin,
			Date end) throws DAOException;

	public List<CustomerContract> findCustomerContractByDateAndSellerDefaultDate(Date begin, Date end)
			throws DAOException;

	public List<CustomerContract> getPagingCustomerByPerson(int firstResult, int maxResults, String condition,
			Employee responsiblePerson) throws DAOException;

	public List<CustomerContract> getCustomerContractCountByPerson(String condition, Employee responsiblePerson)
			throws DAOException;

	public List<CustomerContract> getPagingContractByEmployee(int firstResult, int maxResults, String condition,
			Employee emp) throws DAOException;

	public int getCountContractByEmployee(String condition, Employee emp) throws DAOException;

	/**
	 * 获取未结清合同数量
	 * 
	 * @param type
	 *            类型，0 全部，1 门店
	 * @param store
	 *            门店
	 * @return
	 * @throws DAOException
	 */
	public int getUnSquareContractQuantity(int type, Store store) throws DAOException;

	/**
	 * 获取未结清合同数量,按门店分组
	 * 
	 * @return
	 * @throws DAOException
	 */
//	public List<StoreQuantityDTO> getUnSquareContractQuantityGroupByStore() throws DAOException;

	public int excuteBatchInsertCustomerContract(Set<CustomerContract> customerContractList);

}
