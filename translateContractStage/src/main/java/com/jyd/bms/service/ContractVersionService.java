package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractVersion;
import com.jyd.bms.dao.ContractVersionDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractVersionService")
public class ContractVersionService extends BaseService<ContractVersion> {
	@Autowired(required = true)
	private ContractVersionDAO contractVersionDAO;

	public int getContractVersionCount(String condition) throws DAOException {
		return contractVersionDAO.getContractVersionCount(condition);
	}

	public List<ContractVersion> getPagingContractVersion(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractVersionDAO.getPagingContractVersion(firstResult, maxResults, condition);
	}

	public List<ContractVersion> getAllContractVersion() throws DAOException {
		return contractVersionDAO.getAllContractVersion();
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractVersionDAO;
	}

}
