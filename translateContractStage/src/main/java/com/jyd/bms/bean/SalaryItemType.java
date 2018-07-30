package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;

/**
 * 薪资项目类型
 * 
 * @author ganpeng
 *
 */
public class SalaryItemType implements Serializable {
	private int id;
	private String salaryItemType;
	private String remark;
	private int sortIndex;
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

	public String getSalaryItemType() {
		return salaryItemType;
	}

	public void setSalaryItemType(String salaryItemType) {
		this.salaryItemType = salaryItemType;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
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

	public static class ComparatorType implements Comparator {
		public int compare(Object o1, Object o2) {
			SalaryItemType stage1 = (SalaryItemType) o1;
			SalaryItemType stage2 = (SalaryItemType) o2;
			int result = stage1.getSortIndex() - stage2.getSortIndex();
			return result;
		}
	}
}
