package com.jyd.bms.dao.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.DepartmentWeeklyStatement;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.DepartmentWeeklyStatementDAO;
import com.jyd.bms.tool.exception.DAOException;


@Repository
public class DepartmentWeeklyStatementDAOImpl extends HibernateBaseTemplate<DepartmentWeeklyStatement> implements DepartmentWeeklyStatementDAO {

	public List<DepartmentWeeklyStatement> findDepartmentWeeklyStatementByDate(Store store,Date time) throws DAOException{
		String hql = "";
		hql = "from DepartmentWeeklyStatement where store = :store and endDate >= :time and beginDate <= :time order by endDate";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		map.put("time", time);
		return super.getQueryResult(hql, map);
	}
	
	public List<DepartmentWeeklyStatement> findDepartmentWeeklyStatementByDeptAndDate(Department dept,Date begin,Date end) throws DAOException{
		String hql = "";
		hql = "from DepartmentWeeklyStatement where department = :dept and endDate between :begin and :end order by endDate";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		map.put("begin", begin);
		map.put("end", end);
		return super.getQueryResult(hql, map);
	}

}
