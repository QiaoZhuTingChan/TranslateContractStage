package com.jyd.bms.bean;

import java.io.Serializable;

/**
 * 合同按日产生的逾期
 */
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ContractLateFee implements Serializable {
	private int id;
	private CustomerContract contract;
	private ContractStage contractStage;
	private Date overDueTime;
	private double unitTimeLateFee;
	private double totalLateFee;
	private String remark;
	private Date createDate;
	private Date updateDate;
	private String createUser;
	private String updateUser;
	private int state;

	public int getId() {
		return id;
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

	public ContractStage getContractStage() {
		return contractStage;
	}

	public void setContractStage(ContractStage contractStage) {
		this.contractStage = contractStage;
	}

	public Date getOverDueTime() {
		return overDueTime;
	}

	public void setOverDueTime(Date overDueTime) {
		this.overDueTime = overDueTime;
	}

	public double getUnitTimeLateFee() {
		return unitTimeLateFee;
	}

	public void setUnitTimeLateFee(double unitTimeLateFee) {
		this.unitTimeLateFee = unitTimeLateFee;
	}

	public double getTotalLateFee() {
		return totalLateFee;
	}

	public void setTotalLateFee(double totalLateFee) {
		this.totalLateFee = totalLateFee;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
