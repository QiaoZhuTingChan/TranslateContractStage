package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

public class ActualEvection implements Serializable {
	private int id;
	private Employee employee;
	private EvectionType evection;
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
	public EvectionType getEvection() {
		return evection;
	}
	public void setEvection(EvectionType evection) {
		this.evection = evection;
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
