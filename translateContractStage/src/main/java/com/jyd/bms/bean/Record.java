package com.jyd.bms.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * 记录表实体类
 * 
 */
@Entity
public class Record {
	private int id;// 主键id
	private CustomerContract customerContract;// 合同
	private Employee employee;// 员工
	private String remark;// 备注
	private String createUser;// 创建人
	private String updateUser;// 更新人
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 更新时间
	private WorkflowStatus WorkflowStatus;// 流程

	public Record() {
	}
	/**
	 * @category 查询合同数据
	 * @param customerContract
	 */
	public Record(CustomerContract customerContract) {
		this.customerContract = customerContract;
	}

	public WorkflowStatus getWorkflowStatus() {
		return WorkflowStatus;
	}

	public void setWorkflowStatus(WorkflowStatus workflowStatus) {
		WorkflowStatus = workflowStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerContract getCustomerContract() {
		return customerContract;
	}

	public void setCustomerContract(CustomerContract customerContract) {
		this.customerContract = customerContract;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

}
