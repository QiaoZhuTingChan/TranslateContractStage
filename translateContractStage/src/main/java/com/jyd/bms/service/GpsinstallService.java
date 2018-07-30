package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Gpsinstall;
import com.jyd.bms.dao.GpsinstallDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("GpsinstallService")
public class GpsinstallService extends BaseService<Gpsinstall> {
	@Autowired(required = true)
	private GpsinstallDAO gpsinstallDAO;

	public List<Gpsinstall> getAllGpsinstall() throws DAOException {
		return gpsinstallDAO.getAllGpsinstall();
	}
	public int getCountByCustomerContract(CustomerContract contract) throws DAOException{
		return gpsinstallDAO.getCountByCustomerContract(contract);
	}
	public Gpsinstall getCountByContract(CustomerContract contract) throws DAOException{
		return gpsinstallDAO.getCountByContract(contract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = gpsinstallDAO;
	}

}
