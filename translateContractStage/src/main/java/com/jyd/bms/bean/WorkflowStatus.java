package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
@Entity
public class WorkflowStatus implements Serializable {
	private int id;
	private Workflow workflow;
	private String nodeName;
	private Form form;
	private String formData;
	private Flow flow;
	private Employee processEmployee;
	private boolean multiUserFlag;
	private boolean decision;
	private boolean decisionContent;
	private boolean distinctStore;
	private boolean entryDepartment;
	private boolean majorDepartment;
	private Timestamp arriveTime;
	private Timestamp beginTime;
	private Timestamp endTime;
	private String feedback;
	private int index;
	private int flowData;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private int processorStatus;
	private int tempStatus;
	private WorkflowTypeFlow wrokflowTypeFlow;
	private Set<WorkflowOptionalProcessor> workflowOptionalProcessors = new HashSet<WorkflowOptionalProcessor>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getFormData() {
		return formData;
	}

	public void setFormData(String formData) {
		this.formData = formData;
	}

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public Employee getProcessEmployee() {
		return processEmployee;
	}

	public void setProcessEmployee(Employee processEmployee) {
		this.processEmployee = processEmployee;
	}

	public boolean isMultiUserFlag() {
		return multiUserFlag;
	}

	public void setMultiUserFlag(boolean multiUserFlag) {
		this.multiUserFlag = multiUserFlag;
	}

	public boolean isDecision() {
		return decision;
	}

	public void setDecision(boolean decision) {
		this.decision = decision;
	}

	public boolean isDecisionContent() {
		return decisionContent;
	}

	public void setDecisionContent(boolean decisionContent) {
		this.decisionContent = decisionContent;
	}

	public boolean isDistinctStore() {
		return distinctStore;
	}

	public void setDistinctStore(boolean distinctStore) {
		this.distinctStore = distinctStore;
	}

	public boolean isEntryDepartment() {
		return entryDepartment;
	}

	public void setEntryDepartment(boolean entryDepartment) {
		this.entryDepartment = entryDepartment;
	}

	public boolean isMajorDepartment() {
		return majorDepartment;
	}

	public void setMajorDepartment(boolean majorDepartment) {
		this.majorDepartment = majorDepartment;
	}

	public Timestamp getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Timestamp arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Timestamp getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getFlowData() {
		return flowData;
	}

	public void setFlowData(int flowData) {
		this.flowData = flowData;
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

	public int getProcessorStatus() {
		return processorStatus;
	}

	public void setProcessorStatus(int processorStatus) {
		this.processorStatus = processorStatus;
	}

	public int getTempStatus() {
		return tempStatus;
	}

	public void setTempStatus(int tempStatus) {
		this.tempStatus = tempStatus;
	}

	public WorkflowTypeFlow getWrokflowTypeFlow() {
		return wrokflowTypeFlow;
	}

	public void setWrokflowTypeFlow(WorkflowTypeFlow wrokflowTypeFlow) {
		this.wrokflowTypeFlow = wrokflowTypeFlow;
	}

	public Set<WorkflowOptionalProcessor> getWorkflowOptionalProcessors() {
		return workflowOptionalProcessors;
	}

	public void setWorkflowOptionalProcessors(Set<WorkflowOptionalProcessor> workflowOptionalProcessors) {
		this.workflowOptionalProcessors = workflowOptionalProcessors;
	}

	

	
	
}
