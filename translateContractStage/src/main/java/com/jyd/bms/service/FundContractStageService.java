package com.jyd.bms.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.FundContract;
import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundContractStageRepayment;
import com.jyd.bms.dao.FundContractStageDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-25 14:09:02 by GeneratedTool
 * @author mjy
 */
@Service("FundContractStageService")
public class FundContractStageService extends BaseService<FundContractStage> {
	@Autowired(required = true)
	private FundContractStageDAO fundContractStageDAO;

	public int getFundContractStageCount(String condition) throws DAOException {
		return fundContractStageDAO.getFundContractStageCount(condition);
	}

	public List<FundContractStage> getPagingFundContractStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		return fundContractStageDAO.getPagingFundContractStage(firstResult, maxResults, condition);
	}

	public List<FundContractStage> getAllFundContractStage() throws DAOException {
		return fundContractStageDAO.getAllFundContractStage();
	}

	// 通过合同查期数
	public List<FundContractStage> getAllFundContractStageByfundContract(FundContract fundContract)
			throws DAOException {
		return fundContractStageDAO.getAllFundContractStageByfundContract(fundContract);
	}

	// 通过合同分期查还款
	public List<FundContractStageRepayment> findContractRepaymentByStage(FundContractStage fundContractStage)
			throws DAOException {
		return fundContractStageDAO.findContractRepaymentByStage(fundContractStage);

	}

	// 查产品分期期数
	// public List<FundContractStage> getAllFundContractStage(FundContractStage
	// fundContractStage) throws DAOException {
	// return fundContractStageDAO.getAllFundContractStage(fundContractStage);
	//
	// }
	
	public int getFundContractStageCount(Integer para, String customer, Date startDate, Date endDate) throws DAOException{
		return fundContractStageDAO.getFundContractStageCount(para, customer, startDate, endDate);
	}
	
	public List<FundContractStage> getFundContractStageByPara(int firstResult, int maxResults, Integer para, String customer,
			String startDate, String endDate) throws DAOException, ParseException{
		return fundContractStageDAO.getFundContractStageByPara(firstResult, maxResults, para, customer, startDate, endDate);
		}
	@Override
	public void setDAO() {
		this.baseDAO = fundContractStageDAO;
	}
	/*public List<ContractStage> getPagingContractStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		return fundContractStageDAO.getPagingContractStage(firstResult, maxResults, condition);
	}*/
}
