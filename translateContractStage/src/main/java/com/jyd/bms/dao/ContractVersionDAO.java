package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContractVersion;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractVersionDAO extends HibernateBase<ContractVersion> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */

	public int getContractVersionCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractVersion> getPagingContractVersion(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有合同版本
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractVersion> getAllContractVersion() throws DAOException;

}
