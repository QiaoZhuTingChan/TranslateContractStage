package com.jyd.bms.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.BaseSalaryItem;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeBaseSalary;
import com.jyd.bms.bean.EmployeeBaseSalaryHistory;
import com.jyd.bms.bean.EmployeeSalary;
import com.jyd.bms.bean.EmployeeSalaryHistory;
import com.jyd.bms.bean.SalaryStructure;
import com.jyd.bms.bean.SalaryStructureBaseSalaryItem;
import com.jyd.bms.bean.User;
import com.jyd.bms.dao.EmployeeSalaryDAO;
import com.jyd.bms.tool.exception.CreateException;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.UpdateException;

@Service("EmployeeSalaryService")
public class EmployeeSalaryService extends BaseService<EmployeeSalary> {
	@Autowired
	private EmployeeSalaryDAO employeeSalaryDAO;
	@Autowired
	private EmployeeSalaryHistoryService employeeSalaryHistoryService;// 员工薪资历史
	@Autowired
	private EmployeeBaseSalaryHistoryService employeeBaseSalaryHistoryService;// 员工基本薪资项目修改历史
	@Autowired
	private EmployeeBaseSalaryService employeeBaseSalaryService;// 员工基本薪资

	public int getEmployeeSalaryCount(String condition) throws DAOException {
		return employeeSalaryDAO.getEmployeeSalaryCount(condition);
	}

	public List<EmployeeSalary> getPagingEmployeeSalary(int firstResult, int maxResults, String condition)
			throws DAOException {
		return employeeSalaryDAO.getPagingEmployeeSalary(firstResult, maxResults, condition);
	}

	public List<EmployeeSalary> getAllEmployeeSalary() throws DAOException {
		return employeeSalaryDAO.getAllEmployeeSalary();
	}

	public EmployeeSalary getEmployeeSalaryByEmployee(Employee employee) throws DAOException {
		return employeeSalaryDAO.getEmployeeSalaryByEmployee(employee);
	}

	@Override
	public void setDAO() {
		this.baseDAO = employeeSalaryDAO;

	}

	/**
	 * 更新基本薪资列表
	 * 
	 * @param employeeSalary
	 * @param employee
	 * @param esh
	 * @param newdata
	 * @param predata
	 * @param date
	 * @param sessionUser
	 * @throws UpdateException
	 * @throws CreateException
	 */
	public void updateBaseSalaryList(EmployeeSalary employeeSalary, Employee employee, EmployeeSalaryHistory esh,

			Map<BaseSalaryItem, Double> newdata, Map<BaseSalaryItem, Double> predata, Timestamp date,
			User sessionUser, List<EmployeeBaseSalary> employeeBaseSalaryList) throws UpdateException, CreateException {

		// 更新 员工薪资表
		employeeSalaryDAO.update(employeeSalary);

		// 更新 员工基本薪资
		for (EmployeeBaseSalary employeeBaseSalary : employeeBaseSalaryList) {
			BaseSalaryItem bsi = employeeBaseSalary.getBaseSalaryItem();
			for (BaseSalaryItem bsiKey : newdata.keySet()) {
				if (bsi.getId() == bsiKey.getId()) {
					employeeBaseSalary.setValue(newdata.get(bsiKey));
					employeeBaseSalaryService.update(employeeBaseSalary);
					break;
				}
			}
		}

		// 添加 员工薪资历史表添加数据，用于记录
		employeeSalaryHistoryService.add(esh);

		// 添加 员工基本薪资项目修改历史添加数据，用于记录
		for (BaseSalaryItem baseSalaryItemId : predata.keySet()) {
			EmployeeBaseSalaryHistory ebsh = new EmployeeBaseSalaryHistory();
			ebsh.setEmployeeSalaryHistory(esh);
			ebsh.setEmployee(employee);
			ebsh.setBaseSalaryItem(baseSalaryItemId);
			ebsh.setValue(newdata.get(baseSalaryItemId));
			employeeBaseSalaryHistoryService.add(ebsh);
		}
	}

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
			throws DAOException, ParseException {
		return employeeSalaryDAO.getEmployeeSalaryStructureByYearMonth(employee, yearMonth);
	}

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
			List<Employee> listUnkownSalaryStructureEmployee) throws DAOException, ParseException {
		return employeeSalaryDAO.getEmployeeSalaryStructureByYearMonth(listEmployee, yearMonth, listUnkownSalaryStructureEmployee);
	}

	
	public List<Employee> getEmployeeWhoHasSalaryStracture() throws DAOException{
		return employeeSalaryDAO.getEmployeeWhoHasSalaryStracture();
	}
	
	/**
	 *  根据员工查询员工薪资和薪资机构，薪资级别
	 * @param employee
	 * @return
	 * @throws DAOException
	 */
	public EmployeeSalary getSalaryAndStructureByEmployee(Employee employee) throws DAOException {
		return employeeSalaryDAO.getSalaryAndStructureByEmployee(employee);
	}
}
