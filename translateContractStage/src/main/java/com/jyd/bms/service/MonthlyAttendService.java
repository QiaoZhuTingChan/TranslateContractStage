package com.jyd.bms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.MonthlyAttend;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dao.MonthlyAttendDAO;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

@Service("MonthlyAttendService")
public class MonthlyAttendService extends BaseService<MonthlyAttend>{

	@Autowired(required=true)
	private MonthlyAttendDAO monthlyAttendDAO;
	
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
			throws DAOException{
		return monthlyAttendDAO.getEmployeeMonthAttendenceValue(salaryItem, employee, yearMonth);
	}

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
			List<Employee> listEmployee, String yearMonth) throws DAOException {
		return monthlyAttendDAO.getEmployeeMonthAttendenceValueByEmployeeList(salaryItem, listEmployee, yearMonth);
	}
	
		
	@Override
	public void setDAO() {
		this.baseDAO = monthlyAttendDAO;
	}

}
