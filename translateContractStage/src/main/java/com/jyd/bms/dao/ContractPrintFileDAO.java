package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContractPrintFile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.tool.exception.DAOException;

public interface ContractPrintFileDAO extends HibernateBase<ContractPrintFile> {

	/**
	 * 查询所有由系统生成的合同文件
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractPrintFile> getAllContractPrintFile(CustomerContract contract) throws DAOException;

	/**
	 * 按文件类型查询所有由系统生成的合同文件
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractPrintFile> getAllFileNameByFileType(CustomerContract contract, String fileType)
			throws DAOException;

	/**
	 * 将现有合同文件标记为删除
	 * 
	 * @param contract
	 */
	public void setAllFileIsDelete(CustomerContract contract) throws DAOException;
	
	/**
	 * 根据合同编号获取合同打印文件
	 * @param customerContract
	 * @return
	 */
	public List<ContractPrintFile> getContractFilesByCusNo(CustomerContract customerContract) throws DAOException;
}
