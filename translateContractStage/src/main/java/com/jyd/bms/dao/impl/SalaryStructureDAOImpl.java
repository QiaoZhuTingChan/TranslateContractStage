package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.bean.SalaryItemType;
import com.jyd.bms.bean.SalaryStructure;
import com.jyd.bms.dao.SalaryStructureDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class SalaryStructureDAOImpl extends HibernateBaseTemplate<SalaryStructure> implements SalaryStructureDAO{

	
	public int getSalaryStructureCount(String condition) throws DAOException {
		String hql = "";
		if(condition.equals("")) {
			hql = "select count(*) from SalaryStructure";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		}else {
			hql = "select count(*) from SalaryStructure where salaryStructure like :condition";
			Map<String, String> map = new HashMap<>();
			map.put("condition", "%"+condition+"%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	
	public List<SalaryStructure> getPagingSalaryStructure(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, String> map = new HashMap<>();
		if(condition.equals("")) {
			hql = "from SalaryStructure";
		}else {
			hql = "from SalaryStructure where salaryStructure like :condition";
			map.put("condition", "%"+condition+"%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	
	public List<SalaryStructure> getAllSalaryStructure() throws DAOException {
		String hql = "";
		hql = "from SalaryStructure";
		return super.getQueryResult(hql.toString());
	}


	/*
	 * 导出excel表
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<SalaryItem> getSalaryItemByformula(SalaryStructure salaryStructure) throws DAOException {
		String hql = "from SalaryItem where formula = :fromula";
		Map<String, Object> map = new HashMap<>();
		map.put("formula", salaryStructure.getFormula());
		List<SalaryItem> list = getQueryResult(hql, map);
		return list;
	}

}
