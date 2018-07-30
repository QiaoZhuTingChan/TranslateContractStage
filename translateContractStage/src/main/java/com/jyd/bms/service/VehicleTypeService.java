package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.VehicleType;
import com.jyd.bms.dao.VehicleTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("VehicleTypeService")
public class VehicleTypeService extends BaseService<VehicleType> {
	@Autowired(required = true)
	private VehicleTypeDAO vehicleTypeDAO;

	public int getVehicleTypeCount(String condition) throws DAOException {
		return vehicleTypeDAO.getVehicleTypeCount(condition);
	}

	public List<VehicleType> getPagingVehicleType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return vehicleTypeDAO.getPagingVehicleType(firstResult, maxResults, condition);
	}

	public List<VehicleType> getAllVehicleType() throws DAOException {
		return vehicleTypeDAO.getAllVehicleType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = vehicleTypeDAO;
	}

}
