package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.tool.exception.DAOException;

public interface StoreSalaryDAO extends HibernateBase<Store> {

	/**
	 * 获取门店下所有员工薪资
	 * 
	 * @param store
	 *            门店
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 */
	public List<Employee> getEmployeeByStoreAndYearmonth(Store store, String yearMonth) throws DAOException;
}