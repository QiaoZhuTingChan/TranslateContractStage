package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.GpsCostType;
import com.jyd.bms.tool.exception.DAOException;

public interface GpsCostTypeDAO extends HibernateBase<GpsCostType> {
	/**
	 * 查询
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getGpsCostTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<GpsCostType> getPagingGpsCostType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有GPS费用类型
	 * @return
	 * @throws DAOException
	 */
	public List<GpsCostType> getAllGpsCostType() throws DAOException;

}
