package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.CusContractRenewal;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-07-02 14:28:13 by GeneratedTool
 * @author mjy
 */
public interface CusContractRenewalDAO extends HibernateBase<CusContractRenewal> {
	public int getCusContractRenewalCount(String condition) throws DAOException;

	public List<CusContractRenewal> getPagingCusContractRenewal(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<CusContractRenewal> getAllCusContractRenewal() throws DAOException;
}