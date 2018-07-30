package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.HrToLoan;
import com.jyd.bms.dao.HrToLoanDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-03-22 18:56:34 by GeneratedTool
 * @author mjy
 */
@Service("HrToLoanService")
public class HrToLoanService extends BaseService<HrToLoan> {
	@Autowired(required = true)
	private HrToLoanDAO hrToLoanDAO;

	public int getHrToLoanCount(String condition) throws DAOException {
		return hrToLoanDAO.getHrToLoanCount(condition);
	}

	public List<HrToLoan> getPagingHrToLoan(int firstResult, int maxResults, String condition) throws DAOException {
		return hrToLoanDAO.getPagingHrToLoan(firstResult, maxResults, condition);
	}

	public List<HrToLoan> getAllHrToLoan() throws DAOException {
		return hrToLoanDAO.getAllHrToLoan();
	}

	@Override

	public void setDAO() {
		this.baseDAO = hrToLoanDAO;
	}
}
