package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.BaEmployeeProperties;
import com.jyd.bms.dao.BaEmployeePropertiesDAO;
/**
 * @category Generated 2018-05-09 17:15:16 by GeneratedTool
 * @author mjy
 */
@Repository
public class BaEmployeePropertiesDAOImpl extends HibernateBaseTemplate<BaEmployeeProperties> implements BaEmployeePropertiesDAO {

 public int getBaEmployeePropertiesCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
		hql = "select count(*) from BaEmployeeProperties";
		List<Long> lstCount = super.getQueryResult(hql);
		return lstCount.get(0).intValue();
	} else {
		hql = "select count(*) from BaEmployeeProperties where employeeProperties like :condition";
		Map map = new HashMap();
		map.put("condition", "%" + condition + "%");
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}
 }

 public List<BaEmployeeProperties> getPagingBaEmployeeProperties(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
		hql = "from BaEmployeeProperties";
	} else {
		hql = "from BaEmployeeProperties where employeeProperties like :condition";
		map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<BaEmployeeProperties> getAllBaEmployeeProperties() throws DAOException {
	String hql = "";
	hql = "from BaEmployeeProperties";
	return super.getQueryResult(hql.toString());
 }
}
