package com.jyd.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.EmployeeBaseSalaryHistory;
import com.jyd.bms.dao.EmployeeBaseSalaryHistoryDAO;

@Service("EmployeeBaseSalaryHistoryService")
public class EmployeeBaseSalaryHistoryService extends BaseService<EmployeeBaseSalaryHistory>{
	@Autowired
	private EmployeeBaseSalaryHistoryDAO employeeBaseSalaryHistoryDAO;
	
	
	
	public void setDAO() {
		this.baseDAO = employeeBaseSalaryHistoryDAO;
	}

}
