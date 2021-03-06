package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.Fund;
import com.jyd.bms.dao.FundDAO;
/**
 * @category Generated 2018-05-25 14:04:37 by GeneratedTool
 * @author mjy
 */
@Repository
public class FundDAOImpl extends HibernateBaseTemplate<Fund> implements FundDAO {

 public int getFundCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from Fund";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from Fund where fundType like :condition";
	Map map = new HashMap();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 public List<Fund> getPagingFund(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
	hql = "from Fund";
	} else {
	hql = "from Fund where fundType like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<Fund> getAllFund() throws DAOException {
	String hql = "";
	hql = "from Fund";
	return super.getQueryResult(hql.toString());
 }
}
