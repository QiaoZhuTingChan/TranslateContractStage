package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContractUploadfile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Form;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractUploadfileDAO extends HibernateBase<ContractUploadfile> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getContractUploadfileCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<ContractUploadfile> getPagingContractUploadfile(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有合同上传文件
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractUploadfile> getAllContractUploadfile() throws DAOException;

	public List<ContractUploadfile> getContractUploadFileByContract(CustomerContract contract) throws DAOException;
	
	public void deleteAll(CustomerContract contract,Form form) throws DAOException;
}
