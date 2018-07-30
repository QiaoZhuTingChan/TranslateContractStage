package com.jyd.bms.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.DepartmentMonthlyStatement;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.DepartmentMonthlyStatementDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class DepartmentMonthlyStatementDAOImpl extends HibernateBaseTemplate<DepartmentMonthlyStatement> implements DepartmentMonthlyStatementDAO {
		
	
	public List<DepartmentMonthlyStatement> findDepartmentMonthlyStatementByDate(Store store,String time) throws DAOException{
		String hql = "";
		hql = "from DepartmentMonthlyStatement where store = :store and yearMonth = :time order by yearMonth";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		map.put("time", time);
		//map.put("endTime", endTime);
		return super.getQueryResult(hql, map);
	}
	
	public List<DepartmentMonthlyStatement> findDepartmentMonthlyStatementByDeptAndDate(Department dept,String beginTime,String endTime) throws DAOException{
		String hql = "";
		hql = "from DepartmentMonthlyStatement where department = :dept and yearMonth between :beginTime and :endTime order by yearMonth";
		Map map = new HashMap();
		map.put("dept", dept);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		return super.getQueryResult(hql, map);
	}

}
