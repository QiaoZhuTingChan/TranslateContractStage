package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Contract;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.dao.ContractDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractDAOImpl extends HibernateBaseTemplate<Contract> implements ContractDAO {

	public int getContractCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Contract";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Contract where Contract.employee.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<Contract> getPagingContract(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Contract";
		} else {
			hql = "from Contract where Contract.employee.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Contract> getAllContract() throws DAOException {
		String hql = "";
		hql = "from Contract";
		return super.getQueryResult(hql.toString());

	}
	
	public List<Contract> findContractByEmp(Employee emp) throws DAOException{
		String hql = "";
		hql = "from Contract where employee = :emp";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		return super.getQueryResult(hql, map);
	}

}
