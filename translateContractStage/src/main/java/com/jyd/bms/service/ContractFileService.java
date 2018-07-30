package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractFile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractFileDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category 归档文件service
 * @author mjy
 *
 */
@Service("ContractFileService")
public class ContractFileService extends BaseService<ContractFile> {
	@Autowired(required = true)
	private ContractFileDAO contractFileDAO;

	public List<ContractFile> getContractFileByContract(int firstResult, int maxResults, int contractId, String name)
			throws DAOException {
		return contractFileDAO.getContractFileByContract(firstResult, maxResults, contractId, name);
	}

	public int getContractFileCount(int contractId, String name) throws DAOException {
		return contractFileDAO.getContractFileCount(contractId, name);
	}

	/**
	 * 根据合同编号查询归档合同图片
	 * @param customerContract
	 * @return
	 * @throws DAOException
	 */
	public List<ContractFile> getContractFilesByContractNo(CustomerContract customerContract) throws DAOException{
		return contractFileDAO.getContractFilesByContractNo(customerContract);
	}
	
	@Override
	public void setDAO() {
		this.baseDAO = contractFileDAO;
	}

}
