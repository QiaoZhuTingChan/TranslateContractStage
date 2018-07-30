package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;

import javax.persistence.Entity;
@Entity
public class WorkflowTypeFlow implements Serializable {
	private int id;
	private WorkflowType workflowType;
	private String workflowTypeName;
	private Form form;
	private Flow flow;
	private boolean need;
	private boolean decision;
	private boolean distinctStore;
	private boolean entryDept;
	private boolean majorDept;
	private int index;
	private int value;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	public String getWorkflowTypeName() {
		return workflowTypeName;
	}

	public void setWorkflowTypeName(String workflowTypeName) {
		this.workflowTypeName = workflowTypeName;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public boolean isNeed() {
		return need;
	}

	public void setNeed(boolean need) {
		this.need = need;
	}

	public boolean isDecision() {
		return decision;
	}

	public void setDecision(boolean decision) {
		this.decision = decision;
	}

	public boolean isDistinctStore() {
		return distinctStore;
	}

	public void setDistinctStore(boolean distinctStore) {
		this.distinctStore = distinctStore;
	}

	public boolean isEntryDept() {
		return entryDept;
	}

	public void setEntryDept(boolean entryDept) {
		this.entryDept = entryDept;
	}

	public boolean isMajorDept() {
		return majorDept;
	}

	public void setMajorDept(boolean majorDept) {
		this.majorDept = majorDept;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
	@SuppressWarnings("rawtypes")
	public static class ComparatorList implements Comparator{  
        public int compare(Object o1, Object o2) {  
        	WorkflowTypeFlow wf1 = (WorkflowTypeFlow) o1;  
        	WorkflowTypeFlow wf2 = (WorkflowTypeFlow) o2;  
        	 int result = wf1.getIndex() - wf2.getIndex();  
             if (result == 0) {  
            	 result = wf1.getIndex() - wf2.getIndex();    
             }  
             return result;  
        }  
    }  
}
