package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.MonthSalary;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.MonthSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("MonthSalaryService")
public class MonthSalaryService extends BaseService<MonthSalary> {

	@Autowired(required = true)
	private MonthSalaryDAO monthSalaryDAO;

	/**
	 * 查询月薪资
	 * 
	 * @param employee
	 *        员工
	 * @param yearMonth
	 *        年月
	 * @return
	 * @throws DAOException
	 */
	public MonthSalary getMonthSalary(Employee employee, String yearMonth) throws DAOException {
		return monthSalaryDAO.getMonthSalary(employee, yearMonth);
	}
	
	
	public int getEmployeeSalaryViewCount(String condition,String yearMonth) throws DAOException {
		return monthSalaryDAO.getEmployeeSalaryViewCount(condition, yearMonth);
	}

	public List<MonthSalary> getPagingEmployeeSalary(int firstResult, int maxResults, String condition,String yearMonth)
			throws DAOException {
		return monthSalaryDAO.getPagingEmployeeSalaryView(firstResult, maxResults, condition, yearMonth);
	}

	public List<MonthSalary> getAllEmployeeSalary() throws DAOException {
		return monthSalaryDAO.getAllEmployeeSalaryView();
	}  
	
	
	
    /*计算员工*/
	public void calculateEmployee(Employee employee, String yearMonth) throws Exception {
		MonthSalary monthSalary = new MonthSalary();
	}

	/**
	 * 根据指定年月查询已锁定的每月薪资
	 * @return
	 * @throws DAOException 
	 */
	public List<MonthSalary> getMonthSalaryLocked(Employee employee, Department department, Store store,String yearMonth) throws DAOException {
		return monthSalaryDAO.getMonthSalaryLocked(employee, department, store, yearMonth);
	}
	
	/**
	 * 根据，员工、部门、门店查询每月薪资。参数都为null, 查所有；
	 * @param employee 如果员工不为空，注意，只返回一个结果
	 * @param department
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<MonthSalary> getMonthSalaryByEmployee(Employee employee, Department department, Store store, String yearMonth) throws DAOException {
		return monthSalaryDAO.getMonthSalaryByEmployee(employee, department, store, yearMonth);
	}
	
	@Override
	public void setDAO() {
		this.baseDAO = monthSalaryDAO;
	}

	
	
}
