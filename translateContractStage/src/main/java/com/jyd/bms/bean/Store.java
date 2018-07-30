package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
@Entity
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String shortName;
	private String number;
	private String registeredName;
	private String address;
	private String principal;
	private String province;
	private String city;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private String emailAddress;//邮件地址
	private Set<StoreLender> lenders=new HashSet<StoreLender>();
	private Set<StoreMortgager> mortgagers=new HashSet<StoreMortgager>();
	private Set<StoreRepaymentAccount> repayAccounts=new HashSet<StoreRepaymentAccount>();
	
	public Store() {}
	
	
	public Store(Integer id, String shortName, String number, String registeredName, String address, String principal,
			String province, String city, String remark, Timestamp createDate, Timestamp updateDate, String createUser,
			String updateUser,String emailAddress) {
		super();
		this.id = id;
		this.shortName = shortName;
		this.number = number;
		this.registeredName = registeredName;
		this.address = address;
		this.principal = principal;
		this.province = province;
		this.city = city;
		this.remark = remark;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.createUser = createUser;
		this.updateUser = updateUser;
		this.emailAddress = emailAddress;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRegisteredName() {
		return registeredName;
	}

	public void setRegisteredName(String registeredName) {
		this.registeredName = registeredName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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


	public Set<StoreLender> getLenders() {
		return lenders;
	}


	public void setLenders(Set<StoreLender> lenders) {
		this.lenders = lenders;
	}


	public Set<StoreMortgager> getMortgagers() {
		return mortgagers;
	}


	public void setMortgagers(Set<StoreMortgager> mortgagers) {
		this.mortgagers = mortgagers;
	}


	public Set<StoreRepaymentAccount> getRepayAccounts() {
		return repayAccounts;
	}


	public void setRepayAccounts(Set<StoreRepaymentAccount> repayAccounts) {
		this.repayAccounts = repayAccounts;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	@Override
	public String toString() {
		return "Store [id=" + id + ", shortName=" + shortName + ", number=" + number + ", registeredName="
				+ registeredName + ", address=" + address + ", principal=" + principal + ", province=" + province
				+ ", city=" + city + ", remark=" + remark + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", createUser=" + createUser + ", updateUser=" + updateUser + ", emailAddress=" + emailAddress
				+ ", lenders=" + lenders + ", mortgagers=" + mortgagers + ", repayAccounts=" + repayAccounts + "]";
	}

	
}
