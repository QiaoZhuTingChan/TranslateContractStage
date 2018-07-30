package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.EducationType;
import com.jyd.bms.tool.exception.DAOException;

public interface EducationTypeDAO extends HibernateBase<EducationType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getEducationTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<EducationType> getPagingEducationType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有学历类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<EducationType> getAllEducationType() throws DAOException;

}
