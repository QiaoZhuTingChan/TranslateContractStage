package com.jyd.bms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Scheduling;
import com.jyd.bms.dao.SchedulingDAO;
import com.jyd.bms.tool.exception.DAOException;


@Repository
public class SchedulingDAOImpl extends HibernateBaseTemplate<Scheduling> implements SchedulingDAO {

	public int findSchedulingCountByEmpAndDate(Employee emp,Date date) throws DAOException {
		String hql = "";
		hql = "select count(*) from Scheduling where employee=:emp and shiftDate=:date";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		map.put("date", date);
		List<Long> lstCount = super.getQueryResult(hql);
		return lstCount.get(0).intValue();
				
	}
	
	public Scheduling findSchedulingByEmpAndDate(Employee emp,Date date) throws DAOException {
		String hql = "";
		hql = "from Scheduling where employee=:emp and shiftDate=:date";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		map.put("date", date);
		return (Scheduling) super.getUniqueResult(hql, map);
	}

}
