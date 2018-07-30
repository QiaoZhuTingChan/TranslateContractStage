package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @category Generated 2018-03-19 09:50:17 by GeneratedTool
 * @author mjy
 */
@Entity
public class BaContractManageType implements Serializable {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String contractManageType;

	// 类别
	public String getContractManageType() {
		return contractManageType;
	}

	public void setContractManageType(String contractManageType) {
		this.contractManageType = contractManageType;
	}

	private String remark;

	// 备注
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private String createUser;

	// 创建用户
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	private String updateUser;

	// 更新用户
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	private Timestamp createDate;

	// 创建时间
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	private Timestamp updateDate;

	// 更新时间
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}