package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
/**
 * 薪资结构
 * @author ganpeng
 *
 */
public class SalaryStructure implements Serializable{
	private int id;
	private String salaryStructure;
	private String formula;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	
	private Set<SalaryStructureBaseSalaryItem> salaryStructureBaseSalaryItems = new HashSet<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSalaryStructure() {
		return salaryStructure;
	}
	public void setSalaryStructure(String salaryStructure) {
		this.salaryStructure = salaryStructure;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
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
	public Set<SalaryStructureBaseSalaryItem> getSalaryStructureBaseSalaryItems() {
		return salaryStructureBaseSalaryItems;
	}
	public void setSalaryStructureBaseSalaryItems(Set<SalaryStructureBaseSalaryItem> salaryStructureBaseSalaryItems) {
		this.salaryStructureBaseSalaryItems = salaryStructureBaseSalaryItems;
	}
	
}
