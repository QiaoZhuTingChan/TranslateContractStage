package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 基本薪资项目
 * @author ganpeng
 *
 */
public class BaseSalaryItem implements Serializable{
	private int id;
	private String baseSalaryItem;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	
	private Set<SalaryStructureBaseSalaryItem> alaryStructureBaseSalaryItems = new HashSet<>();
	
	
	public Set<SalaryStructureBaseSalaryItem> getAlaryStructureBaseSalaryItems() {
		return alaryStructureBaseSalaryItems;
	}
	public void setAlaryStructureBaseSalaryItems(Set<SalaryStructureBaseSalaryItem> alaryStructureBaseSalaryItems) {
		this.alaryStructureBaseSalaryItems = alaryStructureBaseSalaryItems;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBaseSalaryItem() {
		return baseSalaryItem;
	}
	public void setBaseSalaryItem(String baseSalaryItem) {
		this.baseSalaryItem = baseSalaryItem;
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
