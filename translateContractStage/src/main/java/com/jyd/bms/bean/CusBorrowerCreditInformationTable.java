package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 借款人信用信息表
 * @author aa
 *
 */
@Entity
public class CusBorrowerCreditInformationTable {
	private int id;
	private User user;// 业务员id
	private String name;// 客户姓名
	private String idcard;// 客户身份证
	private String phone;// 手机号码
	private String address;// 居住地址
	private String email;// 电子邮箱
	private String informationTableContent;// 填写信息表内容
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInformationTableContent() {
		return informationTableContent;
	}

	public void setInformationTableContent(String informationTableContent) {
		this.informationTableContent = informationTableContent;
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