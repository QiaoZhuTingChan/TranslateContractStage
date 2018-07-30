package com.jyd.bms.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * 第三方公司开启服务类型
 * 
 * @author aa
 *
 */
@Entity
public class BaThirdpartQueryType {
	private int id;
	private BaThirdpartCompany baThirdpartCompany;// 第三方公司
	private String type;// 查询服务类型
	private String mark;// 服务标识（第三方）
	private boolean status;// 是否启用状态：true，启用；fasle,不启用
	private double price;// 单价
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 修改时间
	private String createUser;// 创建者
	private String updateUser;// 修改者

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BaThirdpartCompany getBaThirdpartCompany() {
		return baThirdpartCompany;
	}

	public void setBaThirdpartCompany(BaThirdpartCompany baThirdpartCompany) {
		this.baThirdpartCompany = baThirdpartCompany;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

}