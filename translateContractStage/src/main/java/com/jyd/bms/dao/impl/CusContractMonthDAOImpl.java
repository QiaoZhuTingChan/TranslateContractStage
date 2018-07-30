package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusContractMonth;
import com.jyd.bms.dao.CusContractMonthDAO;
/**
 * @category Generated 2018-05-16 16:26:22 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusContractMonthDAOImpl extends HibernateBaseTemplate<CusContractMonth> implements CusContractMonthDAO {

 public int getCusContractMonthCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from CusContractMonth";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from CusContractMonth where baMonthType like :condition";
	Map map = new HashMap();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 public List<CusContractMonth> getPagingCusContractMonth(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
	hql = "from CusContractMonth";
	} else {
	hql = "from CusContractMonth where baMonthType like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<CusContractMonth> getAllCusContractMonth() throws DAOException {
	String hql = "";
	hql = "from CusContractMonth";
	return super.getQueryResult(hql.toString());
 }
}
