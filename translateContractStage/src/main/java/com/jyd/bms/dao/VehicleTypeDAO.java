package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.VehicleType;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category 车辆类型接口
 * @author hong
 */
public interface VehicleTypeDAO extends HibernateBase <VehicleType>{
	/**
	 * @category 依据查询参数统计车辆类型
	 * @param condition
	 * @return　车辆类型数量
	 * @throws DAOException
	 */
	public int getVehicleTypeCount(String condition)
			throws DAOException;

	/**
	 * @category 依据分页查询车辆类型集合
	 * @param firstResult　开始页
	 * @param maxResults　结束页
	 * @param condition　查询惨素和
	 * @return　车辆类型集合
	 * @throws DAOException
	 */
	public List<VehicleType> getPagingVehicleType(int firstResult, int maxResults,
			String condition) throws DAOException;
	/**
	 * @category 查询所有车辆类型
	 * @return　车辆类型集合
	 * @throws DAOException
	 */
	public List<VehicleType> getAllVehicleType() throws DAOException;

}
