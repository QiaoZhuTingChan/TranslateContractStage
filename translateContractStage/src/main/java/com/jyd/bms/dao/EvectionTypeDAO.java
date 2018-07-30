package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.EducationType;
import com.jyd.bms.bean.EvectionType;
import com.jyd.bms.tool.exception.DAOException;

public interface EvectionTypeDAO extends HibernateBase<EvectionType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getEvectionTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<EvectionType> getPagingEvectionType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有出差类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<EvectionType> getAllEvectionType() throws DAOException;

}
