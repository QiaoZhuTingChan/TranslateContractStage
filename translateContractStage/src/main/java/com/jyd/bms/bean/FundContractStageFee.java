package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @category Generated 2018-05-28 18:21:23 by GeneratedTool
 * @author mjy
 * 资金方合同分期费用
 */
@Entity
public class FundContractStageFee implements Serializable {
	private int id;
	private double fee;// 其它费用
	private FundContractStage fundContractStageId;// 资金方分期
	private CostType costTypeId;// 费用类型
	private String remark;// 备注
	private String createUser;// 创建用户
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 修改时间
	private String updateUser;// 修改用户

	public FundContractStage getFundContractStageId() {
		return fundContractStageId;
	}

	public void setFundContractStageId(FundContractStage fundContractStageId) {
		this.fundContractStageId = fundContractStageId;
	}

	public CostType getCostTypeId() {
		return costTypeId;
	}

	public void setCostTypeId(CostType costTypeId) {
		this.costTypeId = costTypeId;
	}

	public double getFee() {
		return fee;
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

	public void setFee(double fee) {
		this.fee = fee;
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
}