package com.jyd.bms.dao;

import java.util.Date;
import java.util.List;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.DepartmentWeeklyStatement;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface DepartmentWeeklyStatementDAO extends HibernateBase<DepartmentWeeklyStatement> {
	public List<DepartmentWeeklyStatement> findDepartmentWeeklyStatementByDate(Store store,Date time) throws DAOException;
	
	public List<DepartmentWeeklyStatement> findDepartmentWeeklyStatementByDeptAndDate(Department dept,Date begin,Date end) throws DAOException;

}
