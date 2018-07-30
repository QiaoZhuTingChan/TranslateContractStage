package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;

/**
 * 薪资项目
 * 
 * @author ganpeng
 *
 */
public class SalaryItem implements Serializable {
	private int id;
	private String salaryItem;
	private SalaryItemType salaryItemType;
	private String formula;
	private int type; // '类型,0计算公式，1请假，2加班，3出差，4旷工，5迟到，6早退，7基本薪资项目，8手工录入项目，9保险',
	private int specialValue;
	private String code;
	private int sortIndex;
	private boolean state;
	private int operation;
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

	public String getSalaryItem() {
		return salaryItem;
	}

	public void setSalaryItem(String salaryItem) {
		this.salaryItem = salaryItem;
	}

	public SalaryItemType getSalaryItemType() {
		return salaryItemType;
	}

	public void setSalaryItemType(SalaryItemType salaryItemType) {
		this.salaryItemType = salaryItemType;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSpecialValue() {
		return specialValue;
	}

	public void setSpecialValue(int specialValue) {
		this.specialValue = specialValue;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
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
