package com.jyd.bms.dao;
import java.util.List;
import com.jyd.bms.bean.BaContractManageType;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-03-19 09:50:17 by GeneratedTool
 * @author mjy
 */
public interface BaContractManageTypeDAO extends HibernateBase<BaContractManageType> {
	public int getBaContractManageTypeCount(String condition) throws DAOException;
	public List<BaContractManageType> getPagingBaContractManageType(int firstResult, int maxResults, String condition)throws DAOException;
	public List<BaContractManageType> getAllBaContractManageType() throws DAOException;
}