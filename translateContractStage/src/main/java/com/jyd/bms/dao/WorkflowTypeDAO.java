package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.WorkflowType;
import com.jyd.bms.tool.exception.DAOException;

public interface WorkflowTypeDAO extends HibernateBase <WorkflowType>{
	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public int getWorkflowTypeCount(String condition) throws DAOException;

	/**
	 * 按查询条件获取分页记录
	 * 
	 * @param firstResult
	 *            开始行
	 * @param maxResults
	 *            结束行
	 * @param condition
	 *            查询条件
	 * @return 分页数据
	 * @throws DAOException
	 */
	public List<WorkflowType> getPagingWorkflowType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public List<WorkflowType> getAllWorkflowType() throws DAOException;
}
