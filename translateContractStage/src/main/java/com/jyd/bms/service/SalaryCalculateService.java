package com.jyd.bms.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dao.EmployeeBaseSalaryDAO;
import com.jyd.bms.dao.EmployeeSalaryItemDAO;
import com.jyd.bms.dao.InsuranceDAO;
import com.jyd.bms.dao.MonthlyAttendDAO;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

@Service("SalaryCalculateService")
public class SalaryCalculateService {
	@Autowired(required = true)
	private EmployeeSalaryItemDAO employeeSalaryItemDAO;

	@Autowired(required = true)
	private MonthlyAttendDAO monthlyAttendDAO;

	@Autowired(required = true)
	private EmployeeBaseSalaryDAO employeeBaseSalaryDAO;

	@Autowired(required = true)
	private InsuranceDAO insuranceDAO;

	/**
	 * 获取员工薪资项目值，依据salaryItem.type取对应数据
	 * 
	 * @param salaryItem
	 *            薪资项目
	 * @param employee
	 *            员工
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	public double getSalaryItemValue(SalaryItem salaryItem, Employee employee, String yearMonth)
			throws DAOException, ParseException {
		/* 类型,0计算公式，1请假，2加班，3出差，4旷工，5迟到，6早退，7基本薪资项目(員工基本薪资)，8手工录入项目，9保险 */
		switch (salaryItem.getType()) {
		case 1:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValue(salaryItem, employee, yearMonth);
		case 2:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValue(salaryItem, employee, yearMonth);
		case 3:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValue(salaryItem, employee, yearMonth);
		case 4:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValue(salaryItem, employee, yearMonth);
		case 5:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValue(salaryItem, employee, yearMonth);
		case 6:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValue(salaryItem, employee, yearMonth);
		case 7:
			return employeeBaseSalaryDAO.getEmployeeBaseSalaryValue(salaryItem, employee, yearMonth);
		case 8:
			return employeeSalaryItemDAO.getEmployeeSalaryItemByEmployee(salaryItem, employee, yearMonth);
		case 9:
			return insuranceDAO.getInsuranceTypeValue(salaryItem, employee, yearMonth);
		}
		return 0d;
	}

	/**
	 * 批量获取员工月考勤结果
	 * 
	 * @param salaryItem
	 *            薪资项目
	 * @param listEmployee
	 *          break  员工列表
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	public Map<String, EmployeeSalaryDataDTO> getSalaryItemValue(SalaryItem salaryItem, List<Employee> listEmployee,
			String yearMonth) throws DAOException, ParseException {
		/* 类型,0计算公式，1请假，2加班，3出差，4旷工，5迟到，6早退，7基本薪资项目(員工基本薪资)，8手工录入项目，9保险 */
		switch (salaryItem.getType()) {
		case 1:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValueByEmployeeList(salaryItem, listEmployee, yearMonth);
		case 2:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValueByEmployeeList(salaryItem, listEmployee, yearMonth);
		case 3:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValueByEmployeeList(salaryItem, listEmployee, yearMonth);
		case 4:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValueByEmployeeList(salaryItem, listEmployee, yearMonth);
		case 5:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValueByEmployeeList(salaryItem, listEmployee, yearMonth);
		case 6:
			return monthlyAttendDAO.getEmployeeMonthAttendenceValueByEmployeeList(salaryItem, listEmployee, yearMonth);
		case 7:
			return employeeBaseSalaryDAO.getEmployeeBaseSalaryValueByEmployeeList(salaryItem, listEmployee, yearMonth);
		case 8:
			return employeeSalaryItemDAO.getEmployeeSalaryItemValueByEmployeeList(salaryItem, listEmployee, yearMonth);
		case 9:
			return insuranceDAO.getInsuranceTypeValueByEmployeeList(salaryItem, listEmployee, yearMonth);
		}
		return null;
	}

}
