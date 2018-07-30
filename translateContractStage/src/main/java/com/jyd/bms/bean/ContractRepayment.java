package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class ContractRepayment implements Serializable {
	private int id;
	private ContractStage stage; // 合同分期
	private String payment;// 转款人姓名
	private Double repaymentFee;// 金额
	private Date repaymentDate;// 日期
	private int state;// 状态
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private Double extraCharges;// 额外费用
	private Double capital;// 本金
	private Double lessStill;// 少还
	private Double muchMore;// 多还
	private Double interest;// 利息
	private Double damagesAmount;// 违约金
	private Double lateFee;// 逾期费
	private Set<CusContractRepaymentOtherFee> otherFees = new HashSet<CusContractRepaymentOtherFee>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getExtraCharges() {
		return extraCharges;
	}

	public void setExtraCharges(Double extraCharges) {
		this.extraCharges = extraCharges;
	}

	public ContractStage getStage() {
		return stage;
	}

	public void setStage(ContractStage stage) {
		this.stage = stage;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Double getRepaymentFee() {
		return repaymentFee;
	}

	public void setRepaymentFee(Double repaymentFee) {
		this.repaymentFee = repaymentFee;
	}

	public Date getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
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

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital = capital;
	}

	public Double getLessStill() {
		return lessStill;
	}

	public void setLessStill(Double lessStill) {
		this.lessStill = lessStill;
	}

	public Double getMuchMore() {
		return muchMore;
	}

	public void setMuchMore(Double muchMore) {
		this.muchMore = muchMore;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getDamagesAmount() {
		return damagesAmount;
	}

	public void setDamagesAmount(Double damagesAmount) {
		this.damagesAmount = damagesAmount;
	}

	public Double getLateFee() {
		return lateFee;
	}

	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}

	public Set<CusContractRepaymentOtherFee> getOtherFees() {
		return otherFees;
	}

	public void setOtherFees(Set<CusContractRepaymentOtherFee> otherFees) {
		this.otherFees = otherFees;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContractRepayment) {
			ContractRepayment person = (ContractRepayment) obj;
			return id == person.id;
		}
		return false;
	}

}
