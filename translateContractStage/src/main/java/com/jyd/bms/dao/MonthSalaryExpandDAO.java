package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.MonthSalary;
import com.jyd.bms.bean.MonthSalaryExpand;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DeleteException;

public interface MonthSalaryExpandDAO extends HibernateBase<MonthSalaryExpand> {

	/**
	 * 查询个人月薪资明细
	 * 
	 * @param employee
	 *            员工
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 */
	public MonthSalaryExpand getMonthSalaryExpand(Employee employee, String yearMonth) throws DAOException;

	/**
	 * 删除子表
	 * 
	 * @param id
	 * @throws DAOException
	 */
	public void deleteAll(MonthSalary monthSalary) throws DeleteException, DAOException;

	/**
	 * 
	 * @param monthSalary
	 * @return
	 * @throws DAOException
	 */
	public List<MonthSalaryExpand> getMonthSalaryExpandByMonthSalary(MonthSalary monthSalary) throws DAOException;
}
