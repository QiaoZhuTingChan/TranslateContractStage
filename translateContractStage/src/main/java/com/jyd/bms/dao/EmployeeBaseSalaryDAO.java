package com.jyd.bms.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeBaseSalary;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

public interface EmployeeBaseSalaryDAO extends HibernateBase<EmployeeBaseSalary> {

	/**
	 * 获取员工基本薪资
	 * 
	 * @param salaryItem
	 *            薪资项目
	 * @param employee
	 *            员工
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 */
	public double getEmployeeBaseSalaryValue(SalaryItem salaryItem, Employee employee, String yearMonth)
			throws DAOException, ParseException ;

	/**
	 * 批量获取员工基本薪资
	 * 
	 * @param salaryItem
	 *            薪资项目
	 * @param listEmployee
	 *            员工列表
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 */
	public Map<String, EmployeeSalaryDataDTO> getEmployeeBaseSalaryValueByEmployeeList(SalaryItem salaryItem,
			List<Employee> listEmployee, String yearMonth) throws DAOException, ParseException ;

	public int deleteEmployeeBaseSalaryByEmployee(Employee employee);

	public List<EmployeeBaseSalary> getEmployeeBaseSalaryByEmployee(Employee employee) throws DAOException;
	
	/**
	 * 根据薪资结构获取员工薪资
	 * @param salaryStructureId
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeBaseSalary> getSalaryByStructure(int salaryStructureId) throws DAOException;
	
	/**薪资项目
	 * 根据员工获取基本
	 * @param employee
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeBaseSalary> getSalarysByEmployee(Employee employee) throws DAOException;
}
