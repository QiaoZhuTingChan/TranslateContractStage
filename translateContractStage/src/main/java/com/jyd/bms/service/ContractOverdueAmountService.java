package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractOverdueAmount;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractOverdueAmountDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractOverdueAmountService")
public class ContractOverdueAmountService extends BaseService<ContractOverdueAmount> {
	@Autowired(required = true)
	private ContractOverdueAmountDAO contractOverdueAmountDAO;

	public int getContractOverdueAmountCount(String condition) throws DAOException {
		return contractOverdueAmountDAO.getContractOverdueAmountCount(condition);
	}

	public List<ContractOverdueAmount> getPagingContractOverdueAmount(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractOverdueAmountDAO.getPagingContractOverdueAmount(firstResult, maxResults, condition);
	}

	public List<ContractOverdueAmount> getAllContractOverdueAmount() throws DAOException {
		return contractOverdueAmountDAO.getAllContractOverdueAmount();
	}
	
	public List<ContractOverdueAmount> getContractOverdueAmountByContract(CustomerContract contract)throws DAOException{
		return contractOverdueAmountDAO.getContractOverdueAmountByContract(contract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractOverdueAmountDAO;
	}

}
