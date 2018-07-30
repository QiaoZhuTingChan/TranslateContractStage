package com.jyd.bms.bean;

import java.io.Serializable;

public class DailyAttend implements Serializable {
	private int id;
	private EmpDate empDate;
	private int attendType;
	private int type;
	private double value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmpDate getEmpDate() {
		return empDate;
	}

	public void setEmpDate(EmpDate empDate) {
		this.empDate = empDate;
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
