package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.LockMonthSalary;
import com.jyd.bms.dao.LockMonthSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;

//每月薪资锁定

@Service("LockMonthSalaryService")
public class LockMonthSalaryService extends BaseService<LockMonthSalary>{
	@Autowired
	private LockMonthSalaryDAO lockMonthSalaryDAO;
	
	//获取所有月份
	public List<LockMonthSalary> getMonthAll(int year) throws DAOException {
		return lockMonthSalaryDAO.getMonthAll(year);
	}
	
	@Override
	public void setDAO() {
		this.baseDAO = lockMonthSalaryDAO;
	}

	
}