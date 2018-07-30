package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.CustomerInfo;
import com.jyd.bms.tool.exception.DAOException;

public interface CustomerInfoDAO extends HibernateBase<CustomerInfo> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getCustomerInfoCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<CustomerInfo> getPagingCustomerInfo(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有客户
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<CustomerInfo> getAllCustomerInfo() throws DAOException;

	
	/**
	 * @category 查客户根据身份证号码
	 * @return
	 * @throws DAOException
	 */
	public CustomerInfo getCustomerInfoByidCard(String idCard) throws DAOException;
}
