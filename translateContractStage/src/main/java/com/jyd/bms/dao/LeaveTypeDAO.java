package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.LeaveType;
import com.jyd.bms.tool.exception.DAOException;

public interface LeaveTypeDAO extends HibernateBase<LeaveType>{

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getLeaveTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<LeaveType> getPagingLeaveType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有请假类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<LeaveType> getAllLeaveType() throws DAOException;

}
