package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.tool.exception.DAOException;

public interface RepaymentStageDAO extends HibernateBase<RepaymentStage> {
	public RepaymentStage getRepaymentStageById(int stage) throws DAOException;
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getRepaymentStageCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<RepaymentStage> getPagingRepaymentStage(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有还款分期
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<RepaymentStage> getAllRepaymentStage() throws DAOException;

	public RepaymentStage getRepaymentStageByRepaymentStage(int repaymentStage) throws DAOException;

}
