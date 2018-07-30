package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.BaSalaryLevel;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-05-09 17:33:57 by GeneratedTool
 * @author mjy
 */
public interface BaSalaryLevelDAO extends HibernateBase<BaSalaryLevel> {
	public int getBaSalaryLevelCount(String condition) throws DAOException;
	public List<BaSalaryLevel> getPagingBaSalaryLevel(int firstResult, int maxResults, String condition)throws DAOException;
	public List<BaSalaryLevel> getAllBaSalaryLevel() throws DAOException;
}