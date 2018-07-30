package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * 临时记录部门的调用实体类
 * 
 * @author zyn
 *
 */
@Entity
public class TempRecordDpt implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;//ID
	private Employee employee;
	private Department oldDepartment;// 原来的部门
	private String rawDepartment;// 原来部门名称
	private Department newDepartment;// 临时的部门
	private String tempDepartment;// 临时部门名称
	private String transferCause;// 调用原因
	private Date effectiveDate;// 生效日期
	private Date createDate;
	private Date updateDate;
	private String createUser;
	private String updateUser;

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

	public Department getOldDepartment() {
		return oldDepartment;
	}

	public void setOldDepartment(Department oldDepartment) {
		this.oldDepartment = oldDepartment;
	}

	public String getRawDepartment() {
		return rawDepartment;
	}

	public void setRawDepartment(String rawDepartment) {
		this.rawDepartment = rawDepartment;
	}

	public Department getNewDepartment() {
		return newDepartment;
	}

	public void setNewDepartment(Department newDepartment) {
		this.newDepartment = newDepartment;
	}

	public String getTempDepartment() {
		return tempDepartment;
	}

	public void setTempDepartment(String tempDepartment) {
		this.tempDepartment = tempDepartment;
	}

	public String getTransferCause() {
		return transferCause;
	}

	public void setTransferCause(String transferCause) {
		this.transferCause = transferCause;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
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

}
