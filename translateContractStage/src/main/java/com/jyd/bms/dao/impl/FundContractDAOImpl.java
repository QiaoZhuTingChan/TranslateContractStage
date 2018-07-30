package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.FundContract;
import com.jyd.bms.dao.FundContractDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-25 14:05:15 by GeneratedTool
 * @author mjy
 */
@Repository
public class FundContractDAOImpl extends HibernateBaseTemplate<FundContract> implements FundContractDAO {

	public int getFundContractCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from FundContract";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from FundContract where cusContract.name like :condition";// 根据客户姓名查询
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<FundContract> getPagingFundContract(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from FundContract";
		} else {
			// 根据客户姓名,资金方查询
			hql = "from FundContract where cusContract.name like :condition or fund.fundType like :condition or fundProduct.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<FundContract> getAllFundContract() throws DAOException {
		String hql = "";
		hql = "from FundContract";
		return super.getQueryResult(hql.toString());
	}
}
