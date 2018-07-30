package com.jyd.bms.dto;

import com.jyd.bms.bean.Employee;

public class EmployeeSalaryDataDTO {
	private int employeeId;
	private double value;

	public EmployeeSalaryDataDTO(int employeeId, double value) {
		this.employeeId = employeeId;
		this.value = value;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
