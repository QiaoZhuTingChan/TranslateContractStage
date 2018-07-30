package com.jyd.bms.dao;

import java.util.Date;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Scheduling;
import com.jyd.bms.tool.exception.DAOException;

public interface SchedulingDAO extends HibernateBase<Scheduling> {
	public int findSchedulingCountByEmpAndDate(Employee emp,Date date) throws DAOException;
	
	public Scheduling findSchedulingByEmpAndDate(Employee emp,Date date) throws DAOException;

}
