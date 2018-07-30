package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.ParentDepartment;
import com.jyd.bms.tool.exception.DAOException;

public interface ParentDepartmentDAO extends HibernateBase<ParentDepartment> {
	
	public List<ParentDepartment> findParentDepartmentByDept(Department dept) throws DAOException;
	
	public List<ParentDepartment> findParentDepartmentByDeptOrParentDept(Department dept) throws DAOException;

	public List<ParentDepartment> getAllSubDepartment(List<Department> departmentList)throws DAOException;


}
