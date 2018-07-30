package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.SonDepartment;
import com.jyd.bms.dao.SonDepartmentDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class SonDepartmentDAOImpl extends HibernateBaseTemplate<SonDepartment> implements SonDepartmentDAO {

	public List<SonDepartment> findSonDepartmentByDept(Department dept) throws DAOException {
		String hql = "";
		hql = "from SonDepartment where department = :dept group by department,sonDepartment";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		return super.getQueryResult(hql, map);
	}
	
	public List<SonDepartment> findSonDepartmentByDeptOrSonDept(Department dept) throws DAOException{
		String hql = "";
		hql = "from SonDepartment where department = :dept or sonDepartment = :dept";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		return super.getQueryResult(hql, map);
	}

}
