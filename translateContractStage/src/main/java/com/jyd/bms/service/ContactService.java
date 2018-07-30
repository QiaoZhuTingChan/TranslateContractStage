package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Contact;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.dao.ContactDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContactService")
public class ContactService extends BaseService<Contact> {
	@Autowired(required = true)
	private ContactDAO contactDAO;

	public int getContactCount(String condition) throws DAOException {
		return contactDAO.getContactCount(condition);
	}

	public List<Contact> getPagingContact(int firstResult, int maxResults, String condition) throws DAOException {
		return contactDAO.getPagingContact(firstResult, maxResults, condition);
	}

	public List<Contact> getAllContact() throws DAOException {
		return contactDAO.getAllContact();
	}
	
	public List<Contact> getContactByEmp(Employee emp) throws DAOException{
		return contactDAO.findContactByEmp(emp);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contactDAO;
	}

}
