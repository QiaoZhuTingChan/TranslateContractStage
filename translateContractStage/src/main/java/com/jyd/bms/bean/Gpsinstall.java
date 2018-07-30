package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Gpsinstall implements Serializable {
	private int id;
	private Store store;// 门店
	private Date installDate;// 安装日期
	private Employee installMaster;// 安装师傅
	private CustomerContract customerContract;// 合同
	private String carPlate;// 车牌号
	private String carModel;//品牌
	private String remark;
	private Date createDate;
	private Date updateDate;
	private String createUser;
	private String updateUser;
	private Set<GpsEquiment> gpsEquimentSet = new HashSet<GpsEquiment>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Date getInstallDate() {
		return installDate;
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

	public Employee getInstallMaster() {
		return installMaster;
	}

	public void setInstallMaster(Employee installMaster) {
		this.installMaster = installMaster;
	}

	public CustomerContract getCustomerContract() {
		return customerContract;
	}

	public void setCustomerContract(CustomerContract customerContract) {
		this.customerContract = customerContract;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
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

	public Set<GpsEquiment> getGpsEquimentSet() {
		return gpsEquimentSet;
	}

	public void setGpsEquimentSet(Set<GpsEquiment> gpsEquimentSet) {
		this.gpsEquimentSet = gpsEquimentSet;
	}

}
