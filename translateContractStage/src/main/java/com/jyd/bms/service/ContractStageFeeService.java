package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.ContractStageFee;
import com.jyd.bms.dao.ContractStageFeeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractStageFeeService")
public class ContractStageFeeService extends BaseService<ContractStageFee> {
	@Autowired(required = true)
	private ContractStageFeeDAO contractStageFeeDAO;

	public int getContractStageFeeCount(String condition) throws DAOException {
		return contractStageFeeDAO.getContractStageFeeCount(condition);
	}

	public List<ContractStageFee> getPagingContractStageFee(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractStageFeeDAO.getPagingContractStageFee(firstResult, maxResults, condition);
	}

	public List<ContractStageFee> getAllContractStageFee() throws DAOException {
		return contractStageFeeDAO.getAllContractStageFee();
	}

	public List<ContractStageFee> getContractStageFeeByContractStage(ContractStage contractStage) throws DAOException {
		return contractStageFeeDAO.findContractStageFeeByContractStage(contractStage);
	}


	/**
	 * @category 额外费用
	 * @param stage
	 * @return
	 * @throws DAOException
	 */
	public Double getExtraCharges(ContractStage stage) throws DAOException {
		return contractStageFeeDAO.getExtraCharges(stage);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractStageFeeDAO;
	}

}
