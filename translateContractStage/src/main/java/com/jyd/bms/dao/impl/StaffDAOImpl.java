package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Staff;
import com.jyd.bms.dao.StaffDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class StaffDAOImpl extends HibernateBaseTemplate<Staff> implements StaffDAO {

	public int getStaffCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Staff";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Staff,PositionType where Staff.positionId=PositionType.id and PositionType.positionType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<Staff> getPagingStaff(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Staff";
		} else {
			hql = "from Staff,PositionType where Staff.positionId=PositionType.id and PositionType.positionType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Staff> getAllStaff() throws DAOException {
		String hql = "";
		hql = "from Staff";
		return super.getQueryResult(hql.toString());

	}

	public List<Staff> getStaffByDept(Department condition) throws DAOException {
		String hql = "";
		hql = "from Staff where department = :condition";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		return super.getQueryResult(hql, map);

	}

	public Staff getStaffById(int condition) throws DAOException {
		String hql = "";
		hql = "from Staff where id = :condition";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		return (Staff) super.getUniqueResult(hql, map);
	}

	@Override
	public int getStaffSumByDept(Department dept) throws DAOException {
		String hql = "";
		hql = "select sum(nums) from Staff where department = :dept";
		Map map = new HashMap();
		map.put("dept", dept);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0) == null ? 0 : lstCount.get(0).intValue();
	}
}
