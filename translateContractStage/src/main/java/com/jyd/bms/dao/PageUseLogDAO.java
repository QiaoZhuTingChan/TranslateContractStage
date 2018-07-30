package com.jyd.bms.dao;

import java.sql.Timestamp;
import java.util.List;

import com.jyd.bms.bean.PageUseLog;
import com.jyd.bms.tool.exception.DAOException;

public interface PageUseLogDAO extends HibernateBase<PageUseLog> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getPageUseLogCount(String condition, Timestamp begin, Timestamp end) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<PageUseLog> getPagingPageUseLog(int firstResult, int maxResults, String condition, Timestamp begin,
			Timestamp end) throws DAOException;

}
