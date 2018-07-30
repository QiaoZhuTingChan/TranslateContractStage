package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
@Entity
public class WorkflowType implements Serializable {
	private int id;
	private String workflowType;
	private WorkflowType parentWorkflowType;
	private boolean valid;
	private int type;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private Set<WorkflowTypeFlow> workflowTypeFlows;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(String workflowType) {
		this.workflowType = workflowType;
	}

	public WorkflowType getParentWorkflowType() {
		return parentWorkflowType;
	}

	public void setParentWorkflowType(WorkflowType parentWorkflowType) {
		this.parentWorkflowType = parentWorkflowType;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Set<WorkflowTypeFlow> getWorkflowTypeFlows() {
		return workflowTypeFlows;
	}

	public void setWorkflowTypeFlows(Set<WorkflowTypeFlow> workflowTypeFlows) {
		this.workflowTypeFlows = workflowTypeFlows;
	}
}
