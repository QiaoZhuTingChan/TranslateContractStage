package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Product;
import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreMortgager;
import com.jyd.bms.dao.StoreMortgagerDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class StoreMortgagerDAOImpl extends HibernateBaseTemplate<StoreMortgager> implements StoreMortgagerDAO {

	public int getStoreMortgagerCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from StoreMortgager";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from StoreMortgager where mortgager.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<StoreMortgager> getPagingStoreMortgager(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from StoreMortgager";
		} else {
			hql = "from StoreMortgager where mortgager.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<StoreMortgager> getAllStoreMortgager() throws DAOException {
		String hql = "";
		hql = "from StoreMortgager";
		return super.getQueryResult(hql.toString());

	}

	/**
	 * @category  查找门店抵押人
	 * @param store
	 * @return 门店抵押人
	 */
	@Override
	public List<StoreMortgager> getStoreMortgagerByStore(Store store) throws DAOException {
		String hql = "";
		Map map=new HashMap();
		map.put("store", store);
		hql = "from StoreMortgager where store=:store";
		return super.getQueryResult(hql.toString(),map);
	}


}
