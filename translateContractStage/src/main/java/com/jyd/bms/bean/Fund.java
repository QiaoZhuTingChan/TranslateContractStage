package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @category Generated 2018-05-29 10:04:26 by GeneratedTool
 * @author mjy
 * 资金方
 */
@Entity
public class Fund implements Serializable {
	private int id;
	private String fundType;// 名称
	private String phone;// 手机
	private String userName;// 用户名
	private String userPass;// 密码
	private String remark;// 备注
	private String createUser;// 创建用户
	private String updateUser;// 修改用户
	private Timestamp createDate;// 创建日期
	private Timestamp updateDate;// 更新日期

	public String getFundType() {
		return fundType;
	}

	public String getPhone() {
		return phone;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public String getRemark() {
		return remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public int getId() {
		return id;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public void setId(int id) {
		this.id = id;
	}
}