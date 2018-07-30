package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class EmpMonth implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;//主键id
	private Employee employee;//员工
	private String attendMonth;//考勤月
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
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
	public String getAttendMonth() {
		return attendMonth;
	}
	public void setAttendMonth(String attendMonth) {
		this.attendMonth = attendMonth;
	}
	

}
