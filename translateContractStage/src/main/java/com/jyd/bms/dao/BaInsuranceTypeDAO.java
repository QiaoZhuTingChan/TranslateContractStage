package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.BaInsuranceType;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-03-19 14:56:32 by GeneratedTool
 * @author mjy
 */
public interface BaInsuranceTypeDAO extends HibernateBase<BaInsuranceType> {
	public int getBaInsuranceTypeCount(String condition) throws DAOException;
	public List<BaInsuranceType> getPagingBaInsuranceType(int firstResult, int maxResults, String condition)throws DAOException;
	public List<BaInsuranceType> getAllBaInsuranceType() throws DAOException;
}