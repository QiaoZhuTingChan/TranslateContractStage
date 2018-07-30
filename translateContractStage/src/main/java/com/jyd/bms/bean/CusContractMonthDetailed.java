package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @category Generated 2018-05-16 16:29:37 by GeneratedTool
 * @author mjy
 */
@Entity
public class CusContractMonthDetailed implements Serializable {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String key;

	// 键
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private double value;

	// 值
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	private Date updateDate;

	// 修改时间
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	// 修改用户
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	private String name;

	// 键的描述
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private CusContractMonth cusContractMonth;

	public CusContractMonth getCusContractMonth() {
		return cusContractMonth;
	}

	public void setCusContractMonth(CusContractMonth cusContractMonth) {
		this.cusContractMonth = cusContractMonth;
	}

	// 合同月结外键

}