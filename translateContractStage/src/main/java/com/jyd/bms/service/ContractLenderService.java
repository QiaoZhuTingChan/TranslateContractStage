package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractLender;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractLenderDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractLenderService")
public class ContractLenderService extends BaseService<ContractLender> {
	@Autowired(required = true)
	private ContractLenderDAO contractLenderDAO;

	public int getContractLenderCount(String condition) throws DAOException {
		return contractLenderDAO.getContractLenderCount(condition);
	}

	public List<ContractLender> getPagingContractLender(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractLenderDAO.getPagingContractLender(firstResult, maxResults, condition);
	}

	public List<ContractLender> getAllContractLender() throws DAOException {
		return contractLenderDAO.getAllContractLender();
	}

	public List<ContractLender> getContractLenderByContract(CustomerContract contract) throws DAOException {
		return contractLenderDAO.getContractLenderByContract(contract);
	}

	public void deleteAll(CustomerContract contract) throws DAOException {
		contractLenderDAO.deleteAll(contract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractLenderDAO;
	}
}
