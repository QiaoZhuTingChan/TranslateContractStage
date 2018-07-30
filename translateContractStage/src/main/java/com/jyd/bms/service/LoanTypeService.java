package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.LoanType;
import com.jyd.bms.dao.LoanTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("LoanTypeService")
public class LoanTypeService extends BaseService<LoanType> {
	@Autowired(required = true)
	private LoanTypeDAO loanTypeDAO;

	public int getLoanTypeCount(String condition) throws DAOException {
		return loanTypeDAO.getLoanTypeCount(condition);
	}

	public List<LoanType> getPagingDutyType(int firstResult, int maxResults, String condition) throws DAOException {
		return loanTypeDAO.getPagingLoanType(firstResult, maxResults, condition);
	}

	public List<LoanType> getAllLoanType() throws DAOException {
		return loanTypeDAO.getAllLoanType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = loanTypeDAO;
	}

}
