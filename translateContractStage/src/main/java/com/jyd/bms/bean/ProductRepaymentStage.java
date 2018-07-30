package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * 产品分期
 *
 */
@Entity
public class ProductRepaymentStage implements Serializable {
	private int id;
	private RepaymentStage repaymentStage;
	private Product product;
	private String remark;

	private int serviceFeeStage;// 服务费期数
	private double returnPointNum;//返点数
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;

	
	public double getReturnPointNum() {
		return returnPointNum;
	}

	public void setReturnPointNum(double returnPointNum) {
		this.returnPointNum = returnPointNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getServiceFeeStage() {
		return serviceFeeStage;
	}

	public void setServiceFeeStage(int serviceFeeStage) {
		this.serviceFeeStage = serviceFeeStage;
	}

	public RepaymentStage getRepaymentStage() {
		return repaymentStage;
	}

	public void setRepaymentStage(RepaymentStage repaymentStage) {
		this.repaymentStage = repaymentStage;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
