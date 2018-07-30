package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractPrintFile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractPrintFileDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractPrintFileDAOImpl extends HibernateBaseTemplate<ContractPrintFile> implements ContractPrintFileDAO {
	/**
	 * 查询所有由系统生成的合同文件
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractPrintFile> getAllContractPrintFile(CustomerContract contract) throws DAOException {
		String hql = "from ContractPrintFile where contract = :contract";
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

	/**
	 * 按文件类型查询所有由系统生成的合同文件
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ContractPrintFile> getAllFileNameByFileType(CustomerContract contract, String fileType)
			throws DAOException {
		String hql = "from ContractPrintFile where contract = :contract and fileType =:fileType";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("fileType", fileType);
		return super.getQueryResult(hql, map);
	}

	/**
	 * 将现有合同文件标记为删除
	 * 
	 * @param contract
	 * @throws DAOException
	 */
	public void setAllFileIsDelete(CustomerContract contract) throws DAOException {
		String hql = "update ContractPrintFile set deleteFlag = 1 where contract = :contract";
		Map map = new HashMap();
		map.put("contract", contract);
		super.executeUpdate(hql, map);
	}

	@Override
	public List<ContractPrintFile> getContractFilesByCusNo(CustomerContract customerContract) throws DAOException{
		String hql = "select f from ContractPrintFile f,CustomerContract c where f.contract = c.id and f.deleteFlag =0 and c.contractNum = :contractNum ";
		Map paramMap = new HashMap();
		paramMap.put("contractNum", customerContract.getContractNum());
		return super.getQueryResult(hql,paramMap);
	}

}
