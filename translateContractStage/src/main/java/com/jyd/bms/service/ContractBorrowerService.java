package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractBorrower;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractBorrowerDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractBorrowerService")
public class ContractBorrowerService extends BaseService<ContractBorrower> {
	@Autowired(required = true)
	private ContractBorrowerDAO borrowerDAO;

	public int getBorrowerCount(String condition) throws DAOException {
		return borrowerDAO.getBorrowerCount(condition);
	}

	public List<ContractBorrower> getPagingBorrower(int firstResult, int maxResults, String condition)
			throws DAOException {
		return borrowerDAO.getPagingBorrower(firstResult, maxResults, condition);
	}

	public List<ContractBorrower> getAllBorrower() throws DAOException {
		return borrowerDAO.getAllBorrower();
	}

	public List<ContractBorrower> getContractBorrowerByContract(CustomerContract contract) throws DAOException {
		return borrowerDAO.getContractBorrowerByContract(contract);
	}

	public void deleteAll(CustomerContract contract) throws DAOException {
		borrowerDAO.deleteAll(contract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = borrowerDAO;
	}

}
