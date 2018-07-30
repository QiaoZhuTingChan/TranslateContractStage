package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Mortgager;
import com.jyd.bms.tool.exception.DAOException;

public interface MortgagerDAO extends HibernateBase<Mortgager> {
	public Mortgager getMortgagerByName(String name) throws DAOException;
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getMortgagerCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Mortgager> getPagingMortgager(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有抵押人
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Mortgager> getAllMortgager() throws DAOException;

}
