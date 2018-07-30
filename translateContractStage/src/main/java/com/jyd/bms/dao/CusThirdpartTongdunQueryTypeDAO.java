package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.CusThirdpartTongdunQueryType;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-02 09:35:24 by GeneratedTool
 * @author mjy
 */
public interface CusThirdpartTongdunQueryTypeDAO extends HibernateBase<CusThirdpartTongdunQueryType> {
	public int getCusThirdpartTongdunQueryTypeCount(String condition) throws DAOException;

	public List<CusThirdpartTongdunQueryType> getPagingCusThirdpartTongdunQueryType(int firstResult, int maxResults,
			String condition) throws DAOException;

	public List<CusThirdpartTongdunQueryType> getAllCusThirdpartTongdunQueryType() throws DAOException;

	public List<CusThirdpartTongdunQueryType> getCusThirdpartTongdunQueryTypeWhichStatusIsTrue() throws DAOException;
}