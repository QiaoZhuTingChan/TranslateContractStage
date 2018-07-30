package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.DutyType;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.PositionType;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface EmployeeDAO extends HibernateBase<Employee> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getEmployeeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Employee> getPagingEmployee(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Employee> getAllEmployee() throws DAOException;

	/**
	 * 查询身份证员工是否存在
	 * 
	 * @return
	 * @throws DAOExceptiongetEmployeeByIdNo
	 */
	public int getEmployeeByIdCard(String idCard) throws DAOException;

	/**
	 * 查询员工部门
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Employee> getEmpByDept(Department condition) throws DAOException;

	/**
	 * 查询员工在部门的职位
	 * 
	 * @param dept
	 * @param position
	 * @return
	 * @throws DAOException
	 */
	public List<Employee> getEmpByDeptAndPosition(Department dept, PositionType position) throws DAOException;

	/**
	 * 查询员工在部门的职责
	 * 
	 * @param dept
	 * @param duty
	 * @return
	 * @throws DAOException
	 */
	public List<Employee> getEmpByDeptAndDuty(Department dept, DutyType duty) throws DAOException;

	/**
	 * 查询员工的父部门
	 * 
	 * @param dept
	 * @return
	 * @throws DAOException
	 */
	public Employee getHeadByDept(Department dept) throws DAOException;

	public List<Employee> getEmpByDeptAndState(Department dept, int state) throws DAOException;

	/**
	 * 获取门店员工记录数
	 * 
	 * @param condition
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public int getStoreEmployeeCount(String condition, Store store) throws DAOException;

	/**
	 * 获取门店员工分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<Employee> getPagingStoreEmployee(int firstResult, int maxResults, String condition, Store store)
			throws DAOException;

	public List<Employee> findEmpByStoreAndDuty(Store store, DutyType duty) throws DAOException;

	public List<Employee> findEmpByDept(Department dept) throws DAOException;

	public Employee findEmpById(int id) throws DAOException;

	public List<Employee> findEmpByStateAndShiftStateAndDept(Department dept) throws DAOException;

	public List<Employee> findEmpByStateAndShiftStateAndStore(Store store) throws DAOException;

	/**
	 * @category 统计部门人数
	 * @param dept
	 * @return
	 * @throws DAOException
	 */
	public int getEmpCountByDept(Department dept) throws DAOException;

	public List<Employee> getPagingEmployeeWhoNoSelectedSalaryStructure(int firstResult, int maxResults,
			String condition, List<Integer> employeeIds) throws DAOException;

	public int getPagingEmployeeWhoNoSelectedSalaryStructure(String condition, List<Integer> employeeIds) throws DAOException;
	
	/**
	 * 根据身份证号获取员工信息
	 * @param idNo
	 * @return
	 * @throws DAOException
	 */
	public Employee getEmployeeByIdNo (String idNo) throws Exception;

	/**
	 * 查找是上级管理员的所有员工
	 * @return
	 * @throws Exception
	 */
	public List<Employee> getallDepartmentSupervisor()throws Exception;

	/**
	 * 查找此员工的所有下属
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	public List<Employee> findSubordinates(Employee employee)throws Exception;

	public List<Employee> getEmployeeByDepartment(List<Department> departmentList)throws Exception;
	
	
	
	
	
}					
