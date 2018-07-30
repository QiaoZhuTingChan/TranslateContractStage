package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractPara;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.ProductParameter;
import com.jyd.bms.dao.ContractParaDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractParaService")
public class ContractParaService extends BaseService<ContractPara> {
	@Autowired(required = true)
	private ContractParaDAO contractParaDAO;

	public int getContractParaCount(String condition) throws DAOException {
		return contractParaDAO.getContractParaCount(condition);
	}

	public List<ContractPara> getPagingContractPara(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractParaDAO.getPagingContractPara(firstResult, maxResults, condition);
	}

	public List<ContractPara> getAllContractPara() throws DAOException {
		return contractParaDAO.getAllContractPara();
	}

	/**
	 * 通过合同的参数查询合同
	 * 
	 * @param contract
	 * @param para
	 * @return
	 * @throws DAOException
	 */
	public double findValueByContractAndPara(CustomerContract contract, ProductParameter para) throws DAOException {
		return contractParaDAO.findValueByContractAndPara(contract, para);
	}

	public List<ContractPara> getContractParaByContract(CustomerContract contract) throws DAOException {
		return contractParaDAO.getContractParaByContract(contract);
	}

	public void deleteAll(CustomerContract contract) throws DAOException {
		contractParaDAO.deleteAll(contract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractParaDAO;
	}

}
