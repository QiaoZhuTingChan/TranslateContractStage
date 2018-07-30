package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.BaParkingFee;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-03-19 09:43:47 by GeneratedTool
 * @author mjy
 */
public interface BaParkingFeeDAO extends HibernateBase<BaParkingFee> {
	public int getBaParkingFeeCount(String condition) throws DAOException;

	public List<BaParkingFee> getPagingBaParkingFee(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<BaParkingFee> getAllBaParkingFee() throws DAOException;
}