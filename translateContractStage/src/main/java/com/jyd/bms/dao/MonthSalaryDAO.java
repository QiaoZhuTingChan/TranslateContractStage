package com.jyd.bms.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.jyd.bms.bean.ContractLateFee;
import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeSalary;
import com.jyd.bms.bean.MonthSalary;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface MonthSalaryDAO extends HibernateBase<MonthSalary>{

	/**
     *  查询月薪资
	 * @param employee
	 *        员工
	 * @param yearMonth
	 *        年月
	 * @return
	 * @throws DAOException
	 */
	public MonthSalary getMonthSalary(Employee employee,String yearMonth) throws DAOException;
	
	/**
	 * 根据制定年月查询锁定的月薪
	 * @param yearmonth
	 * @return
	 * @throws DAOException
	 */
	public List<MonthSalary> getMonthSalaryLocked(Employee employee, Department department, Store store,String yearMonth) throws DAOException;

	public List<MonthSalary> getMonthSalaryByEmployee(Employee employee, Department department, Store store, String yearMonth)throws DAOException;
	
	
	
	/**
	 * 查询员工月薪资结果
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getEmployeeSalaryViewCount(String condition,String yearMonth) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<MonthSalary> getPagingEmployeeSalaryView(int firstResult, int maxResults, String condition,String yearMonth) throws DAOException;

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<MonthSalary> getAllEmployeeSalaryView() throws DAOException;
	
	
	//分页查询
	public List<ContractLateFee> getPagingSalaryView(int firstResult, int maxResults,
			Map<String, Object> mapPara) throws DAOException, ParseException;
	
	//统计
	public int getSalaryViewCount(Map<String, Object> mapPara) throws DAOException, ParseException;

}
