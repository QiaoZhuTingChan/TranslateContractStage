package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContactInfo;
import com.jyd.bms.bean.CustomerInfo;
import com.jyd.bms.dao.ContactInfoDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContactInfoService")
public class ContactInfoService extends BaseService<ContactInfo> {
	@Autowired(required = true)
	private ContactInfoDAO contactInfoDAO;

	public int getContactInfoCount(String condition) throws DAOException {
		return contactInfoDAO.getContactInfoCount(condition);
	}

	public List<ContactInfo> getPagingContactInfo(int firstResult, int maxResults, String condition)
			throws DAOException {
		return contactInfoDAO.getPagingContactInfo(firstResult, maxResults, condition);
	}

	public List<ContactInfo> getAllContactInfo() throws DAOException {
		return contactInfoDAO.getAllContactInfo();
	}
	
	
	public List<ContactInfo> getContactInfoByCustomerInfo(CustomerInfo customer) throws DAOException {
		return contactInfoDAO.getContactInfoByCustomerInfo(customer);
	}

	@Override
	public void setDAO() {
		this.baseDAO = contactInfoDAO;
	}

}
