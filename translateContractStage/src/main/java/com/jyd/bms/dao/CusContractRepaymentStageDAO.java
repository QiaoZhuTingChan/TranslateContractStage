package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.CusContractRepaymentStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-07-03 10:33:55 by GeneratedTool
 * @author mjy
 */
public interface CusContractRepaymentStageDAO extends HibernateBase<CusContractRepaymentStage> {
	public int getCusContractRepaymentStageCount(String condition) throws DAOException;

	public List<CusContractRepaymentStage> getPagingCusContractRepaymentStage(int firstResult, int maxResults,
			String condition) throws DAOException;

	public List<CusContractRepaymentStage> getAllCusContractRepaymentStage() throws DAOException;

	public CusContractRepaymentStage getCusContractRepaymentStage(CustomerContract contract) throws DAOException;

}