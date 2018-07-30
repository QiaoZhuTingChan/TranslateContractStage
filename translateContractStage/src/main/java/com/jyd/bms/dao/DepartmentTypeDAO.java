package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.DepartmentType;

import com.jyd.bms.tool.exception.DAOException;

public interface DepartmentTypeDAO extends HibernateBase<DepartmentType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getDepartmentTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<DepartmentType> getPagingDepartmentType(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有职责类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<DepartmentType> getAllDepartmentType() throws DAOException;

}
