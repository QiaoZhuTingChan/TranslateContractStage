package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
@Entity
public class ContractOverdueAmount implements Serializable {
	private int id;
	private CustomerContract contract;
	private double overdueAmount;
	private String collectionPeople;
	private double extraFee;
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
	public CustomerContract getContract() {
		return contract;
	}
	public void setContract(CustomerContract contract) {
		this.contract = contract;
	}
	public double getOverdueAmount() {
		return overdueAmount;
	}
	public void setOverdueAmount(double overdueAmount) {
		this.overdueAmount = overdueAmount;
	}
	public String getCollectionPeople() {
		return collectionPeople;
	}
	public void setCollectionPeople(String collectionPeople) {
		this.collectionPeople = collectionPeople;
	}
	public double getExtraFee() {
		return extraFee;
	}
	public void setExtraFee(double extraFee) {
		this.extraFee = extraFee;
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
