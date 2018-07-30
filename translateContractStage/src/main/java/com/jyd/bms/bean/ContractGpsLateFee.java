package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * @category 合同GPS费用
 * @author mjy
 */
@SuppressWarnings("serial")
@Entity
public class ContractGpsLateFee implements Serializable {
	private int id;
	private ParkingFee parkingFee;
	private GpsCostType type;
	private double costValue;
	private String remark;
	private Date createDate;
	private Date updateDate;
	private String createUser;
	private String updateUser;
	private CustomerContract contract;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GpsCostType getType() {
		return type;
	}

	public void setType(GpsCostType type) {
		this.type = type;
	}

	public ParkingFee getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(ParkingFee parkingFee) {
		this.parkingFee = parkingFee;
	}

	public double getCostValue() {
		return costValue;
	}

	public void setCostValue(double costValue) {
		this.costValue = costValue;
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

	public CustomerContract getContract() {
		return contract;
	}

	public void setContract(CustomerContract contract) {
		this.contract = contract;
	}
}
