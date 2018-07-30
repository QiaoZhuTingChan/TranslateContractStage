package com.jyd.bms.bean;

import java.io.Serializable;

public class ParentDepartment implements Serializable {
	private int id;
	private Department department;
	private Department parentDepartment;
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
	public Department getParentDepartment() {
		return parentDepartment;
	}
	public void setParentDepartment(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
	}
	

}
