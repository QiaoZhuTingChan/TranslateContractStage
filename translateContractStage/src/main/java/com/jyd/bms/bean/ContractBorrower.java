package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * 共借人实体类
 * 
 * @author zyn
 *
 */
@Entity
public class ContractBorrower implements Serializable {
	private int id;// id
	private String name;// 名字
	private CustomerContract contract;// 合同
	private String address;// 地址
	private String idcar;// 身份证号
	private String borrowType;// 借款类型 个人-或-公司
	private String companyCode;// 公司注册码
	private String phone;// 联系人
	private Date createDate;
	private Date updateDate;
	private String createUser;
	private String updateUser;
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerContract getContract() {
		return contract;
	}

	public void setContract(CustomerContract contract) {
		this.contract = contract;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdcar() {
		return idcar;
	}

	public void setIdcar(String idcar) {
		this.idcar = idcar;
	}

	public String getBorrowType() {
		return borrowType;
	}

	public void setBorrowType(String borrowType) {
		this.borrowType = borrowType;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Borrower [id=" + id + ", name=" + name + ", contract=" + contract + ", address="
				+ address + ", idcar=" + idcar + ", borrowType=" + borrowType + ", companyCode=" + companyCode
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", createUser=" + createUser
				+ ", updateUser=" + updateUser + "]";
	}

}
