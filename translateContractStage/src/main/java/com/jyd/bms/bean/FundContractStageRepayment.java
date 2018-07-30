package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

/**
 * @category Generated 2018-05-28 18:25:45 by GeneratedTool
 * @author mjy 资金方分期还款
 */
@Entity
public class FundContractStageRepayment implements Serializable {
	private int id;
	private FundContractStage fundContractStage;// 合同分期
	private double repaymentFee;// 还款金额
	private Date repaymentDate;// 还款日期
	private String remark;// 备注
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 修改时间
	private String createUser;// 创建用户
	private String updateUser;// 修改用户
	private String payment;// 还款人姓名
	private int state;// 类别:0正常，1逾期

	public FundContractStage getFundContractStage() {
		return fundContractStage;
	}

	public void setFundContractStage(FundContractStage fundContractStage) {
		this.fundContractStage = fundContractStage;
	}

	public double getRepaymentFee() {
		return repaymentFee;
	}

	public Date getRepaymentDate() {
		return repaymentDate;
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

	public String getPayment() {
		return payment;
	}

	public int getState() {
		return state;
	}

	public int getId() {
		return id;
	}

	public void setRepaymentFee(double repaymentFee) {
		this.repaymentFee = repaymentFee;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
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

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setId(int id) {
		this.id = id;
	}
}