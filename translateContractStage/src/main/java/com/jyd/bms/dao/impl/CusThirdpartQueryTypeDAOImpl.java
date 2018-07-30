package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusThirdpartQueryType;
import com.jyd.bms.dao.CusThirdpartQueryTypeDAO;

/**
 * @category Generated 2018-04-20 10:34:54 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusThirdpartQueryTypeDAOImpl extends HibernateBaseTemplate<CusThirdpartQueryType>
		implements CusThirdpartQueryTypeDAO {

	@SuppressWarnings("unchecked")
	public int getCusThirdpartQueryTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusThirdpartQueryType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusThirdpartQueryType where type like :condition";
			Map<String, Object> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartQueryType> getPagingCusThirdpartQueryType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from CusThirdpartQueryType";
		} else {
			hql = "from CusThirdpartQueryType where type like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartQueryType> getAllCusThirdpartQueryType() throws DAOException {
		String hql = "";
		hql = "from CusThirdpartQueryType";
		return super.getQueryResult(hql.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusThirdpartQueryType> getCusThirdpartQueryTypeWhichStatusIsTrue() throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		hql.append(" from CusThirdpartQueryType where status =:status");
		map.put("status", true);
		
		
		return super.getQueryResult(hql.toString(), map);
	}
}
