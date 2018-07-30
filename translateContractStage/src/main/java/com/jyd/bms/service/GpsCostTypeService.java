package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.GpsCostType;
import com.jyd.bms.dao.GpsCostTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("GpsCostTypeService")
public class GpsCostTypeService extends BaseService<GpsCostType> {
	@Autowired(required = true)
	private GpsCostTypeDAO gpsCostTypeDAO;

	public int getGpsCostTypeCount(String condition) throws DAOException {
		return gpsCostTypeDAO.getGpsCostTypeCount(condition);
	}

	public List<GpsCostType> getPagingGpsCostType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return gpsCostTypeDAO.getPagingGpsCostType(firstResult, maxResults, condition);
	}

	public List<GpsCostType> getAllGpsCostType() throws DAOException {
		return gpsCostTypeDAO.getAllGpsCostType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = gpsCostTypeDAO;
	}

}
