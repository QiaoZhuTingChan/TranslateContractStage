package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractUploadfile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Form;
import com.jyd.bms.dao.ContractUploadfileDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractUploadfileService")
public class ContractUploadfileService extends BaseService<ContractUploadfile> {
	@Autowired(required = true)
	private ContractUploadfileDAO contractUploadfileDAO;

	public int getContractUploadfileCount(String condition) throws DAOException {
		return contractUploadfileDAO.getContractUploadfileCount(condition);
	}

	public List<ContractUploadfile> getAllContractUploadfile(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractUploadfileDAO.getPagingContractUploadfile(firstResult, maxResults, condition);
	}

	public List<ContractUploadfile> getAllContractUploadfile() throws DAOException {
		return contractUploadfileDAO.getAllContractUploadfile();
	}

	public List<ContractUploadfile> getContractUploadFileByContract(CustomerContract contract) throws DAOException {
		return contractUploadfileDAO.getContractUploadFileByContract(contract);
	}

	public void deleteAll(CustomerContract contract,Form form) throws DAOException {
		contractUploadfileDAO.deleteAll(contract,form);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractUploadfileDAO;
	}

}
