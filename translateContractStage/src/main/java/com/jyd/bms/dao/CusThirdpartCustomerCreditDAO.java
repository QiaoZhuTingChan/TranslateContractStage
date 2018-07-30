package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.CusThirdpartCustomerCredit;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-04-21 12:18:37 by GeneratedTool
 * @author mjy
 */
public interface CusThirdpartCustomerCreditDAO extends HibernateBase<CusThirdpartCustomerCredit> {
	public int getCusThirdpartCustomerCreditCount(String condition) throws DAOException;
	public List<CusThirdpartCustomerCredit> getPagingCusThirdpartCustomerCredit(int firstResult, int maxResults, String condition)throws DAOException;
	public List<CusThirdpartCustomerCredit> getAllCusThirdpartCustomerCredit() throws DAOException;
	
	public List<CusThirdpartCustomerCredit> getCusThirdpartCustomerCreditByIdCard(String idCard) throws DAOException;
	public List<CusThirdpartCustomerCredit> getCusThirdpartCustomerCreditByIdCardAndQueryTypeId(String idCard, int id)throws DAOException;
}