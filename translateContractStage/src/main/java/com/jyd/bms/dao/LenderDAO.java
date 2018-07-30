package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Lender;
import com.jyd.bms.tool.exception.DAOException;

public interface LenderDAO extends HibernateBase<Lender> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getLenderCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Lender> getPagingLender(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有出借人
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Lender> getAllLender() throws DAOException;

}
