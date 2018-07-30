package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.BaThirdpartCompany;
import com.jyd.bms.dao.BaThirdpartCompanyDAO;

/**
 * @category Generated 2018-05-16 15:56:12 by GeneratedTool
 * @author mjy
 */
@Repository
public class BaThirdpartCompanyDAOImpl extends HibernateBaseTemplate<BaThirdpartCompany>
		implements BaThirdpartCompanyDAO {

	@SuppressWarnings("unchecked")
	public int getBaThirdpartCompanyCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from BaThirdpartCompany";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from BaThirdpartCompany where name like :condition";
			Map<String, Object> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<BaThirdpartCompany> getPagingBaThirdpartCompany(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from BaThirdpartCompany";
		} else {
			hql = "from BaThirdpartCompany where name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<BaThirdpartCompany> getAllBaThirdpartCompany() throws DAOException {
		String hql = "";
		hql = "from BaThirdpartCompany";
		return super.getQueryResult(hql.toString());
	}
}
