package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContractUploadfile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.CustomerInfo;
import com.jyd.bms.bean.VehicleInfo;
import com.jyd.bms.tool.exception.DAOException;
/**
 * 
 * @author hong
 * @category 车辆接口
 */
public interface VehicleInfoDAO extends HibernateBase <VehicleInfo>{
	/**
	 * @category 依据查询参数统计车辆
	 * @param condition　查询参数
	 * @return　车辆数量
	 * @throws DAOException
	 */
	public int getVehicleInfoCount(String condition)
			throws DAOException;

	public List<VehicleInfo> getPagingVehicleInfo(int firstResult, int maxResults,
			String condition) throws DAOException;
	
	public List<VehicleInfo> getAllVehicleInfo() throws DAOException;

	/**
	 * @category 根据车牌号查车辆信息
	 * @param plate
	 * @return
	 * @throws DAOException
	 */
	public VehicleInfo getVehicleInfoByPlate(String plate)throws DAOException;
	
	public List<VehicleInfo> getVehicleInfoByCustomerInfo(CustomerInfo customer) throws DAOException;

}
