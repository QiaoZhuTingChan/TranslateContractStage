package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.sql.Timestamp;

/**
 * @category Generated 2018-05-28 18:03:56 by GeneratedTool
 * @author mjy 资金方合同分期
 */
@Entity
public class FundContractStage implements Serializable {
	private int id;
	private int stage;// 分期期数
	private FundContract fundContractId;// 资金方合同
	private double capital;// 本金
	private double interest;// 利息
	private double extraCharges;// 额外费用
	private Date repaymentDate;// 还款日期
	private int state;// 状态，0未还款，1已还款
	private String remark;// 备注
	private String createUser;// 创建用户
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 修改时间
	private String updateUser;// 修改用户

	public FundContract getFundContractId() {
		return fundContractId;
	}

	public void setFundContractId(FundContract fundContractId) {
		this.fundContractId = fundContractId;
	}

	public int getStage() {
		return stage;
	}

	public double getCapital() {
		return capital;
	}

	public double getInterest() {
		return interest;
	}

	public double getExtraCharges() {
		return extraCharges;
	}

	public Date getRepaymentDate() {
		return repaymentDate;
	}

	public int getState() {
		return state;
	}

	public String getRemark() {
		return remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public int getId() {
		return id;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public void setExtraCharges(double extraCharges) {
		this.extraCharges = extraCharges;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setId(int id) {
		this.id = id;
	}

	@SuppressWarnings("rawtypes")
	public static class ComparatorFundContractStage implements Comparator {
		public int compare(Object object1, Object object2) {
			FundContractStage stage1 = (FundContractStage) object1;
			FundContractStage stage2 = (FundContractStage) object2;
			int result = stage1.getId() - stage2.getId();
			if (result == 0) {
				result = stage1.getStage() - stage2.getStage();
			}
			return result;
		}
	}
}