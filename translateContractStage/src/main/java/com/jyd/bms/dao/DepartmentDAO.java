package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dto.DepartmentDTO;
import com.jyd.bms.tool.exception.DAOException;

public interface DepartmentDAO extends HibernateBase<Department> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getDepartmentCount(String condition) throws DAOException;

	/**
	 * 部门分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Department> getPagingDepartment(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有部门
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Department> getAllDepartment() throws DAOException;

	/**
	 * 查询父部门
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Department> getDepartmentByParentDept(Department condition) throws DAOException;

	/**
	 * 通过部门名字查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public Department getDepartmentByName(String condition) throws DAOException;

	/**
	 * 通过部门Id查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public Department getDepartmentById(int condition) throws DAOException;

	/**
	 * 通过员工Id查询所在的部门
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public Department getDepartmentByEmpId(int condition) throws DAOException;

	public List<Department> getDepartmentByStore(Store store) throws DAOException;

	public List<DepartmentDTO> getDepartmentDTOAll() throws DAOException;

	public List<DepartmentDTO> getDepartmentDTOByStore(Store store) throws DAOException;

	public List<DepartmentDTO> getNubmerOfDepartments() throws DAOException;

	/**
	 * 获取当前员工所管理的所有部门
	 * @param employee
	 * @return
	 */
	public List<Department> getSubDepartmentsByDeparmentSupervisor(Employee employee) throws DAOException;
}
