package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContractFaceTrial;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;
public interface ContractFaceTrialDAO extends HibernateBase<ContractFaceTrial> {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */

	public int getContractFaceTrialCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractFaceTrial> getPagingContractFaceTrial(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有联系方式
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractFaceTrial> getAllContractFaceTrial() throws DAOException;

	
	public ContractFaceTrial getContractFaceTrialByContract(CustomerContract contract)throws DAOException;
}
