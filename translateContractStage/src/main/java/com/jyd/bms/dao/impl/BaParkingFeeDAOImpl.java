package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.BaParkingFee;
import com.jyd.bms.dao.BaParkingFeeDAO;

/**
 * @category Generated 2018-03-19 09:43:47 by GeneratedTool
 * @author mjy
 */
@Repository
public class BaParkingFeeDAOImpl extends HibernateBaseTemplate<BaParkingFee> implements BaParkingFeeDAO {

	public int getBaParkingFeeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from BaParkingFee";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from BaParkingFee where type like :condition";
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<BaParkingFee> getPagingBaParkingFee(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from BaParkingFee";
		} else {
			hql = "from BaParkingFee where type like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<BaParkingFee> getAllBaParkingFee() throws DAOException {
		String hql = "";
		hql = "from BaParkingFee";
		return super.getQueryResult(hql.toString());
	}
}
