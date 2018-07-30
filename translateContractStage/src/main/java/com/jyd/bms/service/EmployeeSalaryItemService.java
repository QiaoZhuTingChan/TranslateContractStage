package com.jyd.bms.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeSalaryItem;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dao.EmployeeSalaryItemDAO;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

@Service("EmployeeSalaryItemService")
public class EmployeeSalaryItemService extends BaseService<EmployeeSalaryItem> {

	@Autowired
	private EmployeeSalaryItemDAO employeeSalaryItemDAO;

	/**
	 * 
	 * @param condition
	 * @param type
	 *            薪资项目类型：'类型,0计算公式，1请假，2加班，3出差，4旷工，5迟到，6早退，7基本薪资项目，8手工录入项目，9保险'
	 * @return
	 * @throws DAOException
	 */
	public int getEmployeeSalaryItemCount(String condition, Integer type, String date, boolean flag,
			String salaryItemType) throws DAOException {
		return employeeSalaryItemDAO.getEmployeeSalaryItemCount(condition, type, date, flag, salaryItemType);
	}

	/**
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @param type
	 *            薪资项目类型：'类型,0计算公式，1请假，2加班，3出差，4旷工，5迟到，6早退，7基本薪资项目，8手工录入项目，9保险'
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeSalaryItem> getPagingEmployeeSalaryItem(int firstResult, int maxResults, String condition,
			Integer type, String date, boolean flag, String salaryItemType) throws DAOException {
		return employeeSalaryItemDAO.getPagingEmployeeSalaryItem(firstResult, maxResults, condition, type, date, flag,
				salaryItemType);
	}

	/**
	 * 
	 * @param type
	 *            薪资项目类型：'类型,0计算公式，1请假，2加班，3出差，4旷工，5迟到，6早退，7基本薪资项目，8手工录入项目，9保险'
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeSalaryItem> getAllEmployeeSalaryItem(Integer type) throws DAOException {
		return employeeSalaryItemDAO.getAllEmployeeSalaryItem(type);
	}

	/**
	 * 获取手工录入的值
	 * 
	 * @param salaryItem
	 * @param emp
	 * @param yearMs
	 * @return
	 * @throws DAOException
	 */
	public double getEmployeeSalaryItemByEmployee(SalaryItem salaryItem, Employee emp, String yearMs)
			throws DAOException {
		return employeeSalaryItemDAO.getEmployeeSalaryItemByEmployee(salaryItem, emp, yearMs);
	}

	/**
	 * 批量获取手工录入的值
	 * 
	 * @param salaryItem
	 * @param listEmployee
	 * @param yearMonth
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	public Map<String, EmployeeSalaryDataDTO> getEmployeeSalaryItemValueByEmployeeList(SalaryItem salaryItem,
			List<Employee> listEmployee, String yearMonth) throws DAOException, ParseException {
		return employeeSalaryItemDAO.getEmployeeSalaryItemValueByEmployeeList(salaryItem, listEmployee, yearMonth);
	}

	@Override
	public void setDAO() {
		this.baseDAO = employeeSalaryItemDAO;
	}

}
