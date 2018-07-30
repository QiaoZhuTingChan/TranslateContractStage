package com.jyd.bms.bean;

import java.io.Serializable;

import com.jyd.bms.tool.Des;

/**
 * 员工基本薪资历史
 * 
 * @author ganpeng
 *
 */
public class EmployeeBaseSalaryHistory implements Serializable {
	private int id;
	private EmployeeSalaryHistory employeeSalaryHistory;
	private Employee employee; // 员工
	private BaseSalaryItem baseSalaryItem; // 基本薪资项目
	private double value; // 值
	private String stringValue; // 加密后的值

	public String getStringValue() {
		try {
			stringValue = Des.get3DESEncrypt(value);
		} catch (Exception e) {
			stringValue = "";
		}
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
		try {
			value = Double.parseDouble(Des.get3DESDecrypt(stringValue));
		} catch (Exception e) {
			value = 0d;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeSalaryHistory getEmployeeSalaryHistory() {
		return employeeSalaryHistory;
	}

	public void setEmployeeSalaryHistory(EmployeeSalaryHistory employeeSalaryHistory) {
		this.employeeSalaryHistory = employeeSalaryHistory;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public BaseSalaryItem getBaseSalaryItem() {
		return baseSalaryItem;
	}

	public void setBaseSalaryItem(BaseSalaryItem baseSalaryItem) {
		this.baseSalaryItem = baseSalaryItem;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
