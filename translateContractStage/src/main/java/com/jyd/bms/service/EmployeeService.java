package com.jyd.bms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeSalary;
import com.jyd.bms.bean.ParentDepartment;
import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.User;
import com.jyd.bms.dao.DepartmentDAO;
import com.jyd.bms.dao.EmployeeDAO;
import com.jyd.bms.dao.EmployeeSalaryDAO;
import com.jyd.bms.dao.ParentDepartmentDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("EmployeeService")
public class EmployeeService extends BaseService<Employee> {
	@Autowired(required = true)
	private EmployeeDAO employeeDAO;
	@Autowired(required = true)
	private DepartmentDAO departmentDAO;
	@Autowired
	private EmployeeSalaryDAO employeeSalaryDAO;
	@Autowired
	private ParentDepartmentDAO parentDepartmentDAO;

	public int getEmployeeCount(String condition) throws DAOException {
		return employeeDAO.getEmployeeCount(condition);
	}

	public List<Employee> getPagingEmployee(int firstResult, int maxResults, String condition) throws DAOException {
		return employeeDAO.getPagingEmployee(firstResult, maxResults, condition);
	}

	public int getStoreEmployeeCount(String condition, Store store) throws DAOException {
		return employeeDAO.getStoreEmployeeCount(condition, store);
	}

	public List<Employee> getPagingStoreEmployee(int firstResult, int maxResults, String condition, Store store)
			throws DAOException {
		return employeeDAO.getPagingStoreEmployee(firstResult, maxResults, condition, store);
	}

	public List<Employee> getAllEmployee() throws DAOException {
		return employeeDAO.getAllEmployee();
	}

	/**
	 * 身份证查询
	 * 
	 * @param idcar
	 * @return
	 * @throws DAOException
	 */
	public int getEmployeeByIdCard(String idCard) throws DAOException {
		return employeeDAO.getEmployeeByIdCard(idCard);
	}

	@Override
	public void setDAO() {
		this.baseDAO = employeeDAO;
	}

	public List<Employee> getPagingEmployeeWhoNoSelectedSalaryStructure(int firstResult, int maxResults,
			String condition) throws DAOException {
		List<Employee> employeelist = employeeSalaryDAO.getEmployeeWhoHasSalaryStracture();
		List<Integer> employeeIds = new ArrayList<>();
		for (Employee employee : employeelist) {
			employeeIds.add(employee.getId());
		}
		return employeeDAO.getPagingEmployeeWhoNoSelectedSalaryStructure(firstResult, maxResults, condition,
				employeeIds);
	}

	public int getEmployeeCountWhoNoSelectedSalaryStructure(String condition) throws DAOException {
		List<Employee> employeelist = employeeSalaryDAO.getEmployeeWhoHasSalaryStracture();
		List<Integer> employeeIds = new ArrayList<>();
		for (Employee employee : employeelist) {
			employeeIds.add(employee.getId());
		}
		return employeeDAO.getPagingEmployeeWhoNoSelectedSalaryStructure(condition, employeeIds);
	}

	/**
	 * 根据身份证号获取员工信息
	 * 
	 * @param idNo
	 * @return
	 * @throws DAOException
	 */
	public Employee getEmployeeByIdNo(String idNo) throws Exception {
		return employeeDAO.getEmployeeByIdNo(idNo);
	}

	public List<Employee> getSuperiorSeeAllSubordinates(User user) throws Exception {
		/*
		 * //找出是上级管理员的所有员工 List<Employee> supervisorList =
		 * employeeDAO.getallDepartmentSupervisor(); List<Integer> ids = new
		 * ArrayList<>(); for (int i = 0; i < supervisorList.size(); i++) {
		 * ids.add(supervisorList.get(i).getId()); }
		 * 
		 * 
		 * Map<Integer, Employee> map = new HashMap<>(); Employee employee =
		 * user.getEmployee(); if(employee != null) { employee =
		 * employeeDAO.getById(employee.getId()); }
		 * 
		 * findSubordinates(map, employee, ids);
		 * 
		 * 
		 * List<Employee> empList = new ArrayList<>(); if(!map.isEmpty()) { for (Integer
		 * id : map.keySet()) { empList.add(map.get(id)); } }
		 * 
		 * return empList.isEmpty() ? null : empList;
		 */

		Employee employee = user.getEmployee();
		if (employee != null) {
			employee = employeeDAO.getById(employee.getId());
		}
		Department department = departmentDAO.getDepartmentByEmpId(employee.getId());

		List<Employee> employeeList = new ArrayList<>();
		Employee deparmentSupervisor = department.getDeparmentSupervisor();
		if (deparmentSupervisor != null) {// null 为门店负责人

			if (department.getDeparmentSupervisor().getId() == employee.getId()) {// 此登录员是管理者
				// 获取当前员工管理的部门
				List<Department> departmentList = departmentDAO.getSubDepartmentsByDeparmentSupervisor(employee);

				// 获取所有子部门
				List<ParentDepartment> parentDepartmentList = parentDepartmentDAO.getAllSubDepartment(departmentList);
				if (parentDepartmentList != null) {
					for (ParentDepartment parentDepartment : parentDepartmentList) {
						departmentList.add(parentDepartment.getDepartment());
					}
				}

				employeeList = employeeDAO.getEmployeeByDepartment(departmentList);
			} else {// 此登录员不是是管理者
				employeeList.add(employee);
			}
		}else {
			employeeList.add(employee);
		}

		return employeeList;

	}

	/**
	 * 找出所有下属
	 * 
	 * @param map
	 * @param employee
	 * @param supervisorList
	 * @throws Exception
	 */
	private void findSubordinates(Map<Integer, Employee> map, Employee employee, List<Integer> ids) throws Exception {
		map.put(employee.getId(), employee);

		if (ids.contains(employee.getId())) {
			// 找所有下属
			List<Employee> subordinates = employeeDAO.findSubordinates(employee);
			if (subordinates != null) {

				// for (Employee subordinate : subordinates) {
				// map.put(subordinate.getId(), subordinate);
				// }
				for (Employee subordinate : subordinates) {
					findSubordinates(map, subordinate, ids);
				}

			}
		}

	}

}
