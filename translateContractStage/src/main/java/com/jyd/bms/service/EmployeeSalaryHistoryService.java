package com.jyd.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.EmployeeSalaryHistory;
import com.jyd.bms.dao.EmployeeSalaryHistoryDAO;

@Service("EmployeeSalaryHistoryService")
public class EmployeeSalaryHistoryService extends BaseService<EmployeeSalaryHistory>{

	@Autowired
	private EmployeeSalaryHistoryDAO employeeSalaryHistoryDAO;
	
	
	
	
	
	public void setDAO() {
		this.baseDAO = employeeSalaryHistoryDAO;
	}

}
