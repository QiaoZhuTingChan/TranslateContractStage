package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.CusContractMonth;
import com.jyd.bms.dao.CusContractMonthDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-16 16:26:22 by GeneratedTool
 * @author mjy
 */
@Service("CusContractMonthService")
public class CusContractMonthService extends BaseService<CusContractMonth> {
	@Autowired(required = true)
	private CusContractMonthDAO cusContractMonthDAO;

	public int getCusContractMonthCount(String condition) throws DAOException {
		return cusContractMonthDAO.getCusContractMonthCount(condition);
	}

	public List<CusContractMonth> getPagingCusContractMonth(int firstResult, int maxResults, String condition)
			throws DAOException {
		return cusContractMonthDAO.getPagingCusContractMonth(firstResult, maxResults, condition);
	}

	public List<CusContractMonth> getAllCusContractMonth() throws DAOException {
		return cusContractMonthDAO.getAllCusContractMonth();
	}

	@Override

	public void setDAO() {
		this.baseDAO = cusContractMonthDAO;
	}
}
