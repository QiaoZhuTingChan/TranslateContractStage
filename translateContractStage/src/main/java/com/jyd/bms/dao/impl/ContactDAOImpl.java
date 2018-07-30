package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Contact;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.dao.ContactDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContactDAOImpl extends HibernateBaseTemplate<Contact> implements ContactDAO {

	public int getContactCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Contact";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Contact where Contact.employee.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<Contact> getPagingContact(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Contact";
		} else {
			hql = "from Contact where Contact.employee.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Contact> getAllContact() throws DAOException {
		String hql = "";
		hql = "from Contact";
		return super.getQueryResult(hql.toString());

	}
	
	public List<Contact> findContactByEmp(Employee emp) throws DAOException{
		String hql = "";
		hql = "from Contact where employee = :emp";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		return super.getQueryResult(hql, map);
		
	}

}
