package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.BaSalaryLevel;
import com.jyd.bms.dao.BaSalaryLevelDAO;
/**
 * @category Generated 2018-05-09 17:33:57 by GeneratedTool
 * @author mjy
 */
@Repository
public class BaSalaryLevelDAOImpl extends HibernateBaseTemplate<BaSalaryLevel> implements BaSalaryLevelDAO {

 public int getBaSalaryLevelCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
		hql = "select count(*) from BaSalaryLevel";
		List<Long> lstCount = super.getQueryResult(hql);
		return lstCount.get(0).intValue();
	} else {
		hql = "select count(*) from BaSalaryLevel where salaryLevel like :condition";
		Map map = new HashMap();
		map.put("condition", "%" + condition + "%");
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}
 }

 public List<BaSalaryLevel> getPagingBaSalaryLevel(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
		hql = "from BaSalaryLevel";
	} else {
		hql = "from BaSalaryLevel where salaryLevel like :condition";
		map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<BaSalaryLevel> getAllBaSalaryLevel() throws DAOException {
	String hql = "";
	hql = "from BaSalaryLevel";
	return super.getQueryResult(hql.toString());
 }
}
