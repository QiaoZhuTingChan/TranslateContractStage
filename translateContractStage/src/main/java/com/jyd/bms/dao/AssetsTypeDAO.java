package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.AssetsType;
import com.jyd.bms.tool.exception.DAOException;

public interface AssetsTypeDAO extends HibernateBase<AssetsType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getAssetsTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<AssetsType> getPagingAssetsType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有资产类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<AssetsType> getAllAssetsType() throws DAOException;

}
