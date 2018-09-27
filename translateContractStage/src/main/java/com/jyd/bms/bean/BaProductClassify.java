package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @category Generated 2018-08-16 17:30:47 by GeneratedTool
 * @author mjy
 */
@Entity
public class BaProductClassify implements Serializable {
	private int id;
	private String productClassify;// 分类名称
	private Timestamp updateDate;//
	private String updateUser;//
	private String createUser;//
	private Timestamp createDate;//
	private String remark;//

	public String getProductClassify() {
		return productClassify;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public String getRemark() {
		return remark;
	}

	public int getId() {
		return id;
	}

	public void setProductClassify(String productClassify) {
		this.productClassify = productClassify;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setId(int id) {
		this.id = id;
	}
}