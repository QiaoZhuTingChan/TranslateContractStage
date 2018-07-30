package com.jyd.bms.dao;



import java.util.List;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.DepartmentMonthlyStatement;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface DepartmentMonthlyStatementDAO extends HibernateBase<DepartmentMonthlyStatement> {
	
	public List<DepartmentMonthlyStatement> findDepartmentMonthlyStatementByDate(Store store,String time) throws DAOException;
	
	public List<DepartmentMonthlyStatement> findDepartmentMonthlyStatementByDeptAndDate(Department dept,String beginTime,String endTime) throws DAOException;
	

}
