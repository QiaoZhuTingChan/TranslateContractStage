package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.FundProduct;
import com.jyd.bms.dao.FundProductDAO;

/**
 * @category Generated 2018-05-25 14:16:51 by GeneratedTool
 * @author mjy
 */
@Repository
public class FundProductDAOImpl extends HibernateBaseTemplate<FundProduct> implements FundProductDAO {

	public int getFundProductCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from FundProduct";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from FundProduct where name like :condition";
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<FundProduct> getPagingFundProduct(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from FundProduct";
		} else {
			hql = "from FundProduct where name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<FundProduct> getAllFundProduct() throws DAOException {
		String hql = "";
		hql = "from FundProduct";
		return super.getQueryResult(hql.toString());
	}

}
