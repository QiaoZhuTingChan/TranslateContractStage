package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeDuty;
import com.jyd.bms.tool.exception.DAOException;

public interface EmployeeDutyDAO extends HibernateBase<EmployeeDuty> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getEmployeeDutyCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeDuty> getPagingEmployeeDuty(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有职责
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeDuty> getAllEmployeeDuty() throws DAOException;
	
	public List<EmployeeDuty> findEmployeeDutyByEmp(Employee emp) throws DAOException;

}
