package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.CusThirdpartTongdunCustomerCredit;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-02 09:28:31 by GeneratedTool
 * @author mjy
 */
public interface CusThirdpartTongdunCustomerCreditDAO extends HibernateBase<CusThirdpartTongdunCustomerCredit> {
	public int getCusThirdpartTongdunCustomerCreditCount(String condition) throws DAOException;

	public List<CusThirdpartTongdunCustomerCredit> getPagingCusThirdpartTongdunCustomerCredit(int firstResult,
			int maxResults, String condition) throws DAOException;

	public List<CusThirdpartTongdunCustomerCredit> getAllCusThirdpartTongdunCustomerCredit() throws DAOException;

	public List<CusThirdpartTongdunCustomerCredit> getCusThirdpartTongdunCustomerCreditByIdCard(String idCard) throws DAOException;
}