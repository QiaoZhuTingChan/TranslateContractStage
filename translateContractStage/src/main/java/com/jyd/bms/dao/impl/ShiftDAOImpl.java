package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Shift;
import com.jyd.bms.dao.ShiftDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ShiftDAOImpl extends HibernateBaseTemplate<Shift> implements ShiftDAO {

	@Override
	public int getShiftCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Shift";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Shift where shiftType like :condition";
			Map<String, String> map = new HashMap<String, String>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@Override
	public List<Shift> getPagingShift(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		Map<String, String> map = new HashMap<String, String>();
		if (condition.equals("")) {
			hql = "from Shift";
		} else {
			hql = "from Shift where shiftType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@Override
	public List<Shift> getAllShift() throws DAOException {
		String hql = "";
		hql = "from Shift";
		return super.getQueryResult(hql.toString());
	}


	

}
