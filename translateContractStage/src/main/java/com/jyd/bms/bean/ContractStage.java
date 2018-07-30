package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class ContractStage implements Serializable {
	/**
	 * 合同分期表
	 */
	private int id;
	private int stage;// 期数
	private CustomerContract contract; // 合同
	private double capital;// 本金
	private double interest;// 利息
	private double extraCharges;// 额外费用
	private Date repaymentDate;// 还款日期
	private Date realrepaymentDate;// 实际还款日期
	private int state;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private Set<ContractRepayment> contractRepayments = new HashSet<ContractRepayment>();
	private Set<ContractStageFee> contractStageFees = new HashSet<ContractStageFee>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public CustomerContract getContract() {
		return contract;
	}

	public void setContract(CustomerContract contract) {
		this.contract = contract;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getExtraCharges() {
		return extraCharges;
	}

	public void setExtraCharges(double extraCharges) {
		this.extraCharges = extraCharges;
	}

	public Date getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public Date getRealrepaymentDate() {
		return realrepaymentDate;
	}

	public void setRealrepaymentDate(Date realrepaymentDate) {
		this.realrepaymentDate = realrepaymentDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

	public Set<ContractRepayment> getContractRepayments() {
		return contractRepayments;
	}

	public void setContractRepayments(Set<ContractRepayment> contractRepayments) {
		this.contractRepayments = contractRepayments;
	}

	public Set<ContractStageFee> getContractStageFees() {
		return contractStageFees;
	}

	public void setContractStageFees(Set<ContractStageFee> contractStageFees) {
		this.contractStageFees = contractStageFees;
	}

	@SuppressWarnings("rawtypes")
	public static class ComparatorContractStage implements Comparator {
		public int compare(Object o1, Object o2) {
			ContractStage stage1 = (ContractStage) o1;
			ContractStage stage2 = (ContractStage) o2;
			int result = stage1.getId() - stage2.getId();
			if (result == 0) {
				result = stage1.getStage() - stage2.getStage();
			}
			return result;
		}
	}

}
