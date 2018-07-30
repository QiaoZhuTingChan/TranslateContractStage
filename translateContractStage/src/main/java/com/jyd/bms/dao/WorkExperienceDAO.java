package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Staff;
import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.WorkExperience;
import com.jyd.bms.tool.exception.DAOException;

public interface WorkExperienceDAO extends HibernateBase<WorkExperience>{

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getWorkExperienceCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<WorkExperience> getPagingWorkExperience(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 获取所有员工经历
	 * @return
	 * @throws DAOException
	 */
	public List<WorkExperience> getAllWorkExperience() throws DAOException;
	
	/**
	 * 根据员工获取工作经历
	 * @param employee
	 * @return
	 * @throws DAOException
	 */
	public List<WorkExperience> getWorkExperiencesByEmp(Employee employee) throws DAOException;
}
