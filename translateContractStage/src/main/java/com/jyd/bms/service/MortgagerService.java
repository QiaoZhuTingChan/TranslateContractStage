package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Mortgager;
import com.jyd.bms.dao.MortgagerDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("MortgagerService")
public class MortgagerService extends BaseService<Mortgager> {
	@Autowired(required = true)
	private MortgagerDAO mortgagerDAO;

	public int getMortgagerCount(String condition) throws DAOException {
		return mortgagerDAO.getMortgagerCount(condition);
	}

	public List<Mortgager> getPagingMortgager(int firstResult, int maxResults, String condition) throws DAOException {
		return mortgagerDAO.getPagingMortgager(firstResult, maxResults, condition);
	}

	public List<Mortgager> getAllMortgager() throws DAOException {
		return mortgagerDAO.getAllMortgager();
	}

	@Override
	public void setDAO() {
		this.baseDAO = mortgagerDAO;
	}

	public Mortgager getMortgagerByName(String name) throws DAOException {
		return mortgagerDAO.getMortgagerByName(name);
	}
}
