package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContactInfo;
import com.jyd.bms.bean.CustomerInfo;
import com.jyd.bms.bean.VehicleInfo;
import com.jyd.bms.tool.exception.DAOException;

public interface ContactInfoDAO extends HibernateBase<ContactInfo> {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContactInfoCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContactInfo> getPagingContactInfo(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有联系方式
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContactInfo> getAllContactInfo() throws DAOException;
	public List<ContactInfo> getContactInfoByCustomerInfo(CustomerInfo customer) throws DAOException;
	
}
