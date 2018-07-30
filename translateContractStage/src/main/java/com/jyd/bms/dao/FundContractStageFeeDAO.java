package com.jyd.bms.dao;
import java.util.List;

import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundContractStageFee;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-25 14:10:14 by GeneratedTool
 * @author mjy
 */
public interface FundContractStageFeeDAO extends HibernateBase<FundContractStageFee> {
	public int getFundContractStageFeeCount(String condition) throws DAOException;
	public List<FundContractStageFee> getPagingFundContractStageFee(int firstResult, int maxResults, String condition)throws DAOException;
	public List<FundContractStageFee> getAllFundContractStageFee() throws DAOException;
	public double getExtraCharges(FundContractStage fundContractStage) throws DAOException;
}