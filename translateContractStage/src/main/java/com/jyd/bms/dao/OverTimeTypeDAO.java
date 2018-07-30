package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.OverTimeType;
import com.jyd.bms.tool.exception.DAOException;

public interface OverTimeTypeDAO extends HibernateBase<OverTimeType>{

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getOverTimeTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<OverTimeType> getPagingOverTimeType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有加班类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<OverTimeType> getAllOverTimeType() throws DAOException;

}
