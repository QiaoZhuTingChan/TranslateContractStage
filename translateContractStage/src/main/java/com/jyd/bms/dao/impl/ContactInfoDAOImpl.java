package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContactInfo;
import com.jyd.bms.bean.CustomerInfo;
import com.jyd.bms.dao.ContactInfoDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContactInfoDAOImpl extends HibernateBaseTemplate<ContactInfo> implements ContactInfoDAO {

	public int getContactInfoCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContactInfo";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContactInfo,CustomerInfo where ContactInfo.customerId=CustomerInfo.id and CustomerInfo.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContactInfo> getPagingContactInfo(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContactInfo";
		} else {
			hql = "from ContactInfo,CustomerInfo where ContactInfo.customerId=CustomerInfo.id and CustomerInfo.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContactInfo> getAllContactInfo() throws DAOException {
		String hql = "";
		hql = "from ContactInfo";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public List<ContactInfo> getContactInfoByCustomerInfo(CustomerInfo customer) throws DAOException {
		String hql = "";
		hql = "from ContactInfo where customer = :customer";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("customer", customer);
		return super.getQueryResult(hql, map);
	}

}
