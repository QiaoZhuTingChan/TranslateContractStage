package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.BaContractManageType;
import com.jyd.bms.dao.BaContractManageTypeDAO;
/**
 * @category Generated 2018-03-19 09:50:17 by GeneratedTool
 * @author mjy
 */
@Repository
public class BaContractManageTypeDAOImpl extends HibernateBaseTemplate<BaContractManageType> implements BaContractManageTypeDAO {

 public int getBaContractManageTypeCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from BaContractManageType";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from BaContractManageType where contractManageType like :condition";
	Map map = new HashMap();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 public List<BaContractManageType> getPagingBaContractManageType(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
	hql = "from BaContractManageType";
	} else {
	hql = "from BaContractManageType where contractManageType like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<BaContractManageType> getAllBaContractManageType() throws DAOException {
	String hql = "";
	hql = "from BaContractManageType";
	return super.getQueryResult(hql.toString());
 }
}
