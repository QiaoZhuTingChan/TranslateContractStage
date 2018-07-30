package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
@Entity
public class ProductUploadfile implements Serializable {
	private int id;
	private Product product;
	private UploadFileType uploadFileType;
	private WorkflowTypeFlow workflowTypeFlow;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UploadFileType getUploadFileType() {
		return uploadFileType;
	}

	public void setUploadFileType(UploadFileType uploadFileType) {
		this.uploadFileType = uploadFileType;
	}

	public WorkflowTypeFlow getWorkflowTypeFlow() {
		return workflowTypeFlow;
	}

	public void setWorkflowTypeFlow(WorkflowTypeFlow workflowTypeFlow) {
		this.workflowTypeFlow = workflowTypeFlow;
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

}