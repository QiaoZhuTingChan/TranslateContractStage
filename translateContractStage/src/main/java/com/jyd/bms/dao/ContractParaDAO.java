package com.jyd.bms.dao;

import java.util.List;
import java.util.Set;

import com.jyd.bms.bean.ContractPara;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.ProductParameter;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractParaDAO extends HibernateBase<ContractPara> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractParaCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractPara> getPagingContractPara(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractPara> getAllContractPara() throws DAOException;

	/**
	 * 通过合同的参数查询合同
	 * 
	 * @param contract
	 * @param para
	 * @return
	 * @throws DAOException
	 */
	public double findValueByContractAndPara(CustomerContract contract, ProductParameter para) throws DAOException;

	public List<ContractPara> getContractParaByContract(CustomerContract contract) throws DAOException;

	public void deleteAll(CustomerContract contract) throws DAOException;

	public int excuteBatchInsertContractPara(Set<ContractPara> contractParaList);
}
