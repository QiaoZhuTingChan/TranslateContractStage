package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeDuty;
import com.jyd.bms.dao.EmployeeDutyDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class EmployeeDutyDAOImpl extends HibernateBaseTemplate<EmployeeDuty> implements EmployeeDutyDAO {

	public int getEmployeeDutyCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from EmployeeDuty";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from EmployeeDuty where employee like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<EmployeeDuty> getPagingEmployeeDuty(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from EmployeeDuty";
		} else {
			hql = "from EmployeeDuty where employee like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<EmployeeDuty> getAllEmployeeDuty() throws DAOException {
		String hql = "";
		hql = "from EmployeeDuty";
		return super.getQueryResult(hql.toString());

	}
	
	public List<EmployeeDuty> findEmployeeDutyByEmp(Employee emp) throws DAOException{
		String hql = "";
		hql = "from EmployeeDuty where employee = :emp";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		return super.getQueryResult(hql, map);
	}

}
