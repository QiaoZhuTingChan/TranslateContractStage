package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.CusContractRenewal;
import com.jyd.bms.dao.CusContractRenewalDAO;
import com.jyd.bms.tool.exception.DAOException;
/**
 * @category Generated 2018-07-02 14:28:13 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusContractRenewalDAOImpl extends HibernateBaseTemplate<CusContractRenewal> implements CusContractRenewalDAO {

 @SuppressWarnings("unchecked")
public int getCusContractRenewalCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from CusContractRenewal";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from CusContractRenewal where cusContractId like :condition";
	Map<String, Object> map = new HashMap<>();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 @SuppressWarnings("unchecked")
public List<CusContractRenewal> getPagingCusContractRenewal(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map<String, Object> map = new HashMap<>();
	if (condition.equals("")) {
	hql = "from CusContractRenewal";
	} else {
	hql = "from CusContractRenewal where cusContractId like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 @SuppressWarnings("unchecked")
public List<CusContractRenewal> getAllCusContractRenewal() throws DAOException {
	String hql = "";
	hql = "from CusContractRenewal";
	return super.getQueryResult(hql.toString());
 }
}
