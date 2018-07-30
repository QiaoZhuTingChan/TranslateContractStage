package com.jyd.bms.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.FundContract;
import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundContractStageRepayment;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-25 14:09:02 by GeneratedTool
 * @author mjy
 */
public interface FundContractStageDAO extends HibernateBase<FundContractStage> {
	public int getFundContractStageCount(String condition) throws DAOException;

	public List<FundContractStage> getPagingFundContractStage(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<FundContractStage> getAllFundContractStage() throws DAOException;

	// 通过合同查期数
	public List<FundContractStage> getAllFundContractStageByfundContract(FundContract fundContract) throws DAOException;

	//通过合同分期查还款
	public List<FundContractStageRepayment> findContractRepaymentByStage(FundContractStage fundContractStage)
			throws DAOException;
	
	public int getFundContractStageCount(Integer para, String customer, Date startDate, Date endDate) throws DAOException;
	
	
	public List<FundContractStage> getFundContractStageByPara(int firstResult, int maxResults, Integer para, String customer,
			String startDate, String endDate) throws DAOException, ParseException;
	// 查产品分期期数
	// public List<FundContractStage> getAllFundContractStage(FundContractStage
	// fundContractStage)
	// throws DAOException;
	/*public List<ContractStage> getPagingFundContractStage(int firstResult, int maxResults, String condition)
			throws DAOException;*/
}