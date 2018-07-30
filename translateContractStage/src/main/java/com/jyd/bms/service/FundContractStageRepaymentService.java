package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.FundContract;
import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundContractStageRepayment;
import com.jyd.bms.dao.FundContractStageRepaymentDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-25 14:10:49 by GeneratedTool
 * @author mjy
 */
@Service("FundContractStageRepaymentService")
public class FundContractStageRepaymentService extends BaseService<FundContractStageRepayment> {
@Autowired(required = true)
private FundContractStageRepaymentDAO fundContractStageRepaymentDAO;

 public int getFundContractStageRepaymentCount(String condition) throws DAOException {
	return fundContractStageRepaymentDAO.getFundContractStageRepaymentCount(condition);
 }

 public List<FundContractStageRepayment> getPagingFundContractStageRepayment(int firstResult, int maxResults, String condition) throws DAOException {
	return fundContractStageRepaymentDAO.getPagingFundContractStageRepayment(firstResult, maxResults, condition);
 }

 public List<FundContractStageRepayment> getAllFundContractStageRepayment() throws DAOException {
	return fundContractStageRepaymentDAO.getAllFundContractStageRepayment();
 }
 @Override

 public void setDAO() {
	this.baseDAO = fundContractStageRepaymentDAO;
 }

 public List<FundContractStageRepayment> findFundContractStageRepaymentByStageAll(FundContractStage stage) throws DAOException{
	 return fundContractStageRepaymentDAO.findFundContractStageRepaymentByStageAll(stage);
 }
}
