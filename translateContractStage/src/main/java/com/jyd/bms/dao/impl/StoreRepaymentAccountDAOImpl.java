package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreRepaymentAccount;
import com.jyd.bms.dao.StoreRepaymentAccountDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class StoreRepaymentAccountDAOImpl extends HibernateBaseTemplate<StoreRepaymentAccount>
		implements StoreRepaymentAccountDAO {

	public int getStoreRepaymentAccountCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from StoreRepaymentAccount";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from StoreRepaymentAccount where repaymentAccount.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<StoreRepaymentAccount> getPagingStoreRepaymentAccount(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from StoreRepaymentAccount";
		} else {
			hql = "from StoreRepaymentAccount where repaymentAccount.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<StoreRepaymentAccount> getAllStoreRepaymentAccount() throws DAOException {
		String hql = "";
		hql = "from StoreRepaymentAccount";
		return super.getQueryResult(hql.toString());

	}

	/**
	 * @category 根据门店查找还款人
	 * @return
	 * @throws DAOException
	 */
	public List<StoreRepaymentAccount> getStoreRepaymentAccountByStore(Store store) throws DAOException {
		String hql = "";
		Map map=new HashMap();
		map.put("store", store);
		hql = "from StoreRepaymentAccount where store=:store";
		return super.getQueryResult(hql.toString(),map);
	}

}
