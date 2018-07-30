package com.jyd.bms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractManageType;
import com.jyd.bms.dao.ContractManageTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractManageTypeDAOImpl extends HibernateBaseTemplate<ContractManageType> implements ContractManageTypeDAO {

	public List<ContractManageType> getAll() throws DAOException {
		String hql = "";
		hql = "from ContractManageType";
		return super.getQueryResult(hql.toString());
	}

}
