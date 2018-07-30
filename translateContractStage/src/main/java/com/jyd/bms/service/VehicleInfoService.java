package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CustomerInfo;
import com.jyd.bms.bean.VehicleInfo;
import com.jyd.bms.dao.VehicleInfoDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("VehicleInfoService")
public class VehicleInfoService extends BaseService<VehicleInfo> {
	@Autowired(required = true)
	private VehicleInfoDAO vehicleInfoDAO;

	public int getVehicleInfoCount(String condition) throws DAOException {
		return vehicleInfoDAO.getVehicleInfoCount(condition);
	}

	public List<VehicleInfo> getPagingVehicleInfo(int firstResult, int maxResults, String condition)
			throws DAOException {
		return vehicleInfoDAO.getPagingVehicleInfo(firstResult, maxResults, condition);
	}

	public List<VehicleInfo> getAllVehicleInfo() throws DAOException {
		return vehicleInfoDAO.getAllVehicleInfo();
	}

	/**
	 * @category 根据车牌号查车辆
	 * @param plate
	 * @return
	 * @throws DAOException
	 */
	public VehicleInfo getVehicleInfoByPlate(String plate) throws DAOException{
		return vehicleInfoDAO.getVehicleInfoByPlate(plate);
	}
	
	public List<VehicleInfo> getVehicleInfoByCustomerInfo(CustomerInfo customer) throws DAOException {
		return vehicleInfoDAO.getVehicleInfoByCustomerInfo(customer);
	}
	
	@Override
	public void setDAO() {
		this.baseDAO = vehicleInfoDAO;
	}

}
