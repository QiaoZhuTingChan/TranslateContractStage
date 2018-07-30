package com.jyd.bms.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeSalaryItem;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

public interface EmployeeSalaryItemDAO extends HibernateBase<EmployeeSalaryItem> {

	/**
	 * 
	 * @param condition
	 * @param type
	 *            type 薪资项目类型：'类型,0计算公式，1请假，2加班，3出差，4旷工，5迟到，6早退，7基本薪资项目，8手工录入项目，9保险'
	 * @param date
	 * @param salaryItem
	 * @return
	 * @throws DAOException
	 */
	public int getEmployeeSalaryItemCount(String condition, Integer type, String date, boolean flag,
			String salaryItemType) throws DAOException;

	/**
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @param type
	 *            薪资项目类型：'类型,0计算公式，1请假，2加班，3出差，4旷工，5迟到，6早退，7基本薪资项目，8手工录入项目，9保险'
	 * @param date
	 * @param salaryItem
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeSalaryItem> getPagingEmployeeSalaryItem(int firstResult, int maxResults, String condition,
			Integer type, String date, boolean flag, String salaryItemType) throws DAOException;

	/**
	 * 
	 * @param type
	 *            薪资项目类型：'类型,0计算公式，1请假，2加班，3出差，4旷工，5迟到，6早退，7基本薪资项目，8手工录入项目，9保险'
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeSalaryItem> getAllEmployeeSalaryItem(Integer type) throws DAOException;

	
	
	/**
	 * @category 获取手工录入的值
	 * @param emp
	 * @return
	 * @throws DAOException
	 */
	public double getEmployeeSalaryItemByEmployee(SalaryItem salaryItem,Employee emp,String yearMs) throws DAOException;
	
	
	/**
	 * @category 批量获取手工录入的值
	 * @param salaryItem
	 * @param listEmployee
	 * @param yearMonth
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	public Map<String, EmployeeSalaryDataDTO> getEmployeeSalaryItemValueByEmployeeList(SalaryItem salaryItem,
			List<Employee> listEmployee,String yearMonth) throws DAOException, ParseException;
}
