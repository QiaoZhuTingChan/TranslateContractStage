package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContractFile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractFileDAO extends HibernateBase<ContractFile> {

	public int getContractFileCount(int contractId, String name) throws DAOException;

	public List<ContractFile> getContractFileByContract(int firstResult, int maxResults, int contractId, String name)
			throws DAOException;
	
	/**
	 * 根据合同编号查询归档合同图片
	 * @param customerContract
	 * @return
	 * @throws DAOException
	 */
	public List<ContractFile> getContractFilesByContractNo(CustomerContract customerContract) throws DAOException;
}
