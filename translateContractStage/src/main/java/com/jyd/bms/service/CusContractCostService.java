package com.jyd.bms.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CusContractCost;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.CusContractCostDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("CusContractCostService")
public class CusContractCostService extends BaseService<CusContractCost> {
	@Autowired(required = true)
	private CusContractCostDAO cusContractCostDAO;

	public int getCusContractCostCount(String condition) throws DAOException {
		return cusContractCostDAO.getCusContractCostCount(condition);
	}

	public List<CusContractCost> getPagingCusContractCost(int firstResult, int maxResults, String condition)
			throws DAOException {
		return cusContractCostDAO.getPagingCusContractCost(firstResult, maxResults, condition);
	}

	public List<CusContractCost> getAllCusContractCost() throws DAOException {
		return cusContractCostDAO.getAllCusContractCost();
	}

	public List<CusContractCost> getCusContractCostByContract(CustomerContract contract) throws DAOException {
		return cusContractCostDAO.getCusContractCostByContract(contract);
	}

	public Set<CusContractCost> getCusContractCostByContractSet(CustomerContract contract) throws DAOException {
		return new HashSet<CusContractCost>(cusContractCostDAO.getCusContractCostByContract(contract));
	}

	public void deleteAll(CustomerContract contract) throws DAOException {
		cusContractCostDAO.deleteAll(contract);
	}

	@Override
	public void setDAO() {
		this.baseDAO = cusContractCostDAO;
	}

}
