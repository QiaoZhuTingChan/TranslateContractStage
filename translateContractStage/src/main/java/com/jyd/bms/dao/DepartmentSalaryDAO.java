package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.tool.exception.DAOException;

public interface DepartmentSalaryDAO extends HibernateBase<Employee> {

	/**
	 * 获取当前部门下的所有员工
	 * 
	 * @param department
	 *            部门
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 */
	public List<Employee> getEmployeeByDepartmentAndYearmonth(Department department, String yearMonth)
			throws DAOException;

}