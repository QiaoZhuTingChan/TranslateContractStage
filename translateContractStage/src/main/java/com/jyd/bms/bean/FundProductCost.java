package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @category Generated 2018-05-28 18:29:00 by GeneratedTool
 * @author mjy
 * 资金方产品费用
 */
@Entity
public class FundProductCost implements Serializable {
	private int id;
	private CostType costTypeId;// 产品费用类型
	private FundProduct fundProductId;// 资金方产品
	private String remark;// 备注
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 修改时间
	private String createUser;// 创建用户
	private String updateUser;// 修改用户
	private double value;// 产品费用

	public CostType getCostTypeId() {
		return costTypeId;
	}

	public void setCostTypeId(CostType costTypeId) {
		this.costTypeId = costTypeId;
	}

	public FundProduct getFundProductId() {
		return fundProductId;
	}

	public void setFundProductId(FundProduct fundProductId) {
		this.fundProductId = fundProductId;
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

	public double getValue() {
		return value;
	}

	public int getId() {
		return id;
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

	public void setValue(double value) {
		this.value = value;
	}

	public void setId(int id) {
		this.id = id;
	}
}