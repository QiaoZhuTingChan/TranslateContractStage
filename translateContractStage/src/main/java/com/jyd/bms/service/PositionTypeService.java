package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.PositionType;
import com.jyd.bms.dao.PositionTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("PositionTypeService")
public class PositionTypeService extends BaseService<PositionType> {
	@Autowired(required = true)
	private PositionTypeDAO positionTypeDAO;

	public int getPositionTypeCount(String condition) throws DAOException {
		return positionTypeDAO.getPositionTypeCount(condition);
	}

	public List<PositionType> getPagingPositionType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return positionTypeDAO.getPagingPositionType(firstResult, maxResults, condition);
	}

	public List<PositionType> getAllPositionType() throws DAOException {
		return positionTypeDAO.getAllPositionType();
	}

	public List<PositionType> getPositionTypeByPara(String condition) throws DAOException {
		return positionTypeDAO.getPositionTypeByPara(condition);
	}

	@Override
	public void setDAO() {
		this.baseDAO = positionTypeDAO;
	}

}
