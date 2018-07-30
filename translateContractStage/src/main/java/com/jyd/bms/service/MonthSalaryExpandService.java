package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.MonthSalary;
import com.jyd.bms.bean.MonthSalaryExpand;
import com.jyd.bms.dao.MonthSalaryExpandDAO;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DeleteException;

@Service("MonthSalaryExpandService")
public class MonthSalaryExpandService extends BaseService<MonthSalaryExpand>{

	@Autowired(required = true)
	private MonthSalaryExpandDAO monthSalaryExpandDAO;
	
	/**
	 * 查询个人月薪资明细
	 * 
	 * @param employee
	 *        员工
	 * @param yearMonth
	 *        年月
	 * @return
	 * @throws DAOException
	 */
	public MonthSalaryExpand getMonthSalaryExpand(Employee employee,String yearMonth) throws DAOException{
		return monthSalaryExpandDAO.getMonthSalaryExpand(employee, yearMonth);
	}
	
	/**
	 * 删除薪资明细表
	 * @param monthSalary
	 * @throws DeleteException
	 * @throws DAOException
	 */
	public void deleteAll(MonthSalary monthSalary) throws DeleteException, DAOException{
		monthSalaryExpandDAO.deleteAll(monthSalary);
	}
	
	public void calculateEmployee(Employee employee, String yearMonth) throws Exception {
		MonthSalary monthSalary = new MonthSalary();
	}
	
	public List<MonthSalaryExpand> getMonthSalaryExpandByMonthSalary(MonthSalary monthSalary) throws DAOException {
		return monthSalaryExpandDAO.getMonthSalaryExpandByMonthSalary(monthSalary);
	}
	@Override
	public void setDAO() {
		this.baseDAO = monthSalaryExpandDAO;
	}

	
}
