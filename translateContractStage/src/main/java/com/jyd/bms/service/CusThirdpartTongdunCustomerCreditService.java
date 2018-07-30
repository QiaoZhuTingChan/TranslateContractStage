package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CusThirdpartCustomerCredit;
import com.jyd.bms.bean.CusThirdpartTongdunCustomerCredit;
import com.jyd.bms.dao.CusThirdpartTongdunCustomerCreditDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-02 09:28:31 by GeneratedTool
 * @author mjy
 */
@Service("CusThirdpartTongdunCustomerCreditService")
public class CusThirdpartTongdunCustomerCreditService extends BaseService<CusThirdpartTongdunCustomerCredit> {
	@Autowired(required = true)
	private CusThirdpartTongdunCustomerCreditDAO cusThirdpartTongdunCustomerCreditDAO;

	public int getCusThirdpartTongdunCustomerCreditCount(String condition) throws DAOException {
		return cusThirdpartTongdunCustomerCreditDAO.getCusThirdpartTongdunCustomerCreditCount(condition);
	}

	public List<CusThirdpartTongdunCustomerCredit> getPagingCusThirdpartTongdunCustomerCredit(int firstResult,
			int maxResults, String condition) throws DAOException {
		return cusThirdpartTongdunCustomerCreditDAO.getPagingCusThirdpartTongdunCustomerCredit(firstResult, maxResults,
				condition);
	}

	public List<CusThirdpartTongdunCustomerCredit> getAllCusThirdpartTongdunCustomerCredit() throws DAOException {
		return cusThirdpartTongdunCustomerCreditDAO.getAllCusThirdpartTongdunCustomerCredit();
	}
	
	/**
	 * 根据身份id查询CusThirdpartCustomerCredit
	 * @param idCard
	 * @return
	 * @throws DAOException
	 */
	public List<CusThirdpartTongdunCustomerCredit> getCusThirdpartTongdunCustomerCreditByIdCard(String idCard) throws DAOException {
		return cusThirdpartTongdunCustomerCreditDAO.getCusThirdpartTongdunCustomerCreditByIdCard(idCard);
	}
	

	@Override

	public void setDAO() {
		this.baseDAO = cusThirdpartTongdunCustomerCreditDAO;
	}
}
