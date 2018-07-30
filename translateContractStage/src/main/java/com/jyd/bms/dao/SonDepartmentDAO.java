package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.SonDepartment;
import com.jyd.bms.tool.exception.DAOException;

public interface SonDepartmentDAO extends HibernateBase<SonDepartment> {

	public List<SonDepartment> findSonDepartmentByDept(Department dept) throws DAOException;
	
	public List<SonDepartment> findSonDepartmentByDeptOrSonDept(Department dept) throws DAOException;
		
}
