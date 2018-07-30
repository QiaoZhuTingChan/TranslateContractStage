package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.CusThirdpartQueryLog;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-04-20 13:41:29 by GeneratedTool
 * @author mjy
 */
public interface CusThirdpartQueryLogDAO extends HibernateBase<CusThirdpartQueryLog> {
	public int getCusThirdpartQueryLogCount(String condition) throws DAOException;
	public List<CusThirdpartQueryLog> getPagingCusThirdpartQueryLog(int firstResult, int maxResults, String condition)throws DAOException;
	public List<CusThirdpartQueryLog> getAllCusThirdpartQueryLog() throws DAOException;
}