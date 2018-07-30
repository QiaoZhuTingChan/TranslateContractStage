package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.BaThirdpartCompany;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-16 15:56:12 by GeneratedTool
 * @author mjy
 */
public interface BaThirdpartCompanyDAO extends HibernateBase<BaThirdpartCompany> {
	public int getBaThirdpartCompanyCount(String condition) throws DAOException;

	public List<BaThirdpartCompany> getPagingBaThirdpartCompany(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<BaThirdpartCompany> getAllBaThirdpartCompany() throws DAOException;
}