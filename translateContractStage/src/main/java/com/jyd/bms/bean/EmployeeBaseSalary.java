package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import com.jyd.bms.tool.Des;

/**
 * 员工基本薪资项目
 * 
 * @author ganpeng
 *
 */
public class EmployeeBaseSalary implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Employee employee; // 员工
	private BaseSalaryItem baseSalaryItem; // 基本薪资项目
	private double value; // 值
	private String stringValue; // 加密后的值
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	
	
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
