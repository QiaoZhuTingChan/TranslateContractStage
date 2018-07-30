package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.DutyType;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Gpsinstall;
import com.jyd.bms.bean.PositionType;
import com.jyd.bms.tool.exception.DAOException;

public interface GpsinstallDAO extends HibernateBase<Gpsinstall> {

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Gpsinstall> getAllGpsinstall() throws DAOException;
	
	public int getCountByCustomerContract(CustomerContract contract) throws DAOException;

	public Gpsinstall getCountByContract(CustomerContract contract) throws DAOException;
}
