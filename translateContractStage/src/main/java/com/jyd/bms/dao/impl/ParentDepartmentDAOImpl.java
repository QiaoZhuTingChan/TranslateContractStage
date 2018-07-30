package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.ParentDepartment;
import com.jyd.bms.dao.ParentDepartmentDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ParentDepartmentDAOImpl extends HibernateBaseTemplate<ParentDepartment> implements ParentDepartmentDAO {
	
	public List<ParentDepartment> findParentDepartmentByDept(Department dept) throws DAOException {
		String hql = "";
		hql = "from ParentDepartment where department = :dept group by department,parentDepartment";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		return super.getQueryResult(hql, map);

	}
	
	public List<ParentDepartment> findParentDepartmentByDeptOrParentDept(Department dept) throws DAOException{
		String hql = "";
		hql = "from ParentDepartment where department = :dept or parentDepartment = :dept";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		return super.getQueryResult(hql, map);
	}

	@Override
	public List<ParentDepartment> getAllSubDepartment(List<Department> departmentList) throws DAOException {
		StringBuilder hql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();
		
		hql.append(" from ParentDepartment p where p.parentDepartment in (:departmentList)");
		map.put("departmentList", departmentList);
		
		List<ParentDepartment> list = super.getQueryResult(hql.toString(), map);
		return list.isEmpty() ? null : list;
	}
}
