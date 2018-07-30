package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.AssetsType;
import com.jyd.bms.dao.AssetsTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class AssetsTypeDAOImpl extends HibernateBaseTemplate<AssetsType> implements AssetsTypeDAO {

	public int getAssetsTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from AssetsType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from AssetsType where assetsType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<AssetsType> getPagingAssetsType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from AssetsType";
		} else {
			hql = "from AssetsType where assetsType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<AssetsType> getAllAssetsType() throws DAOException {
		String hql = "";
		hql = "from AssetsType";
		return super.getQueryResult(hql.toString());

	}

}
