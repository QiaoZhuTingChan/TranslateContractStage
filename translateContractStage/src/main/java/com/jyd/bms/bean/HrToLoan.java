package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @category Generated 2018-03-22 18:56:34 by GeneratedTool
 * @author mjy
 */
@Entity
public class HrToLoan implements Serializable {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private String rawDepartment;

	// 原部门管
	public String getRawDepartment() {
		return rawDepartment;
	}

	public void setRawDepartment(String rawDepartment) {
		this.rawDepartment = rawDepartment;
	}

	private String tempDepartment;

	// 临时部门
	public String getTempDepartment() {
		return tempDepartment;
	}

	public void setTempDepartment(String tempDepartment) {
		this.tempDepartment = tempDepartment;
	}

	private String transferCause;

	// 调动原因
	public String getTransferCause() {
		return transferCause;
	}

	public void setTransferCause(String transferCause) {
		this.transferCause = transferCause;
	}

	private Date effectiveDate;

	// 生效日期

	private Timestamp createDate;

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	//
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	private Timestamp updateDate;

	//
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	private String createUser;

	//
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	private String updateUser;

	//
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}