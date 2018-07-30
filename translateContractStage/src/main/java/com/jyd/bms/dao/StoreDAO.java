package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface StoreDAO extends HibernateBase<Store> {
	public Store getStoreByName(String condition) throws DAOException;
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getStoreCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Store> getPagingStore(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有门店
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Store> getAllStore() throws DAOException;
	
	/**
	 * 根据身份证号获取门店信息
	 * @param idNos
	 * @return
	 * @throws DAOException
	 */
	public List<Store> getStoresByIdNOs(String idNos) throws DAOException;
}