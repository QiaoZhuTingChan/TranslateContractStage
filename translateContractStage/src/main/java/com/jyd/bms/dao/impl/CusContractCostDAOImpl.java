package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.CusContractCost;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.CusContractCostDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class CusContractCostDAOImpl extends HibernateBaseTemplate<CusContractCost> implements CusContractCostDAO {

	public int getCusContractCostCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusContractCost";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusContractCost where contract.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<CusContractCost> getPagingCusContractCost(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CusContractCost";
		} else {
			hql = "from CusContractCost where contract.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<CusContractCost> getAllCusContractCost() throws DAOException {
		String hql = "";
		hql = "from CusContractCost";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public List<CusContractCost> getCusContractCostByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from CusContractCost where contract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

	@Override
	public void deleteAll(CustomerContract contract) throws DAOException {
		String hql = "delete from CusContractCost where contract =:contract";
		Map<String, Object> map = new HashMap<>();
		map.put("contract", contract);
		super.executeUpdate(hql, map);
	}

	@Override
	public int excuteBatchInsertCusContractCost(Set<CusContractCost> cusContractCostList) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
