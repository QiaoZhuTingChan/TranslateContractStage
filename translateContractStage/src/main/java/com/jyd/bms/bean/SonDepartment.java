package com.jyd.bms.bean;

import java.io.Serializable;

public class SonDepartment implements Serializable {
	private int id;
	private Department department;
	private Department sonDepartment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Department getSonDepartment() {
		return sonDepartment;
	}
	public void setSonDepartment(Department sonDepartment) {
		this.sonDepartment = sonDepartment;
	}
	

}
