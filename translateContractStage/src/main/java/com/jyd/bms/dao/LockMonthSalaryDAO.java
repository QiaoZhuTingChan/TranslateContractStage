package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.LockMonthSalary;
import com.jyd.bms.tool.exception.DAOException;

//每月薪资锁定
public interface LockMonthSalaryDAO extends HibernateBase<LockMonthSalary>{

	public List<LockMonthSalary> getMonthAll(int year) throws DAOException;
	
}