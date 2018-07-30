package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Contact;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.GpsEquiment;
import com.jyd.bms.bean.Gpsinstall;
import com.jyd.bms.dao.GpsinstallLoctionDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class GpsinstallLoctionDAOImpl extends HibernateBaseTemplate<GpsEquiment> implements GpsinstallLoctionDAO {

	@Override
	public int getGpsinstallLoctionCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from GpsEquiment";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from GpsEquiment where GpsEquiment.equimentName like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@Override
	public List<GpsEquiment> getPagingGpsEquiment(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from GpsEquiment";
		} else {
			hql = "from GpsEquiment where GpsEquiment.equimentName like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@Override
	public List<GpsEquiment> getAllGpsEquiment() throws DAOException {
		String hql = "";
		hql = "from GpsEquiment";
		return super.getQueryResult(hql.toString());
	}

	@Override
	public List<GpsEquiment> getGpsEquimentByGpsinstall(Gpsinstall gpsinstall) throws DAOException {
		String hql = "";
		hql = "from GpsEquiment where gpsId = :gpsinstall";
		@SuppressWarnings("rawtypes")
		Map parameterMap = new HashMap();
		parameterMap.put("gpsinstall", gpsinstall);
		return super.getQueryResult(hql, parameterMap);
	}

}
