package com.jyd.bms.dao;

import java.util.List;
import java.util.Set;

import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.CusContractRepaymentOtherFee;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-06-27 10:54:48 by GeneratedTool
 * @author mjy
 */
public interface CusContractRepaymentOtherFeeDAO extends HibernateBase<CusContractRepaymentOtherFee> {
	public int getCusContractRepaymentOtherFeeCount(String condition) throws DAOException;

	public List<CusContractRepaymentOtherFee> getPagingCusContractRepaymentOtherFee(int firstResult, int maxResults,
			String condition) throws DAOException;

	public List<CusContractRepaymentOtherFee> getAllCusContractRepaymentOtherFee() throws DAOException;

	public List<CusContractRepaymentOtherFee> getOtherFeeByStage(ContractRepayment rep) throws DAOException;

	public void delAll(ContractRepayment rep) throws DAOException;

	public int excuteBatchInsertCusContractRepaymentOtherFee(
			Set<CusContractRepaymentOtherFee> cusContractRepaymentOtherFeeList);
}