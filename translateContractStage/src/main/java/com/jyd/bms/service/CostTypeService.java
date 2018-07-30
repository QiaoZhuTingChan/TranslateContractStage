package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CostType;
import com.jyd.bms.dao.CostTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("CostTypeService")
public class CostTypeService extends BaseService<CostType> {
	@Autowired(required = true)
	private CostTypeDAO costTypeDAO;

	public int getCostTypeCount(String condition) throws DAOException {
		return costTypeDAO.getCostTypeCount(condition);
	}

	public List<CostType> getPagingCostType(int firstResult, int maxResults, String condition) throws DAOException {
		return costTypeDAO.getPagingCostType(firstResult, maxResults, condition);
	}

	public List<CostType> getAllCostType() throws DAOException {
		return costTypeDAO.getAllCostType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = costTypeDAO;
	}

}
