package com.jyd.bms.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.CustomerInfo;
import com.jyd.bms.bean.VehicleInfo;
import com.jyd.bms.dao.CustomerInfoDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class CustomerInfoDAOImpl extends HibernateBaseTemplate<CustomerInfo> implements CustomerInfoDAO {

	public int getCustomerInfoCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CustomerInfo";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CustomerInfo where name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<CustomerInfo> getPagingCustomerInfo(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CustomerInfo";
		} else {
			hql = "from CustomerInfo where name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<CustomerInfo> getAllCustomerInfo() throws DAOException {
		String hql = "";
		hql = "from CustomerInfo";
		return super.getQueryResult(hql.toString());
	}

	@Override
	public CustomerInfo getCustomerInfoByidCard(String idNum) throws DAOException {
				Map map = new HashMap();
				map.put("idNum",idNum);
				String hql = "";
				hql = "from CustomerInfo where idNum=:idNum";
				List<CustomerInfo> list=super.getQueryResult(hql,map);
				if(!list.isEmpty()) {
					return list.get(0);
				}
				return null;
	}

}
