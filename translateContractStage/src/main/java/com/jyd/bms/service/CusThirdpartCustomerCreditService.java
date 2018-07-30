package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.CusThirdpartCustomerCredit;
import com.jyd.bms.dao.CusThirdpartCustomerCreditDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-04-21 12:18:37 by GeneratedTool
 * @author mjy
 */
@Service("CusThirdpartCustomerCreditService")
public class CusThirdpartCustomerCreditService extends BaseService<CusThirdpartCustomerCredit> {
	@Autowired(required = true)
	private CusThirdpartCustomerCreditDAO cusThirdpartCustomerCreditDAO;

	public int getCusThirdpartCustomerCreditCount(String condition) throws DAOException {
		return cusThirdpartCustomerCreditDAO.getCusThirdpartCustomerCreditCount(condition);
	}

	public List<CusThirdpartCustomerCredit> getPagingCusThirdpartCustomerCredit(int firstResult, int maxResults,
			String condition) throws DAOException {
		return cusThirdpartCustomerCreditDAO.getPagingCusThirdpartCustomerCredit(firstResult, maxResults, condition);
	}

	public List<CusThirdpartCustomerCredit> getAllCusThirdpartCustomerCredit() throws DAOException {
		return cusThirdpartCustomerCreditDAO.getAllCusThirdpartCustomerCredit();
	}

	/**
	 * 根据身份id查询CusThirdpartCustomerCredit
	 * @param idCard
	 * @return
	 * @throws DAOException
	 */
	public List<CusThirdpartCustomerCredit> getCusThirdpartCustomerCreditByIdCard(String idCard) throws DAOException {
		return cusThirdpartCustomerCreditDAO.getCusThirdpartCustomerCreditByIdCard(idCard);
	}

	@Override
	public void setDAO() {
		this.baseDAO = cusThirdpartCustomerCreditDAO;
	}

	public List<CusThirdpartCustomerCredit> getCusThirdpartCustomerCreditByIdCardAndQueryTypeId(String idCard, int id) throws DAOException {
		return cusThirdpartCustomerCreditDAO.getCusThirdpartCustomerCreditByIdCardAndQueryTypeId(idCard, id);
	}
}
