package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractFaceTrial;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractFaceTrialDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContactFaceTrialService")
public class ContactFaceTrialService extends BaseService<ContractFaceTrial> {
	@Autowired(required = true)
	private ContractFaceTrialDAO contractFaceTrialDAO;

	public int getContractFaceTrialCount(String condition) throws DAOException {
		return contractFaceTrialDAO.getContractFaceTrialCount(condition);
	}

	public List<ContractFaceTrial> getPagingContractFaceTrial(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractFaceTrialDAO.getPagingContractFaceTrial(firstResult, maxResults, condition);
	}

	public List<ContractFaceTrial> getAllContractFaceTrial() throws DAOException {
		return contractFaceTrialDAO.getAllContractFaceTrial();
	}

	public ContractFaceTrial getContractFaceTrialByContract(CustomerContract contract)throws DAOException{
		return contractFaceTrialDAO.getContractFaceTrialByContract(contract);
	}
	@Override
	public void setDAO() {
		this.baseDAO = contractFaceTrialDAO;
	}

}
