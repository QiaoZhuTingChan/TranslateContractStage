package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractLender;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractLenderDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractLenderDAOImpl extends HibernateBaseTemplate<ContractLender> implements ContractLenderDAO {

	public int getContractLenderCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractLender";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractLender where contract.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractLender> getPagingContractLender(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractLender";
		} else {
			hql = "from ContractLender where contract.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractLender> getAllContractLender() throws DAOException {
		String hql = "";
		hql = "from ContractLender";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public List<ContractLender> getContractLenderByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractLender where contract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

	@Override
	public void deleteAll(CustomerContract contract) throws DAOException {
		String hql = "delete from ContractLender where contract =:contract";
		Map<String, Object> map = new HashMap<>();
		map.put("contract", contract);
		super.executeUpdate(hql, map);
	}

	@Override
	public int excuteBatchInsertContractLender(Set<ContractLender> contractLenderList) {
		// TODO Auto-generated method stub
		return 0;
	}

}
