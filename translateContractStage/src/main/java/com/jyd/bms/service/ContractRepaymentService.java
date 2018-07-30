package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.dao.ContractRepaymentDAO;
import com.jyd.bms.dao.CusContractRepaymentOtherFeeDAO;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DeleteException;

@Service("ContractRepaymentService")
public class ContractRepaymentService extends BaseService<ContractRepayment> {
	@Autowired(required = true)
	private ContractRepaymentDAO contractRepaymentDAO;
	@Autowired(required = true)
	private CusContractRepaymentOtherFeeDAO cusContractRepaymentOtherFeeDAO;

	public int getContractRepaymentCount(String condition) throws DAOException {
		return contractRepaymentDAO.getContractRepaymentCount(condition);
	}

	public List<ContractRepayment> getPagingContractRepayment(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractRepaymentDAO.getPagingContractRepayment(firstResult, maxResults, condition);
	}

	public List<ContractRepayment> getAllContractRepayment() throws DAOException {
		return contractRepaymentDAO.getAllContractRepayment();
	}

	public List<ContractRepayment> getContractRepaymentByContractStage(ContractStage contractStage)
			throws DAOException {
		return contractRepaymentDAO.findContractRepaymentByStage(contractStage);
	}

	public List<ContractRepayment> findContractRepaymentByStageAll(ContractStage stage) throws DAOException {
		return contractRepaymentDAO.findContractRepaymentByStageAll(stage);
	}

	public void deleteAll(ContractRepayment rep) throws DAOException, DeleteException {
		cusContractRepaymentOtherFeeDAO.delAll(rep);
		contractRepaymentDAO.delete(rep);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractRepaymentDAO;
	}

}
