package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.Fund;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-25 14:04:37 by GeneratedTool
 * @author mjy
 */
public interface FundDAO extends HibernateBase<Fund> {
	public int getFundCount(String condition) throws DAOException;
	public List<Fund> getPagingFund(int firstResult, int maxResults, String condition)throws DAOException;
	public List<Fund> getAllFund() throws DAOException;
}