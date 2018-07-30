package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.CusContractRepaymentOtherFee;
import com.jyd.bms.dao.CusContractRepaymentOtherFeeDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-06-27 10:54:48 by GeneratedTool
 * @author mjy
 */
@Service("CusContractRepaymentOtherFeeService")
public class CusContractRepaymentOtherFeeService extends BaseService<CusContractRepaymentOtherFee> {
	@Autowired(required = true)
	private CusContractRepaymentOtherFeeDAO cusContractRepaymentOtherFeeDAO;

	public int getCusContractRepaymentOtherFeeCount(String condition) throws DAOException {
		return cusContractRepaymentOtherFeeDAO.getCusContractRepaymentOtherFeeCount(condition);
	}

	public List<CusContractRepaymentOtherFee> getPagingCusContractRepaymentOtherFee(int firstResult, int maxResults,
			String condition) throws DAOException {
		return cusContractRepaymentOtherFeeDAO.getPagingCusContractRepaymentOtherFee(firstResult, maxResults,
				condition);
	}

	public List<CusContractRepaymentOtherFee> getAllCusContractRepaymentOtherFee() throws DAOException {
		return cusContractRepaymentOtherFeeDAO.getAllCusContractRepaymentOtherFee();
	}

	public List<CusContractRepaymentOtherFee> getOtherFeeByStage(ContractRepayment rep) throws DAOException {
		return cusContractRepaymentOtherFeeDAO.getOtherFeeByStage(rep);
	}

	@Override

	public void setDAO() {
		this.baseDAO = cusContractRepaymentOtherFeeDAO;
	}
}
