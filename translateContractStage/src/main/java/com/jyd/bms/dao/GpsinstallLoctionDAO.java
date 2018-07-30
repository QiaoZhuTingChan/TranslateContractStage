package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.GpsEquiment;
import com.jyd.bms.bean.Gpsinstall;
import com.jyd.bms.tool.exception.DAOException;

public interface GpsinstallLoctionDAO extends HibernateBase<GpsEquiment> {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */

	public int getGpsinstallLoctionCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<GpsEquiment> getPagingGpsEquiment(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有设备
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<GpsEquiment> getAllGpsEquiment() throws DAOException;

	public List<GpsEquiment> getGpsEquimentByGpsinstall(Gpsinstall gpsinstall) throws DAOException;

}
