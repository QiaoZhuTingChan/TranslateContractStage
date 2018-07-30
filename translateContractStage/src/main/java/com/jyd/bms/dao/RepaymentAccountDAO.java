package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.RepaymentAccount;
import com.jyd.bms.tool.exception.DAOException;

public interface RepaymentAccountDAO extends HibernateBase<RepaymentAccount> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getRepaymentAccountCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<RepaymentAccount> getPagingRepaymentAccount(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有还款账号
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<RepaymentAccount> getAllRepaymentAccount() throws DAOException;

}
