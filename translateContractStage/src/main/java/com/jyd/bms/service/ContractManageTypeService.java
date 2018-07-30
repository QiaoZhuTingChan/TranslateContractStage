package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ContractManageType;
import com.jyd.bms.dao.ContractManageTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ContractManageTypeService")
public class ContractManageTypeService extends BaseService<ContractManageType> {
	@Autowired(required = true)
	private ContractManageTypeDAO contractManageTypeDAO;

	public List<ContractManageType> getAll() throws DAOException {
		return contractManageTypeDAO.getAll();
	}

	@Override
	public void setDAO() {
		this.baseDAO = contractManageTypeDAO;
	}

}
