package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Lender;
import com.jyd.bms.dao.LenderDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("LenderService")
public class LenderService extends BaseService<Lender> {
	@Autowired(required = true)
	private LenderDAO lenderDAO;

	public int getLenderCount(String condition) throws DAOException {
		return lenderDAO.getLenderCount(condition);
	}

	public List<Lender> getPagingLender(int firstResult, int maxResults, String condition) throws DAOException {
		return lenderDAO.getPagingLender(firstResult, maxResults, condition);
	}

	public List<Lender> getAllLender() throws DAOException {
		return lenderDAO.getAllLender();
	}

	@Override
	public void setDAO() {
		this.baseDAO = lenderDAO;
	}

}
