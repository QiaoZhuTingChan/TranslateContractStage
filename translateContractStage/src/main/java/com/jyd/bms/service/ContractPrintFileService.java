package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractPrintFile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractPrintFileDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractPrintFileService")
public class ContractPrintFileService extends BaseService<ContractPrintFile> {
	@Autowired(required = true)
	private ContractPrintFileDAO contractPrintFileDAO;

	/**
	 * 查询所有由系统生成的合同文件
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractPrintFile> getAllContractPrintFile(CustomerContract contract) throws DAOException {
		return contractPrintFileDAO.getAllContractPrintFile(contract);
	}

	/**
	 * 按文件类型查询所有由系统生成的合同文件
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractPrintFile> getAllFileNameByFileType(CustomerContract contract, String fileType)
			throws DAOException {
		return contractPrintFileDAO.getAllFileNameByFileType(contract, fileType);
	}

	/**
	 * 将现有合同文件标记为删除
	 * 
	 * @param contract
	 * @throws DAOException
	 */
	public void setAllFileIsDelete(CustomerContract contract) throws DAOException {
		contractPrintFileDAO.setAllFileIsDelete(contract);
	}
	
	/**
	 * 根据合同编号获取合同打印文件
	 * @param contractPrintFile
	 * @return
	 */
	public List<ContractPrintFile> getContractFilesByCusNo(CustomerContract customerContract) throws DAOException{
		return contractPrintFileDAO.getContractFilesByCusNo(customerContract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractPrintFileDAO;
	}

}
