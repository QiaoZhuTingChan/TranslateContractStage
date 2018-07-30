package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.BaEmployeeProperties;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-09 17:15:16 by GeneratedTool
 * @author mjy
 */
public interface BaEmployeePropertiesDAO extends HibernateBase<BaEmployeeProperties> {
	public int getBaEmployeePropertiesCount(String condition) throws DAOException;
	public List<BaEmployeeProperties> getPagingBaEmployeeProperties(int firstResult, int maxResults, String condition)throws DAOException;
	public List<BaEmployeeProperties> getAllBaEmployeeProperties() throws DAOException;
}