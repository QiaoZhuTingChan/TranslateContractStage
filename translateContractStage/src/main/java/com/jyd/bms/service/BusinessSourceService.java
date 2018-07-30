package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.BusinessSource;
import com.jyd.bms.dao.BusinessSourceDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("BusinessSourceService")
public class BusinessSourceService extends BaseService<BusinessSource> {
	@Autowired(required = true)
	private BusinessSourceDAO businessSourceDAO;

	public int getBusinessSourceCount(String condition) throws DAOException {
		return businessSourceDAO.getBusinessSourceCount(condition);
	}

	public List<BusinessSource> getPagingBusinessSource(int firstResult, int maxResults, String condition) throws DAOException {
		return businessSourceDAO.getPagingBusinessSource(firstResult, maxResults, condition);
	}

	public List<BusinessSource> getAllBusinessSource() throws DAOException {
		return businessSourceDAO.getAllBusinessSource();
	}

	@Override
	public void setDAO() {
		this.baseDAO = businessSourceDAO;
	}

}
