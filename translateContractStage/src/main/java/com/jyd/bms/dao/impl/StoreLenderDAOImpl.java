package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreLender;
import com.jyd.bms.dao.StoreLenderDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class StoreLenderDAOImpl extends HibernateBaseTemplate<StoreLender> implements StoreLenderDAO {

	public int getStoreLenderCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from StoreLender";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from StoreLender where lender.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<StoreLender> getPagingStoreLender(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from StoreLender";
		} else {
			hql = "from StoreLender where lender.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<StoreLender> getAllStoreLender() throws DAOException {
		String hql = "";
		hql = "from StoreLender";
		return super.getQueryResult(hql.toString());

	}
	/**
	 * @category 通过门店查出借人
	 * @param store
	 * @return　出借人
	 * @throws DAOException
	 */
	@Override
	public List<StoreLender> getStoreLenderByStore(Store store) throws DAOException {
		String hql = "";
		hql = "from StoreLender where store=:store";
		Map map=new HashMap();
		map.put("store", store);
		return super.getQueryResult(hql.toString(),map);
	}

}
