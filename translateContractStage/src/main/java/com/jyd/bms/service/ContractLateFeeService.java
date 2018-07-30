package com.jyd.bms.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractLateFee;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ContractLateFeeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractLateFeeService")
public class ContractLateFeeService extends BaseService<ContractLateFee> {
	@Autowired(required = true)
	private ContractLateFeeDAO contractLateFeeDAO;

	public int getContractLateFeeCount(String condition) throws DAOException {
		return contractLateFeeDAO.getContractLateFeeCount(condition);
	}

	public int getContractLateFeeCountByStore(String condition, Store store) throws DAOException {
		return contractLateFeeDAO.getContractLateFeeCountByStore(condition, store);
	}

	public List<ContractLateFee> getPagingContractLateFee(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractLateFeeDAO.getPagingContractLateFee(firstResult, maxResults, condition);
	}

	public List<ContractLateFee> getPagingContractLateFeeByStore(int firstResult, int maxResults, String condition,
			Store store) throws DAOException {
		return contractLateFeeDAO.getPagingContractLateFeeByStore(firstResult, maxResults, condition, store);
	}

	public List<ContractLateFee> getAllContractLateFee() throws DAOException {
		return contractLateFeeDAO.getAllContractLateFee();
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractLateFeeDAO;
	}

	public List<ContractLateFee> getContractLateFeeByContract(CustomerContract contract) throws DAOException {
		return contractLateFeeDAO.getContractLateFeeByContract(contract);
	}

	/**
	 * @param stage
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLateFee> findContractLateFeeByContractStage(ContractStage stage) throws DAOException {
		return contractLateFeeDAO.findContractLateFeeByContractStage(stage);
	}

	/**
	 * 分页查询
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @param state
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws DAOException
	 */
	public List<ContractLateFee> getPagingContractLateFeeParam(int firstResult, int maxResults,
			Map<String, Object> mapPara) throws DAOException, ParseException {
		return contractLateFeeDAO.getPagingContractLateFeeParam(firstResult, maxResults, mapPara);
	}

	public int getContractLateFeeParamCount(Map<String, Object> mapPara) throws DAOException, ParseException {
		return contractLateFeeDAO.getContractLateFeeParamCount(mapPara);
	}

}
