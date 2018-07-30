package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.BaThirdpartQueryType;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-16 16:48:05 by GeneratedTool
 * @author mjy
 */
public interface BaThirdpartQueryTypeDAO extends HibernateBase<BaThirdpartQueryType> {
	public int getBaThirdpartQueryTypeCount(String condition) throws DAOException;

	public List<BaThirdpartQueryType> getPagingBaThirdpartQueryType(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<BaThirdpartQueryType> getAllBaThirdpartQueryType() throws DAOException;

	public List<BaThirdpartQueryType> getBaThirdpartQueryTypeBelongToBairongCompany() throws DAOException;
}