package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.BaseSalaryItem;
import com.jyd.bms.tool.exception.DAOException;

public interface BaseSalaryItemDAO extends HibernateBase<BaseSalaryItem>{
	/**
	 * 查询记录数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getBaseSalaryItemCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<BaseSalaryItem> getPagingBaseSalaryItem(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有出差类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<BaseSalaryItem> getAllBaseSalaryItem() throws DAOException;


}

