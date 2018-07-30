package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

public class ActualLeave implements Serializable {
	private int id;
	private Employee employee;
	private LeaveType leave;
	private Date startTime;
	private Date endTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public LeaveType getLeave() {
		return leave;
	}
	public void setLeave(LeaveType leave) {
		this.leave = leave;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	

}
