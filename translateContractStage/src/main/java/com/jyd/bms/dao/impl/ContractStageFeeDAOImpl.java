package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.ContractStageFee;
import com.jyd.bms.dao.ContractStageFeeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractStageFeeDAOImpl extends HibernateBaseTemplate<ContractStageFee> implements ContractStageFeeDAO {

	public int getContractStageFeeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractStageFee";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractStageFee where stage.contract.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractStageFee> getPagingContractStageFee(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractStageFee";
		} else {
			hql = "from ContractStageFee where stage.contract.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractStageFee> getAllContractStageFee() throws DAOException {
		String hql = "";
		hql = "from ContractStageFee";
		return super.getQueryResult(hql.toString());

	}

	public List<ContractStageFee> findContractStageFeeByContractStage(ContractStage contractStage) throws DAOException {
		String hql = "";
		hql = "from ContractStageFee where stage = :contractStage";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contractStage", contractStage);
		return super.getQueryResult(hql, map);
	}

	@Override
	public void deleteAll(ContractStage stage) throws DAOException {
		String hql = "delete from ContractStageFee where stage =:stage";
		Map<String, Object> map = new HashMap<>();
		map.put("stage", stage);
		super.executeUpdate(hql, map);
	}

	@Override
	public Double getExtraCharges(ContractStage stage) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		map.put("stage", stage);
		hql = "select sum(fee) from ContractStageFee where stage =:stage";
		List<Double> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0) == null ? 0 : lstCount.get(0).doubleValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ContractStageFee getContractStageFeeByContractStage(ContractStage penultimate) throws DAOException {
		StringBuilder hql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();
		
		hql.append(" from ContractStageFee where stage = :penultimate");
		map.put("penultimate", penultimate);
		
		List<ContractStageFee> list = super.getQueryResult(hql.toString(), map);
		
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int excuteBatchInsertContractStageFee(Set<ContractStageFee> contractStageFeeList) {
		// TODO Auto-generated method stub
		return 0;
	}

}
