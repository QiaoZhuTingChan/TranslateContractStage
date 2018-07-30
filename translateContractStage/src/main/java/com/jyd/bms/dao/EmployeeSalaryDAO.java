package com.jyd.bms.dao;

import java.text.ParseException;
import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeSalary;
import com.jyd.bms.bean.SalaryStructure;
import com.jyd.bms.tool.exception.DAOException;

public interface EmployeeSalaryDAO extends HibernateBase<EmployeeSalary> {

	/**
	 * 查询记录数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getEmployeeSalaryCount(String condition) throws DAOException;;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeSalary> getPagingEmployeeSalary(int firstResult, int maxResults, String condition)
			throws DAOException;;

	/**
	 * 查询所有数据
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeSalary> getAllEmployeeSalary() throws DAOException;

	/**
	 * 根据员工查询员工薪资
	 * 
	 * @param employee
	 * @return
	 * @throws DAOException
	 */
	public EmployeeSalary getEmployeeSalaryByEmployee(Employee employee) throws DAOException;

	/**
	 * 获取员工薪资结构
	 * 
	 * @param employee
	 *            员工
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	public SalaryStructure getEmployeeSalaryStructureByYearMonth(Employee employee, String yearMonth)
			throws DAOException, ParseException;

	/**
	 * 获取员工薪资结构
	 * 
	 * @param listEmployee
	 *            员工列表
	 * @param yearMonth
	 *            年月
	 * @param listUnkownSalaryStructureEmployee
	 *            找不到员工薪资结构的员工
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	public List<EmployeeSalary> getEmployeeSalaryStructureByYearMonth(List<Employee> listEmployee, String yearMonth,
			List<Employee> listUnkownSalaryStructureEmployee) throws DAOException, ParseException;

	public List<Employee> getEmployeeWhoHasSalaryStracture() throws DAOException;
	
	/**
	 * 根据员工查询员工薪资和薪资机构，薪资级别
	 * @return
	 * @throws DAOException
	 */
	public EmployeeSalary getSalaryAndStructureByEmployee(Employee employee) throws DAOException;
}
