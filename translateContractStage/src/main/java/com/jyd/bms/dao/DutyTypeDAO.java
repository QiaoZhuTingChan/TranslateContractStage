package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.DutyType;
import com.jyd.bms.tool.exception.DAOException;

public interface DutyTypeDAO extends HibernateBase<DutyType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getDutyTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<DutyType> getPagingDutyType(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有职责类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<DutyType> getAllDutyType() throws DAOException;

}
