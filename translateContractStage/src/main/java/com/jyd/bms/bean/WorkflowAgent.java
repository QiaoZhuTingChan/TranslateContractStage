package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class WorkflowAgent implements Serializable {
	private int id;
	private Employee processEmployee;
	private Employee agentEmployee;
	private Date beginTime;
	private Date endTime;
	private Date createDate;
	private Date updateDate;
	private String createUser;
	private String updateUser;
	private WorkflowType workflowType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getProcessEmployee() {
		return processEmployee;
	}

	public void setProcessEmployee(Employee processEmployee) {
		this.processEmployee = processEmployee;
	}

	public Employee getAgentEmployee() {
		return agentEmployee;
	}

	public void setAgentEmployee(Employee agentEmployee) {
		this.agentEmployee = agentEmployee;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
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
