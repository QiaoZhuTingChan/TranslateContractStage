package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 薪资结构基本薪资项目
 * @author ganpeng
 *
 */
public class SalaryStructureBaseSalaryItem implements Serializable{
	private int id;
	private SalaryStructure salaryStructure;
	private BaseSalaryItem baseSalaryItem;
	private double defaultValue;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SalaryStructure getSalaryStructure() {
		return salaryStructure;
	}
	public void setSalaryStructure(SalaryStructure salaryStructure) {
		this.salaryStructure = salaryStructure;
	}
	public BaseSalaryItem getBaseSalaryItem() {
		return baseSalaryItem;
	}
	public void setBaseSalaryItem(BaseSalaryItem baseSalaryItem) {
		this.baseSalaryItem = baseSalaryItem;
	}
	public double getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(double defaultValue) {
		this.defaultValue = defaultValue;
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
}
