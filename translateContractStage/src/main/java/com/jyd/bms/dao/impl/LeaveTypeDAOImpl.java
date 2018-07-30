package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.EducationType;
import com.jyd.bms.bean.EvectionType;
import com.jyd.bms.bean.LeaveType;
import com.jyd.bms.dao.EducationTypeDAO;
import com.jyd.bms.dao.EvectionTypeDAO;
import com.jyd.bms.dao.LeaveTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class LeaveTypeDAOImpl extends HibernateBaseTemplate<LeaveType> implements LeaveTypeDAO {

	@Override
	public int getLeaveTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from LeaveType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from LeaveType where leaveType like :condition";
			Map<String, String> map = new HashMap<String, String>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@Override
	public List<LeaveType> getPagingLeaveType(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		Map<String, String> map = new HashMap<String, String>();
		if (condition.equals("")) {
			hql = "from LeaveType";
		} else {
			hql = "from LeaveType where leaveType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);

	}

	@Override
	public List<LeaveType> getAllLeaveType() throws DAOException {
		String hql = "";
		hql = "from LeaveType";
		return super.getQueryResult(hql.toString());
	}

	
}
