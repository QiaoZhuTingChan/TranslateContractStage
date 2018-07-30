package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.BaThirdpartQueryType;
import com.jyd.bms.dao.BaThirdpartQueryTypeDAO;

/**
 * @category Generated 2018-05-16 16:48:05 by GeneratedTool
 * @author mjy
 */
@Repository
public class BaThirdpartQueryTypeDAOImpl extends HibernateBaseTemplate<BaThirdpartQueryType>
		implements BaThirdpartQueryTypeDAO {

	@SuppressWarnings("unchecked")
	public int getBaThirdpartQueryTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from BaThirdpartQueryType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from BaThirdpartQueryType where baThirdpartCompany.name like :condition";
			Map<String, Object> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<BaThirdpartQueryType> getPagingBaThirdpartQueryType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from BaThirdpartQueryType";
		} else {
			hql = "from BaThirdpartQueryType where baThirdpartCompany.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<BaThirdpartQueryType> getAllBaThirdpartQueryType() throws DAOException {
		String hql = "";
		hql = "from BaThirdpartQueryType";
		return super.getQueryResult(hql.toString());
	}

	/**
	 * 查找第三方百融的所有开启的查询服务类型
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BaThirdpartQueryType> getBaThirdpartQueryTypeBelongToBairongCompany() throws DAOException {
		String hql = "";
		hql = "from BaThirdpartQueryType where baThirdpartCompany.id = 2 and status = true";
		return super.getQueryResult(hql);
	}
}
