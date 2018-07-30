package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.CusThirdpartGpsVehicleBaseData;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-07 14:18:29 by GeneratedTool
 * @author mjy
 */
public interface CusThirdpartGpsVehicleBaseDataDAO extends HibernateBase<CusThirdpartGpsVehicleBaseData> {
	public int getCusThirdpartGpsVehicleBaseDataCount(String condition) throws DAOException;

	public List<CusThirdpartGpsVehicleBaseData> getPagingCusThirdpartGpsVehicleBaseData(int firstResult, int maxResults,
			String condition) throws DAOException;

	public List<CusThirdpartGpsVehicleBaseData> getAllCusThirdpartGpsVehicleBaseData() throws DAOException;

	public List<CusThirdpartGpsVehicleBaseData> getCusThirdpartGpsVehicleBaseDataByPlate(String plate) throws DAOException;
}