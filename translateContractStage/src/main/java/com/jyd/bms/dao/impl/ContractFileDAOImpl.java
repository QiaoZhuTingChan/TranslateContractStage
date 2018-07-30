package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractFile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractFileDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractFileDAOImpl extends HibernateBaseTemplate<ContractFile> implements ContractFileDAO {

	@Override
	public List<ContractFile> getContractFileByContract(int firstResult, int maxResults, int contractId, String name)
			throws DAOException {
		Map map = new HashMap();
		String hql = "";
		map.put("contractId", contractId);
		hql = "from ContractFile where contractId = :contractId";
		if (!name.equals("")) {
			map.put("name", name);
			hql += " and type =:name";
		}
		return super.getPagingQueryResult(hql, map, firstResult, maxResults);
	}

	@Override
	public int getContractFileCount(int contractId, String name) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		map.put("contractId", contractId);
		hql = "select count(1) from ContractFile where contractId = :contractId";
		if (!name.equals("")) {
			map.put("name", name);
			hql += " and type =:name";
		}
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	@Override
	public List<ContractFile> getContractFilesByContractNo(CustomerContract customerContract) throws DAOException {
		String hql = "select f from ContractFile f,CustomerContract c where f.contractId = c.id and c.contractNum = :contractNum ";
		Map paramMap = new HashMap();
		paramMap.put("contractNum", customerContract.getContractNum());
		return super.getQueryResult(hql,paramMap);
	}

}
