package com.jyd.bms.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.GooutHomevisit;
import com.jyd.bms.bean.Gpsinstall;
import com.jyd.bms.dao.GpsinstallDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class GpsinstallDAOImpl extends HibernateBaseTemplate<Gpsinstall> implements GpsinstallDAO {

	public List<Gpsinstall> getAllGpsinstall() throws DAOException {
		String hql = "";
		hql = "from Gpsinstall";
		return super.getQueryResult(hql.toString());

	}

	public int getCountByCustomerContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "select count(*) from Gpsinstall where customerContract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	@Override
	public Gpsinstall getCountByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from Gpsinstall where customerContract = :contract order by id desc";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<Gpsinstall> list = new ArrayList<Gpsinstall>();
		list = super.getQueryResult(hql, map);
		if (list.isEmpty()) {
			return null;
		} else {
			return (Gpsinstall) list.get(0);
		}
	}

}
