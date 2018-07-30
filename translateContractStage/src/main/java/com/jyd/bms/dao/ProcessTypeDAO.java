package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ProcessType;
import com.jyd.bms.tool.exception.DAOException;

public interface ProcessTypeDAO extends HibernateBase<ProcessType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getProcessTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ProcessType> getPagingProcessType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有资产类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProcessType> getAllProcessType() throws DAOException;

}
