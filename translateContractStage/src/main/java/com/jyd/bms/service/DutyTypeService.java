package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.DutyType;
import com.jyd.bms.dao.DutyTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("DutyTypeService")
public class DutyTypeService extends BaseService<DutyType> {
	@Autowired(required = true)
	private DutyTypeDAO dutyTypeDAO;

	public int getDutyTypeCount(String condition) throws DAOException {
		return dutyTypeDAO.getDutyTypeCount(condition);
	}

	public List<DutyType> getPagingDutyType(int firstResult, int maxResults, String condition) throws DAOException {
		return dutyTypeDAO.getPagingDutyType(firstResult, maxResults, condition);
	}

	public List<DutyType> getAllDutyType() throws DAOException {
		return dutyTypeDAO.getAllDutyType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = dutyTypeDAO;
	}

}
