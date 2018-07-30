package com.jyd.bms.dao;
import java.util.List;


import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundContractStageRepayment;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-25 14:10:49 by GeneratedTool
 * @author mjy
 */
public interface FundContractStageRepaymentDAO extends HibernateBase<FundContractStageRepayment> {
	public int getFundContractStageRepaymentCount(String condition) throws DAOException;
	public List<FundContractStageRepayment> getPagingFundContractStageRepayment(int firstResult, int maxResults, String condition)throws DAOException;
	public List<FundContractStageRepayment> getAllFundContractStageRepayment() throws DAOException;
	public List<FundContractStageRepayment> findFundContractStageRepaymentByStageAll(FundContractStage stage) throws DAOException;
}