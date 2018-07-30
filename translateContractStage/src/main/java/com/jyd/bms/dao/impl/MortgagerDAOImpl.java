package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Mortgager;
import com.jyd.bms.dao.MortgagerDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class MortgagerDAOImpl extends HibernateBaseTemplate<Mortgager> implements MortgagerDAO {

	public int getMortgagerCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Mortgager";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Mortgager where name like :condition or idCard like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<Mortgager> getPagingMortgager(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Mortgager";
		} else {
			hql = "from Mortgager where name like :condition or idCard like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Mortgager> getAllMortgager() throws DAOException {
		String hql = "";
		hql = "from Mortgager";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public Mortgager getMortgagerByName(String name) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("name", name);
		hql="from Mortgager where name=:name";
		List<Mortgager> lism=super.getQueryResult(hql,map);
		return lism.isEmpty()?null:lism.get(0);
	}

}
