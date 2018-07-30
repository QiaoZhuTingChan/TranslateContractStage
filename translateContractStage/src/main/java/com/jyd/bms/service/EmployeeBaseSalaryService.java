package com.jyd.bms.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeBaseSalary;
import com.jyd.bms.dao.EmployeeBaseSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("EmployeeBaseSalaryService")
public class EmployeeBaseSalaryService extends BaseService<EmployeeBaseSalary>{
	
	@Autowired
	private EmployeeBaseSalaryDAO employeeBaseSalaryDAO;
	
	
	/**
	 * 根据员工删除员工基本薪资
	 * @param employee
	 * @return
	 */
	public int deleteEmployeeBaseSalaryByEmployee(Employee employee) {
		return employeeBaseSalaryDAO.deleteEmployeeBaseSalaryByEmployee(employee);
		
	}
	
	/**
	 * 根据员工获取员工基本薪资
	 * @param employee
	 * @return
	 * @throws DAOException 
	 */
	public List<EmployeeBaseSalary> getEmployeeBaseSalaryByEmployee(Employee employee) throws DAOException {
		return employeeBaseSalaryDAO.getEmployeeBaseSalaryByEmployee(employee);
	}
	
	/**
	 * 根据薪资结构获取员工薪资
	 * @param salaryStructureId
	 * @return
	 * @throws DAOException
	 */
	public List<EmployeeBaseSalary> getSalaryByStructure(int salaryStructureId) throws DAOException {
		return employeeBaseSalaryDAO.getSalaryByStructure(salaryStructureId);
	}
	
	public List<EmployeeBaseSalary> getSalarysByEmployee(Employee employee) throws DAOException {
		return employeeBaseSalaryDAO.getSalarysByEmployee(employee);
	}
	
	@Override
	public void setDAO() {
		this.baseDAO = employeeBaseSalaryDAO;
	}

}
