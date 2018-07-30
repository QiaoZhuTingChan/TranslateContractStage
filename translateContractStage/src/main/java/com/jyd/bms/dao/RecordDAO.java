package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Record;
import com.jyd.bms.tool.exception.DAOException;

public interface RecordDAO extends HibernateBase<Record> {
	/**
	 * 查询所有记录
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Record> getAllRecord() throws DAOException;

	/**
	 * 根据条件查询记录总数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getRecordCount(String condition) throws DAOException;

	/**
	 * 根据条件分页查询记录
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Record> getPagingRecords(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * @category 员工参与的合同
	 * @param emp
	 * @return
	 * @throws DAOException
	 */
	public List<Record> getRecordByEmployee(int firstResult, int maxResults, String condition,Employee emp) throws DAOException;

}
