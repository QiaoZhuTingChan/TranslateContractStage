package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusThirdpartTongdunQueryType;
import com.jyd.bms.dao.CusThirdpartTongdunQueryTypeDAO;

/**
 * @category Generated 2018-05-02 09:35:24 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusThirdpartTongdunQueryTypeDAOImpl extends HibernateBaseTemplate<CusThirdpartTongdunQueryType>
		implements CusThirdpartTongdunQueryTypeDAO {

	@SuppressWarnings("unchecked")
	public int getCusThirdpartTongdunQueryTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusThirdpartTongdunQueryType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusThirdpartTongdunQueryType where type like :condition";
			Map<String, Object> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartTongdunQueryType> getPagingCusThirdpartTongdunQueryType(int firstResult, int maxResults,
			String condition) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from CusThirdpartTongdunQueryType";
		} else {
			hql = "from CusThirdpartTongdunQueryType where type like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartTongdunQueryType> getAllCusThirdpartTongdunQueryType() throws DAOException {
		String hql = "";
		hql = "from CusThirdpartTongdunQueryType";
		return super.getQueryResult(hql.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusThirdpartTongdunQueryType> getCusThirdpartTongdunQueryTypeWhichStatusIsTrue() throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		hql.append(" from CusThirdpartTongdunQueryType where status =:status");
		map.put("status", true);
		
		
		return super.getQueryResult(hql.toString(), map);
	}
}
