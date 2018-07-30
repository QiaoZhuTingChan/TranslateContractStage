package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.CusThirdpartQueryType;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-04-20 10:34:54 by GeneratedTool
 * @author mjy
 */
public interface CusThirdpartQueryTypeDAO extends HibernateBase<CusThirdpartQueryType> {
	public int getCusThirdpartQueryTypeCount(String condition) throws DAOException;
	public List<CusThirdpartQueryType> getPagingCusThirdpartQueryType(int firstResult, int maxResults, String condition)throws DAOException;
	public List<CusThirdpartQueryType> getAllCusThirdpartQueryType() throws DAOException;
	
	
	public List<CusThirdpartQueryType> getCusThirdpartQueryTypeWhichStatusIsTrue() throws DAOException;
}