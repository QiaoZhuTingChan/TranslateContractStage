package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CustomerInfo;
import com.jyd.bms.dao.CustomerInfoDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("CustomerInfoService")
public class CustomerInfoService extends BaseService<CustomerInfo> {
	@Autowired(required = true)
	private CustomerInfoDAO customerInfoDAO;

	public int getCustomerInfoCount(String condition) throws DAOException {
		return customerInfoDAO.getCustomerInfoCount(condition);
	}

	public List<CustomerInfo> getPagingCustomerInfo(int firstResult, int maxResults, String condition)
			throws DAOException {
		return customerInfoDAO.getPagingCustomerInfo(firstResult, maxResults, condition);
	}

	public List<CustomerInfo> getAllCustomerInfo() throws DAOException {
		return customerInfoDAO.getAllCustomerInfo();
	}
	/**
	 * @category 查找客户根据身份证号码
	 * @param idCard
	 * @return
	 * @throws DAOException
	 */
	public CustomerInfo getCustomerInfoByidCard(String idCard) throws DAOException{
		return customerInfoDAO.getCustomerInfoByidCard(idCard);
	}
	@Override
	public void setDAO() {
		this.baseDAO = customerInfoDAO;
	}

}
