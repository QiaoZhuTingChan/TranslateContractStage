package com.jyd.bms.dao;

import java.util.List;
import java.util.Map;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.MonthlyAttend;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

public interface MonthlyAttendDAO extends HibernateBase<MonthlyAttend> {
	/**
	 * 获取员工月考勤结果
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
	public double getEmployeeMonthAttendenceValue(SalaryItem salaryItem, Employee employee, String yearMonth)
			throws DAOException;

	/**
	 * 批量获取员工月考勤结果
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
	public Map<String, EmployeeSalaryDataDTO> getEmployeeMonthAttendenceValueByEmployeeList(SalaryItem salaryItem,
			List<Employee> listEmployee, String yearMonth) throws DAOException;
}
