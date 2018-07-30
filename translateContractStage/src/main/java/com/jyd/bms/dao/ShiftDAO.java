package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Shift;
import com.jyd.bms.tool.exception.DAOException;

public interface ShiftDAO extends HibernateBase<Shift>{

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getShiftCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Shift> getPagingShift(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有出差类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Shift> getAllShift() throws DAOException;
}
