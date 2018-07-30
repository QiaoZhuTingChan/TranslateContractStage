package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Contract;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.dao.ContractDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractService")
public class ContractService extends BaseService<Contract> {
	@Autowired(required = true)
	private ContractDAO contractDAO;

	public int getContractCount(String condition) throws DAOException {
		return contractDAO.getContractCount(condition);
	}

	public List<Contract> getPagingContract(int firstResult, int maxResults, String condition) throws DAOException {
		return contractDAO.getPagingContract(firstResult, maxResults, condition);
	}

	public List<Contract> getAllContract() throws DAOException {
		return contractDAO.getAllContract();
	}
	
	public List<Contract> getContractByEmp(Employee emp) throws DAOException{
		return contractDAO.findContractByEmp(emp);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractDAO;
	}

}
