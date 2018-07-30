package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * @category Generated 2018-07-03 10:33:55 by GeneratedTool
 * @author mjy
 */
@Entity
public class CusContractRepaymentStage implements Serializable {
	private int id;
	private CustomerContract contract;// 合同
	private int serviceStageFee;// 服务费期数
	private double returnPointNum;// 返点数
	private Timestamp createDate;//
	private String createUser;//
	private Timestamp updateDate;//
	private String updateUser;//
	private String remark;//
	private RepaymentStage repaymentStage;// 分期
	private Product product;// 产品

	public int getServiceStageFee() {
		return serviceStageFee;
	}

	public double getReturnPointNum() {
		return returnPointNum;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public String getRemark() {
		return remark;
	}

	public int getId() {
		return id;
	}

	public void setServiceStageFee(int serviceStageFee) {
		this.serviceStageFee = serviceStageFee;
	}

	public void setReturnPointNum(double returnPointNum) {
		this.returnPointNum = returnPointNum;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerContract getContract() {
		return contract;
	}

	public void setContract(CustomerContract contract) {
		this.contract = contract;
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

}