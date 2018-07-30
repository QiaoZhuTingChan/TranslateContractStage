package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusThirdpartTongdunQueryLog;
import com.jyd.bms.dao.CusThirdpartTongdunQueryLogDAO;

/**
 * @category Generated 2018-05-02 09:34:37 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusThirdpartTongdunQueryLogDAOImpl extends HibernateBaseTemplate<CusThirdpartTongdunQueryLog>
		implements CusThirdpartTongdunQueryLogDAO {

	@SuppressWarnings("unchecked")
	public int getCusThirdpartTongdunQueryLogCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusThirdpartTongdunQueryLog";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusThirdpartTongdunQueryLog where queryTypeId like :condition";
			Map<String, Object> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartTongdunQueryLog> getPagingCusThirdpartTongdunQueryLog(int firstResult, int maxResults,
			String condition) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from CusThirdpartTongdunQueryLog";
		} else {
			hql = "from CusThirdpartTongdunQueryLog where queryTypeId like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartTongdunQueryLog> getAllCusThirdpartTongdunQueryLog() throws DAOException {
		String hql = "";
		hql = "from CusThirdpartTongdunQueryLog";
		return super.getQueryResult(hql.toString());
	}
}
