package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Staff;
import com.jyd.bms.tool.exception.DAOException;

public interface StaffDAO extends HibernateBase<Staff> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getStaffCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Staff> getPagingStaff(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有编制
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Staff> getAllStaff() throws DAOException;

	/**
	 * 通过部门查找编制
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Staff> getStaffByDept(Department condition) throws DAOException;

	/**
	 * 通过ID查找编制
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public Staff getStaffById(int condition) throws DAOException;

	/**
	 * @category 统计部门编制人数
	 * @param dept
	 * @return
	 * @throws DAOException
	 */
	public int getStaffSumByDept(Department dept) throws DAOException;
}
