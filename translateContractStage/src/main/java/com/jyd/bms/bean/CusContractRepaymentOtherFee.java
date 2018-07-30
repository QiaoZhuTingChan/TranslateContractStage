package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * @category Generated 2018-06-22 14:06:07 by GeneratedTool
 * @author mjy
 */
@Entity
public class CusContractRepaymentOtherFee implements Serializable {
	private int id;
	private ContractRepayment repayment;// 合同分期
	private double defaultValue;// 应还
	private double value;// 实还
	private CostType costType;// 费用类型
	private String remark;//
	private Timestamp createDate;//
	private Timestamp updateDate;//
	private String createUser;//
	private String updateUser;//

	public ContractRepayment getRepayment() {
		return repayment;
	}

	public void setRepayment(ContractRepayment repayment) {
		this.repayment = repayment;
	}

	public double getDefaultValue() {
		return defaultValue;
	}

	public double getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public int getId() {
		return id;
	}

	public void setDefaultValue(double defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public CostType getCostType() {
		return costType;
	}

	public void setCostType(CostType costType) {
		this.costType = costType;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setId(int id) {
		this.id = id;
	}
}