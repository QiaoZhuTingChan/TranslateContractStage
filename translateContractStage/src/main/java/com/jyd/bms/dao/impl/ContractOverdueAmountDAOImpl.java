package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractOverdueAmount;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractOverdueAmountDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractOverdueAmountDAOImpl extends HibernateBaseTemplate<ContractOverdueAmount>
		implements ContractOverdueAmountDAO {

	public int getContractOverdueAmountCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractOverdueAmount";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractOverdueAmount where contract.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractOverdueAmount> getPagingContractOverdueAmount(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractOverdueAmount";
		} else {
			hql = "from ContractOverdueAmount where contract.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractOverdueAmount> getAllContractOverdueAmount() throws DAOException {
		String hql = "";
		hql = "from ContractOverdueAmount";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public List<ContractOverdueAmount> getContractOverdueAmountByContract(CustomerContract contract) throws DAOException{
		String hql = "";
		hql = "from ContractOverdueAmount where contract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

}
