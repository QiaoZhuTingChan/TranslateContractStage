package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusContractMonthDetailed;
import com.jyd.bms.dao.CusContractMonthDetailedDAO;
/**
 * @category Generated 2018-05-16 16:29:37 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusContractMonthDetailedDAOImpl extends HibernateBaseTemplate<CusContractMonthDetailed> implements CusContractMonthDetailedDAO {

 public int getCusContractMonthDetailedCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from CusContractMonthDetailed";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from CusContractMonthDetailed where key like :condition";
	Map map = new HashMap();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 public List<CusContractMonthDetailed> getPagingCusContractMonthDetailed(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
	hql = "from CusContractMonthDetailed";
	} else {
	hql = "from CusContractMonthDetailed where key like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<CusContractMonthDetailed> getAllCusContractMonthDetailed() throws DAOException {
	String hql = "";
	hql = "from CusContractMonthDetailed";
	return super.getQueryResult(hql.toString());
 }
}
