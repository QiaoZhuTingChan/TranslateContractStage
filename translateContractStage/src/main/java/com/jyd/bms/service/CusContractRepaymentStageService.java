package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.CusContractRepaymentStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.CusContractRepaymentStageDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-07-03 10:33:55 by GeneratedTool
 * @author mjy
 */
@Service("CusContractRepaymentStageService")
public class CusContractRepaymentStageService extends BaseService<CusContractRepaymentStage> {
	@Autowired(required = true)
	private CusContractRepaymentStageDAO cusContractRepaymentStageDAO;

	public int getCusContractRepaymentStageCount(String condition) throws DAOException {
		return cusContractRepaymentStageDAO.getCusContractRepaymentStageCount(condition);
	}

	public List<CusContractRepaymentStage> getPagingCusContractRepaymentStage(int firstResult, int maxResults,
			String condition) throws DAOException {
		return cusContractRepaymentStageDAO.getPagingCusContractRepaymentStage(firstResult, maxResults, condition);
	}

	public List<CusContractRepaymentStage> getAllCusContractRepaymentStage() throws DAOException {
		return cusContractRepaymentStageDAO.getAllCusContractRepaymentStage();
	}

	public CusContractRepaymentStage getCusContractRepaymentStage(CustomerContract contract) throws DAOException {
		return cusContractRepaymentStageDAO.getCusContractRepaymentStage(contract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = cusContractRepaymentStageDAO;
	}
}
