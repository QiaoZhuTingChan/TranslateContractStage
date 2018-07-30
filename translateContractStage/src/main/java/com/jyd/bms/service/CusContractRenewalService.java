package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.CusContractRenewal;
import com.jyd.bms.dao.CusContractRenewalDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-07-02 14:28:13 by GeneratedTool
 * @author mjy
 */
@Service("CusContractRenewalService")
public class CusContractRenewalService extends BaseService<CusContractRenewal> {
	@Autowired(required = true)
	private CusContractRenewalDAO cusContractRenewalDAO;

	public int getCusContractRenewalCount(String condition) throws DAOException {
		return cusContractRenewalDAO.getCusContractRenewalCount(condition);
	}

	public List<CusContractRenewal> getPagingCusContractRenewal(int firstResult, int maxResults, String condition)
			throws DAOException {
		return cusContractRenewalDAO.getPagingCusContractRenewal(firstResult, maxResults, condition);
	}

	public List<CusContractRenewal> getAllCusContractRenewal() throws DAOException {
		return cusContractRenewalDAO.getAllCusContractRenewal();
	}

	@Override

	public void setDAO() {
		this.baseDAO = cusContractRenewalDAO;
	}
}
