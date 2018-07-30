package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.CusContractMonthDetailed;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-16 16:29:37 by GeneratedTool
 * @author mjy
 */
public interface CusContractMonthDetailedDAO extends HibernateBase<CusContractMonthDetailed> {
	public int getCusContractMonthDetailedCount(String condition) throws DAOException;
	public List<CusContractMonthDetailed> getPagingCusContractMonthDetailed(int firstResult, int maxResults, String condition)throws DAOException;
	public List<CusContractMonthDetailed> getAllCusContractMonthDetailed() throws DAOException;
}