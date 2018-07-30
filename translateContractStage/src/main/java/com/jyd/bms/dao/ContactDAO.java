package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Contact;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.tool.exception.DAOException;

public interface ContactDAO extends HibernateBase<Contact> {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */

	public int getContactCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Contact> getPagingContact(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有联系方式
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Contact> getAllContact() throws DAOException;
	
	public List<Contact> findContactByEmp(Employee emp) throws DAOException;

}
