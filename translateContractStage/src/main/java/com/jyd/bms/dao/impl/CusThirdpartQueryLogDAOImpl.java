package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusThirdpartQueryLog;
import com.jyd.bms.dao.CusThirdpartQueryLogDAO;
/**
 * @category Generated 2018-04-20 13:41:29 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusThirdpartQueryLogDAOImpl extends HibernateBaseTemplate<CusThirdpartQueryLog> implements CusThirdpartQueryLogDAO {

 @SuppressWarnings("unchecked")
public int getCusThirdpartQueryLogCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from CusThirdpartQueryLog";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from CusThirdpartQueryLog where baThirdpartQueryType.mark like :condition";
	Map<String, Object> map = new HashMap<>();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 @SuppressWarnings("unchecked")
public List<CusThirdpartQueryLog> getPagingCusThirdpartQueryLog(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map<String, Object> map = new HashMap<>();
	if (condition.equals("")) {
	hql = "from CusThirdpartQueryLog";
	} else {
	hql = "from CusThirdpartQueryLog where baThirdpartQueryType.mark like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 @SuppressWarnings("unchecked")
public List<CusThirdpartQueryLog> getAllCusThirdpartQueryLog() throws DAOException {
	String hql = "";
	hql = "from CusThirdpartQueryLog";
	return super.getQueryResult(hql.toString());
 }
}
