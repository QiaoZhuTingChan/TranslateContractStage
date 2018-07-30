package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Flow;
import com.jyd.bms.bean.Form;
import com.jyd.bms.tool.exception.DAOException;

public interface FlowDAO extends HibernateBase<Flow> {
	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public int getFlowCount(String condition) throws DAOException;

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
	public List<Flow> getPagingFlow(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 获取所有记录
	 * 
	 * @return 所有记录
	 * @throws DAOException
	 */
	public List<Flow> getAllFlow() throws DAOException;

	/**
	 * 按流程名称获取记录
	 * 
	 * @param name
	 *            流程名称
	 * @return 流程
	 * @throws DAOException
	 */
	public List<Flow> getFlowByName(String name) throws DAOException;
}
