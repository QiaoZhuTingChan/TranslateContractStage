package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.RepaymentAccount;
import com.jyd.bms.dao.RepaymentAccountDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("RepaymentAccountService")
public class RepaymentAccountService extends BaseService<RepaymentAccount> {
	@Autowired(required = true)
	private RepaymentAccountDAO repaymentAccountDAO;

	public int getRepaymentAccountCount(String condition) throws DAOException {
		return repaymentAccountDAO.getRepaymentAccountCount(condition);
	}

	public List<RepaymentAccount> getPagingRepaymentAccount(int firstResult, int maxResults, String condition)
			throws DAOException {
		return repaymentAccountDAO.getPagingRepaymentAccount(firstResult, maxResults, condition);
	}

	public List<RepaymentAccount> getAllRepaymentAccount() throws DAOException {
		return repaymentAccountDAO.getAllRepaymentAccount();
	}

	@Override
	public void setDAO() {
		this.baseDAO = repaymentAccountDAO;
	}

}
