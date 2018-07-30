package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.RepaymentType;
import com.jyd.bms.tool.exception.DAOException;

public interface RepaymentTypeDAO extends HibernateBase<RepaymentType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getRepaymentTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<RepaymentType> getPagingRepaymentType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有还款类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<RepaymentType> getAllRepaymentType() throws DAOException;

}
