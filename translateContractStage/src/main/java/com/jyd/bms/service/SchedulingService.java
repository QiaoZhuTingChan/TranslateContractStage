package com.jyd.bms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Scheduling;
import com.jyd.bms.bean.Shift;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.EmployeeDAO;
import com.jyd.bms.dao.SchedulingDAO;
import com.jyd.bms.tool.exception.CreateException;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.UpdateException;

@Service("SchedulingService")
public class SchedulingService extends BaseService<Scheduling> {
	@Autowired(required = true)
	private SchedulingDAO schedulingDAO;
	@Autowired(required = true)
	private EmployeeDAO employeeDAO;
	
	//按员工排班
	public void doScheduling(Employee emp,Date date,Shift shift) throws CreateException, DAOException, UpdateException {
		if(schedulingDAO.findSchedulingCountByEmpAndDate(emp, date)==0) {
			Scheduling scheduling = new Scheduling();
			scheduling.setEmployee(emp);
			scheduling.setShift(shift);
			scheduling.setShiftDate(date);
			schedulingDAO.add(scheduling);
		}else {
			Scheduling scheduling = schedulingDAO.findSchedulingByEmpAndDate(emp, date);
			scheduling.setShift(shift);
			schedulingDAO.update(scheduling);
		}
	}
	
	//按部门排班
	public void doScheduling(Department dept,Date date,Shift shift) throws DAOException, CreateException, UpdateException {
		List<Employee> emps = employeeDAO.findEmpByStateAndShiftStateAndDept(dept);
		for(Employee emp : emps) {
			if(schedulingDAO.findSchedulingCountByEmpAndDate(emp, date)==0) {
				Scheduling scheduling = new Scheduling();
				scheduling.setEmployee(emp);
				scheduling.setShift(shift);
				scheduling.setShiftDate(date);
				schedulingDAO.add(scheduling);
			}else {
				Scheduling scheduling = schedulingDAO.findSchedulingByEmpAndDate(emp, date);
				scheduling.setShift(shift);
				schedulingDAO.update(scheduling);
			}
		}
		
	}
	
	//按门店排班
	public void doScheduling(Store store,Date date,Shift shift) throws DAOException, CreateException, UpdateException {
		List<Employee> emps = employeeDAO.findEmpByStateAndShiftStateAndStore(store);
		for(Employee emp : emps) {
			if(schedulingDAO.findSchedulingCountByEmpAndDate(emp, date)==0) {
				Scheduling scheduling = new Scheduling();
				scheduling.setEmployee(emp);
				scheduling.setShift(shift);
				scheduling.setShiftDate(date);
				schedulingDAO.add(scheduling);
			}else {
				Scheduling scheduling = schedulingDAO.findSchedulingByEmpAndDate(emp, date);
				scheduling.setShift(shift);
				schedulingDAO.update(scheduling);
			}
		}
	}

	@Override
	public void setDAO() {
		// TODO Auto-generated method stub
		this.baseDAO = schedulingDAO;
	}
	

}
