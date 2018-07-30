package com.jyd.bms.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.PageUseLog;
import com.jyd.bms.dao.PageUseLogDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class PageUseLogDAOImpl extends HibernateBaseTemplate<PageUseLog> implements PageUseLogDAO {

	@Override
	public int getPageUseLogCount(String condition, Timestamp begin, Timestamp end) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", end);
		if (condition.equals("")) {
			hql = "select count(*) from PageUseLog where createDate between :begin and :end ";
			List<Long> lstCount = super.getQueryResult(hql,map);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from PageUseLog where pageUrl like :condition and createDate between :begin and :end ";

			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@Override
	public List<PageUseLog> getPagingPageUseLog(int firstResult, int maxResults, String condition, Timestamp begin,
			Timestamp end) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", end);
		if (condition.equals("")) {
			hql = "from PageUseLog where createDate between :begin and :end ";
		} else {
			hql = "from PageUseLog where pageUrl like :condition and createDate between :begin and :end";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

}
