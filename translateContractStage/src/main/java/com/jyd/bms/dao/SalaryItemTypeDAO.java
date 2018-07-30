package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.SalaryItemType;
import com.jyd.bms.tool.exception.DAOException;

public interface SalaryItemTypeDAO extends HibernateBase<SalaryItemType>{

	/**
	 * 查询记录数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getSalaryItemTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryItemType> getPagingSalaryItemType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有出差类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryItemType> getAllSalaryItemType() throws DAOException;
	
}
