package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.dao.DepartmentSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("DepartmentSalaryService")
public class DepartmentSalaryService extends BaseService<Department> {

	@Autowired(required = true)
	private DepartmentSalaryDAO departmentSalaryDAO;

	/**
	 * 获取当前部门下的所有员工
	 */
	public List<Employee> getEmployeeByDepartmentAndYearmonth(Department department, String yearMonth)
			throws DAOException {
		return departmentSalaryDAO.getEmployeeByDepartmentAndYearmonth(department, yearMonth);
	}

	@Override
	public void setDAO() {
		this.baseDAO = departmentSalaryDAO;
	}

}