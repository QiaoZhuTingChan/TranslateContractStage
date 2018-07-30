package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractBorrower;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractBorrowerDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class BorrowerDAOImpl extends HibernateBaseTemplate<ContractBorrower> implements ContractBorrowerDAO {

	/**
	 * 模糊查询
	 */
	public int getBorrowerCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractBorrower";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractBorrower where contract.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	/**
	 * 分页
	 */
	public List<ContractBorrower> getPagingBorrower(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractBorrower";
		} else {
			hql = "from ContractBorrower where contract.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	/**
	 * 查询所有
	 */
	public List<ContractBorrower> getAllBorrower() throws DAOException {
		String hql = "";
		hql = "from ContractBorrower";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public List<ContractBorrower> getContractBorrowerByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractBorrower where contract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

	@Override
	public void deleteAll(CustomerContract contract) throws DAOException {
		String hql = "delete from ContractBorrower where contract =:contract";
		Map<String, Object> map = new HashMap<>();
		map.put("contract", contract);
		super.executeUpdate(hql, map);
	}

}
