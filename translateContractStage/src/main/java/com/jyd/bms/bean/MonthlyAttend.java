package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class MonthlyAttend implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;//主键id
	private EmpMonth empMonth;//员工月考勤
	private int attendType;//类型
	private int type;//子类型
	private double value;//值
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

	public EmpMonth getEmpMonth() {
		return empMonth;
	}

	public void setEmpMonth(EmpMonth empMonth) {
		this.empMonth = empMonth;
	}

	public int getAttendType() {
		return attendType;
	}

	public void setAttendType(int attendType) {
		this.attendType = attendType;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
