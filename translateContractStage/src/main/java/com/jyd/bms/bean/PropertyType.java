package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * @category 房产类型
 * @author mjy
 * @version v1
 */
@SuppressWarnings("serial")
@Entity
public class PropertyType implements Serializable {
	private int id;
	private String propertyType;
	private String remark;
	private Date createDate;
	private Date updateDate;
	private String createUser;
	private String updateUser;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
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

}
