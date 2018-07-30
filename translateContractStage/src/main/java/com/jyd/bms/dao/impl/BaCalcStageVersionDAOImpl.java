package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.BaCalcStageVersion;
import com.jyd.bms.dao.BaCalcStageVersionDAO;
/**
 * @category Generated 2018-06-11 09:33:06 by GeneratedTool
 * @author mjy
 */
@Repository
public class BaCalcStageVersionDAOImpl extends HibernateBaseTemplate<BaCalcStageVersion> implements BaCalcStageVersionDAO {

 public int getBaCalcStageVersionCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from BaCalcStageVersion";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from BaCalcStageVersion where process like :condition";
	Map map = new HashMap();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 public List<BaCalcStageVersion> getPagingBaCalcStageVersion(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
	hql = "from BaCalcStageVersion";
	} else {
	hql = "from BaCalcStageVersion where process like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<BaCalcStageVersion> getAllBaCalcStageVersion() throws DAOException {
	String hql = "";
	hql = "from BaCalcStageVersion";
	return super.getQueryResult(hql.toString());
 }
}
