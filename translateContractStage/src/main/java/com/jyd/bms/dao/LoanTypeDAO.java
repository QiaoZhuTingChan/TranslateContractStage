package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.LoanType;
import com.jyd.bms.tool.exception.DAOException;

public interface LoanTypeDAO extends HibernateBase<LoanType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getLoanTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<LoanType> getPagingLoanType(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有借款类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<LoanType> getAllLoanType() throws DAOException;

}
