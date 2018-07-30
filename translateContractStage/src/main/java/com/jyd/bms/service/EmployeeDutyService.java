package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeDuty;
import com.jyd.bms.dao.EmployeeDutyDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("EmployeeDutyService")
public class EmployeeDutyService extends BaseService<EmployeeDuty> {
	@Autowired(required = true)
	private EmployeeDutyDAO employeeDutyDAO;

	public int getEmployeeDutyCount(String condition) throws DAOException {
		return employeeDutyDAO.getEmployeeDutyCount(condition);
	}

	public List<EmployeeDuty> getPagingEmployeeDuty(int firstResult, int maxResults, String condition)
			throws DAOException {
		return employeeDutyDAO.getPagingEmployeeDuty(firstResult, maxResults, condition);
	}

	public List<EmployeeDuty> getAllEmployeeDuty() throws DAOException {
		return employeeDutyDAO.getAllEmployeeDuty();
	}
	
	public List<EmployeeDuty> getEmployeeDutyByEmp(Employee emp) throws DAOException{
		return employeeDutyDAO.findEmployeeDutyByEmp(emp);
	}

	@Override
	public void setDAO() {
		this.baseDAO = employeeDutyDAO;
	}

}
