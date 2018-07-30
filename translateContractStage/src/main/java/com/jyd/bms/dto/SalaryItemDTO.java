package com.jyd.bms.dto;

import java.util.Date;

/*
 * 薪资结构导出excel
 */
public class SalaryItemDTO {

	private String code; // 编号 @aaa
	private String salaryItem; // 薪资项目
	private String salaryItemType; // 薪资项目类型
	private int operation; // 输入方式
	private int specialValue; // 特殊参数
	private String formuls;// 公式
	private int priority; // 计算优先级
	private String updateUser; // 最后更新用户
	private Date updateDate; // 最后更新时间
	private String option;// 对输入方式进行文字转换

	public String getOption() {
		return this.operation == 1 ? "系统计算" : "取数据";
	}

	public void setOption(String option) {
		this.option = (this.operation == 1 ? "系统计算" : "取数据");
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSalaryItem() {
		return salaryItem;
	}

	public void setSalaryItem(String salaryItem) {
		this.salaryItem = salaryItem;
	}

	public String getSalaryItemType() {
		return salaryItemType;
	}

	public void setSalaryItemType(String salaryItemType) {
		this.salaryItemType = salaryItemType;
	}

	public int getOperation() {

		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public int getSpecialValue() {
		return specialValue;
	}

	public void setSpecialValue(int specialValue) {
		this.specialValue = specialValue;
	}

	public String getFormuls() {
		return formuls;
	}

	public void setFormuls(String formuls) {
		this.formuls = formuls;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public SalaryItemDTO() {

	}

	public SalaryItemDTO(String code, String salaryItem, String salaryItemType, int operation, int specialValue,
			String formuls, int salaryItemPriority, String updateUser, Date updateDate) {
		this.code = code;
		this.salaryItem = salaryItem;
		this.salaryItemType = salaryItemType;
		this.operation = operation;
		this.specialValue = specialValue;
		this.formuls = formuls;
		this.priority = salaryItemPriority;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}

}
