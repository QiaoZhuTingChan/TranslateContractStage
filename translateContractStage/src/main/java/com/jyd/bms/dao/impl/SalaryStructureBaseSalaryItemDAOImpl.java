package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.SalaryStructure;
import com.jyd.bms.bean.SalaryStructureBaseSalaryItem;
import com.jyd.bms.dao.SalaryStructureBaseSalaryItemDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class SalaryStructureBaseSalaryItemDAOImpl extends HibernateBaseTemplate<SalaryStructureBaseSalaryItem> implements SalaryStructureBaseSalaryItemDAO{

	
	@SuppressWarnings("unchecked")
	public int getSalaryStructureBaseSalaryItemCountBySalaryStructure(String condition, SalaryStructure salaryStructure) throws DAOException {
		/*String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from SalaryStructureBaseSalaryItem";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from SalaryStructureBaseSalaryItem where salaryStructure.salaryStructure like :condition";
			Map<String, String> map = new HashMap<String, String>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}*/
		
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		
		hql.append("select count(*) from SalaryStructureBaseSalaryItem where 1=1");
		if (!condition.equals("")) {
			hql.append(" and salaryStructure.salaryStructure like :condition");
			map.put("condition", condition);
		}
		if(salaryStructure != null) {
			hql.append(" and salaryStructure = :salaryStructure");
			map.put("salaryStructure", salaryStructure);
		}
		List<Long> listCount = super.getQueryResult(hql.toString(), map);
		return listCount.get(0).intValue();
		
	}

	@SuppressWarnings("unchecked")
	public List<SalaryStructureBaseSalaryItem> getPagingSalaryStructureBaseSalaryItemBySalaryStructure(int firstResult, int maxResults,
			String condition, SalaryStructure salaryStructure) throws DAOException {
		/*String hql = "";
		Map<String, String> map = new HashMap<String, String>();
		if (condition.equals("")) {
			hql = "from SalaryStructureBaseSalaryItem";
		} else {
			hql = "from SalaryStructureBaseSalaryItem where salaryStructure.salaryStructure like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);*/
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		
		hql.append("from SalaryStructureBaseSalaryItem where 1=1");
		if (!condition.equals("")) {
			hql.append(" and salaryStructure.salaryStructure like :condition");
			map.put("condition", condition);
		}
		if(salaryStructure != null) {
			hql.append(" and salaryStructure = :salaryStructure");
			map.put("salaryStructure", salaryStructure);
		}
		List<SalaryStructureBaseSalaryItem> list = super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
		
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	public List<SalaryStructureBaseSalaryItem> getAllSalaryStructureBaseSalaryItem(SalaryStructure salaryStructure) throws DAOException {
		/*String hql = "";
		hql = "from SalaryStructureBaseSalaryItem";
		return super.getQueryResult(hql.toString());*/
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		
		hql.append("from SalaryStructureBaseSalaryItem where 1=1");
		if(salaryStructure != null) {
			hql.append(" and salaryStructure = :salaryStructure");
			map.put("salaryStructure", salaryStructure);
		}
		
		List<SalaryStructureBaseSalaryItem> list = super.getQueryResult(hql.toString(), map);
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaryStructureBaseSalaryItem> getSalaryStructureBaseSalaryItemBySalaryStructure(SalaryStructure salaryStructure) throws DAOException {
		
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		
		hql.append("from SalaryStructureBaseSalaryItem where salaryStructure = :salaryStructure");
		map.put("salaryStructure", salaryStructure);
		
		return super.getQueryResult(hql.toString(), map);
	}

}
