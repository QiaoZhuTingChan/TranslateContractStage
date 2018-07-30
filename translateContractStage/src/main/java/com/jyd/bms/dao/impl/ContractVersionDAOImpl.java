package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractVersion;
import com.jyd.bms.dao.ContractVersionDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractVersionDAOImpl extends HibernateBaseTemplate<ContractVersion> implements ContractVersionDAO {

	public int getContractVersionCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractVersion";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractVersion where version like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractVersion> getPagingContractVersion(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractVersion";
		} else {
			hql = "from ContractVersion where version like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractVersion> getAllContractVersion() throws DAOException {
		String hql = "";
		hql = "from ContractVersion";
		return super.getQueryResult(hql.toString());

	}

}
