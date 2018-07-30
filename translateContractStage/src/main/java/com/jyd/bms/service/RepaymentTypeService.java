package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.RepaymentType;
import com.jyd.bms.dao.RepaymentTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("RepaymentTypeService")
public class RepaymentTypeService extends BaseService<RepaymentType> {
	@Autowired(required = true)
	private RepaymentTypeDAO repaymentTypeDAO;

	public int getRepaymentTypeCount(String condition) throws DAOException {
		return repaymentTypeDAO.getRepaymentTypeCount(condition);
	}

	public List<RepaymentType> getPagingRepaymentType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return repaymentTypeDAO.getPagingRepaymentType(firstResult, maxResults, condition);
	}

	public List<RepaymentType> getAllRepaymentType() throws DAOException {
		return repaymentTypeDAO.getAllRepaymentType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = repaymentTypeDAO;		
	}

}
