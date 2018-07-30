package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Contract;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractDAO extends HibernateBase<Contract> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Contract> getPagingContract(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有合同
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Contract> getAllContract() throws DAOException;
	
	public List<Contract> findContractByEmp(Employee emp) throws DAOException;

}
