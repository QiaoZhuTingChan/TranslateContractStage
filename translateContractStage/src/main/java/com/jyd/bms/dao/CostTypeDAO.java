package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.CostType;
import com.jyd.bms.tool.exception.DAOException;

public interface CostTypeDAO extends HibernateBase<CostType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getCostTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<CostType> getPagingCostType(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有费用类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<CostType> getAllCostType() throws DAOException;

}
