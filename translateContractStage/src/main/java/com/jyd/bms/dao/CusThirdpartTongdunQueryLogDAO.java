package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.CusThirdpartTongdunQueryLog;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-02 09:34:37 by GeneratedTool
 * @author mjy
 */
public interface CusThirdpartTongdunQueryLogDAO extends HibernateBase<CusThirdpartTongdunQueryLog> {
	public int getCusThirdpartTongdunQueryLogCount(String condition) throws DAOException;

	public List<CusThirdpartTongdunQueryLog> getPagingCusThirdpartTongdunQueryLog(int firstResult, int maxResults,
			String condition) throws DAOException;

	public List<CusThirdpartTongdunQueryLog> getAllCusThirdpartTongdunQueryLog() throws DAOException;
}