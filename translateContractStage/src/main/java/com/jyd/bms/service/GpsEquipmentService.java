package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Contact;
import com.jyd.bms.bean.GpsEquiment;
import com.jyd.bms.bean.Gpsinstall;
import com.jyd.bms.dao.GpsinstallLoctionDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("GpsEquipmentService")
public class GpsEquipmentService extends BaseService<GpsEquiment> {
	@Autowired(required = true)
	private GpsinstallLoctionDAO gpsinstallLoctionDAO;

	public int getContactCount(String condition) throws DAOException {
		return gpsinstallLoctionDAO.getGpsinstallLoctionCount(condition);
	}

	public List<GpsEquiment> getPagingContact(int firstResult, int maxResults, String condition) throws DAOException {
		return gpsinstallLoctionDAO.getPagingGpsEquiment(firstResult, maxResults, condition);
	}

	public List<GpsEquiment> getAllContact() throws DAOException {
		return gpsinstallLoctionDAO.getAllGpsEquiment();
	}

	public List<GpsEquiment> getGpsEquimentByGpsinstall(Gpsinstall install) throws DAOException {
		return gpsinstallLoctionDAO.getGpsEquimentByGpsinstall(install);
	}

	@Override
	public void setDAO() {
		this.baseDAO = gpsinstallLoctionDAO;
	}

}
