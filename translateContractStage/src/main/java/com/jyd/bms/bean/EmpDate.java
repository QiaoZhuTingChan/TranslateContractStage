package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

public class EmpDate implements Serializable {
	private int id;
	private Employee employee;
	private Date attendDate;
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
	public Date getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
	}
	

}
