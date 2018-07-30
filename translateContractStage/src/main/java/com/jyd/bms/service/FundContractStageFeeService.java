package com.jyd.bms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundContractStageFee;
import com.jyd.bms.dao.FundContractStageFeeDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-25 14:10:14 by GeneratedTool
 * @author mjy
 */
@Service("FundContractStageFeeService")
public class FundContractStageFeeService extends BaseService<FundContractStageFee> {
@Autowired(required = true)
private FundContractStageFeeDAO fundContractStageFeeDAO;

 public int getFundContractStageFeeCount(String condition) throws DAOException {
	return fundContractStageFeeDAO.getFundContractStageFeeCount(condition);
 }

 public List<FundContractStageFee> getPagingFundContractStageFee(int firstResult, int maxResults, String condition) throws DAOException {
	return fundContractStageFeeDAO.getPagingFundContractStageFee(firstResult, maxResults, condition);
 }

 public List<FundContractStageFee> getAllFundContractStageFee() throws DAOException {
	return fundContractStageFeeDAO.getAllFundContractStageFee();
 }
 @Override

 public void setDAO() {
	this.baseDAO = fundContractStageFeeDAO;
 }

public Double getExtraCharges(FundContractStage fundContractStage) throws DAOException {
	// TODO Auto-generated method stub
	return fundContractStageFeeDAO.getExtraCharges(fundContractStage);
}
}
