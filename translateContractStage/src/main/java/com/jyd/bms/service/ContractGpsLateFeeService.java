package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.ContractLateFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ContractGpsLateFeeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractGpsLateFeeService")
public class ContractGpsLateFeeService extends BaseService<ContractGpsLateFee> {
	@Autowired(required = true)
	private ContractGpsLateFeeDAO contractGpsLateFeeDAO;

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractGpsLateFeeCount(String condition) throws DAOException {
		return contractGpsLateFeeDAO.getContractGpsLateFeeCount(condition);
	}

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractGpsLateFee> getPagingContractGpsLateFee(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contractGpsLateFeeDAO.getPagingContractGpsLateFee(firstResult, maxResults, condition);
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractGpsLateFee> getAllContractGpsLateFee() throws DAOException {
		return contractGpsLateFeeDAO.getAllContractGpsLateFee();
	}

	/**
	 * 查找当天某门店的费用记录
	 * 
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<ContractGpsLateFee> findContractGpsLateFeeByStore(Store store) throws DAOException {
		return contractGpsLateFeeDAO.findContractGpsLateFeeByStore(store);
	}

	/**
	 * 获取同一天内相同的费用记录条数
	 * 
	 * @param contract
	 * @return
	 * @throws DAOException
	 */
	public int getSameContractGpsLateFeeCountByDay(CustomerContract contract) throws DAOException {
		return contractGpsLateFeeDAO.getSameContractGpsLateFeeCountByDay(contract);
	}

	/**
	 * 
	 */
	public int getCountByCustomerContract(CustomerContract contract) throws DAOException {
		return contractGpsLateFeeDAO.getCountByCustomerContract(contract);
	}

	public List<ContractGpsLateFee> findContractGpsLateFeeListByCustomerContract(CustomerContract contract)
			throws DAOException {
		return contractGpsLateFeeDAO.findContractGpsLateFeeListByCustomerContract(contract);
	}

	public ContractGpsLateFee getContractGpsLateFeeByCustomerContract(CustomerContract contract) throws DAOException {
		return contractGpsLateFeeDAO.findContractGpsLateFeeByCustomerContract(contract);
	}

	public void deleteAll(CustomerContract contract) throws DAOException {
		contractGpsLateFeeDAO.deleteAll(contract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractGpsLateFeeDAO;
	}
}
