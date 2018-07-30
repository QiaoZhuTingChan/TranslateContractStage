package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.ContractManageType;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category 合同管理费
 * @author mjy
 */
public interface ContractManageTypeDAO extends HibernateBase<ContractManageType> {
	public List<ContractManageType> getAll() throws DAOException;
}
