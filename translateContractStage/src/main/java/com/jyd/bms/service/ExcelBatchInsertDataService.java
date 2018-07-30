package com.jyd.bms.service;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.ContractLender;
import com.jyd.bms.bean.ContractPara;
import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.ContractStageFee;
import com.jyd.bms.bean.CusContractCost;
import com.jyd.bms.bean.CusContractRepaymentOtherFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractGpsLateFeeDAO;
import com.jyd.bms.dao.ContractLenderDAO;
import com.jyd.bms.dao.ContractParaDAO;
import com.jyd.bms.dao.ContractRepaymentDAO;
import com.jyd.bms.dao.ContractStageDAO;
import com.jyd.bms.dao.ContractStageFeeDAO;
import com.jyd.bms.dao.CusContractCostDAO;
import com.jyd.bms.dao.CusContractRepaymentOtherFeeDAO;
import com.jyd.bms.dao.CustomerContractDAO;
import com.jyd.bms.dao.ExcelBatchInsertDataDAO;

@Service("ExcelBatchInsertDataService")
public class ExcelBatchInsertDataService {
	@Autowired
	private CustomerContractDAO customerContractDAO;
	@Autowired
	private ContractLenderDAO contractLenderDAO;
	@Autowired
	private ContractParaDAO contractParaDAO;
	@Autowired
	private CusContractCostDAO contractCostDAO;
	@Autowired
	private ContractStageDAO contractStageDAO;
	@Autowired
	private ContractRepaymentDAO contractRepaymentDAO;
	@Autowired
	private CusContractRepaymentOtherFeeDAO contractRepaymentOtherFeeDAO;
	@Autowired
	private ContractGpsLateFeeDAO contractGpsLateFeeDAO;
	@Autowired
	private ContractStageFeeDAO contractStageFeeDAO;
	
	
	@Autowired
	private ExcelBatchInsertDataDAO excelBatchInsertDataDAO;
	
	
	
	public int excuteBatchInsertCustomerContract(Set<CustomerContract> customerContractList) {
		
		return customerContractDAO.excuteBatchInsertCustomerContract(customerContractList);
		
	}
	public int excuteBatchInsertContractLender(Set<ContractLender> contractLenderList) {
		
		return contractLenderDAO.excuteBatchInsertContractLender(contractLenderList);
		
	}
	public int excuteBatchInsertContractPara(Set<ContractPara> contractParaList) {
		
		return contractParaDAO.excuteBatchInsertContractPara(contractParaList);
		
	}
	public int excuteBatchInsertCusContractCost(Set<CusContractCost> cusContractCostList) {
		
		return contractCostDAO.excuteBatchInsertCusContractCost(cusContractCostList);
		
	}
	public int excuteBatchInsertContractStage(Set<ContractStage> contractStageList) {
		
		return contractStageDAO.excuteBatchInsertContractStage(contractStageList);
		
	}
	public int excuteBatchInsertContractRepayment(Set<ContractRepayment> contractRepaymentList) {
		
		return contractRepaymentDAO.excuteBatchInsertContractRepayment(contractRepaymentList);
		
	}
	public int excuteBatchInsertCusContractRepaymentOtherFee(Set<CusContractRepaymentOtherFee> cusContractRepaymentOtherFeeList) {
		
		return contractRepaymentOtherFeeDAO.excuteBatchInsertCusContractRepaymentOtherFee(cusContractRepaymentOtherFeeList);
		
	}
	public int excuteBatchInsertContractGpsLateFee(Set<ContractGpsLateFee> contractGpsLateFeeList) {
		
		return contractGpsLateFeeDAO.excuteBatchInsertContractGpsLateFee(contractGpsLateFeeList);
		
	}
	public int excuteBatchInsertContractStageFee(Set<ContractStageFee> contractStageFeeList) {
		
		return contractStageFeeDAO.excuteBatchInsertContractStageFee(contractStageFeeList);
		
	}
	
	
	
	public int excuteBatchInsertAll(Map<String, Object> map) {
		return excelBatchInsertDataDAO.excuteBatchInsertAll(map);
	}
	
	
	

}
