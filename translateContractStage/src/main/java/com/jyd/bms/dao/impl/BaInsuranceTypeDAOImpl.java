package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.BaInsuranceType;
import com.jyd.bms.dao.BaInsuranceTypeDAO;
/**
 * @category Generated 2018-03-19 14:56:32 by GeneratedTool
 * @author mjy
 */
@Repository
public class BaInsuranceTypeDAOImpl extends HibernateBaseTemplate<BaInsuranceType> implements BaInsuranceTypeDAO {

 public int getBaInsuranceTypeCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from BaInsuranceType";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from BaInsuranceType where insuranceType like :condition";
	Map map = new HashMap();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 public List<BaInsuranceType> getPagingBaInsuranceType(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
	hql = "from BaInsuranceType";
	} else {
	hql = "from BaInsuranceType where insuranceType like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<BaInsuranceType> getAllBaInsuranceType() throws DAOException {
	String hql = "";
	hql = "from BaInsuranceType";
	return super.getQueryResult(hql.toString());
 }
}
