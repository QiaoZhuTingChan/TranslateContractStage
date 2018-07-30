package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.CusContractMonth;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-16 16:26:22 by GeneratedTool
 * @author mjy
 */
public interface CusContractMonthDAO extends HibernateBase<CusContractMonth> {
	public int getCusContractMonthCount(String condition) throws DAOException;
	public List<CusContractMonth> getPagingCusContractMonth(int firstResult, int maxResults, String condition)throws DAOException;
	public List<CusContractMonth> getAllCusContractMonth() throws DAOException;
}