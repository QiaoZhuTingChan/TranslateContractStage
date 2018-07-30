package com.jyd.bms.dto;

import java.util.Date;

/*
 * 导出excel:员工薪资相关
 */
public class EmployeeSalaryDTO {

	private String name; // 姓名
	private String depatName; // 部门
	private String storeName; // 门店
	private String position; // 职位
	private Date entryDate; // 入职日期
	private Date obtainmentDate; // 转正日期

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepatName() {
		return depatName;
	}

	public void setDepatName(String depatName) {
		this.depatName = depatName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getObtainmentDate() {
		return obtainmentDate;
	}

	public void setObtainmentDate(Date obtainmentDate) {
		this.obtainmentDate = obtainmentDate;
	}

	public EmployeeSalaryDTO() {

	}

	public EmployeeSalaryDTO(String name, String depatName, String storeName,String position, Date entryDate,
			Date obtainmentDate) {
		this.name = name;
		this.depatName = depatName;
		this.storeName = storeName;
		this.position =  position;
        this.entryDate = entryDate;
        this.obtainmentDate = obtainmentDate;
	}
}
