package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.HrToLoan;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-03-22 18:56:34 by GeneratedTool
 * @author mjy
 */
public interface HrToLoanDAO extends HibernateBase<HrToLoan> {
	public int getHrToLoanCount(String condition) throws DAOException;
	public List<HrToLoan> getPagingHrToLoan(int firstResult, int maxResults, String condition)throws DAOException;
	public List<HrToLoan> getAllHrToLoan() throws DAOException;
}