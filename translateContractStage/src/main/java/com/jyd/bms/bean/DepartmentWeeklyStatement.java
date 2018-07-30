package com.jyd.bms.bean;

import java.util.Date;

public class DepartmentWeeklyStatement {
	private int id;
	private Department department;
	private Store store;
	private int year;
	private int weekNumber;
	private Date beginDate;
	private Date endDate;
	
	//总人数
	private int totalEmployee;
	//总编制数
	private int totalStaff;
	//总入职人数
	private int totalJoin;
	//总离职人数
	private int totalLeave;
	//总调职人数
	private int totalPromotion;
	//总调入人数
	private int tuningIn;
	//总调出人数
	private int tuningOut;
	//总调薪人数
	private int raiseASalary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getTotalEmployee() {
		return totalEmployee;
	}
	public void setTotalEmployee(int totalEmployee) {
		this.totalEmployee = totalEmployee;
	}
	public int getTotalStaff() {
		return totalStaff;
	}
	public void setTotalStaff(int totalStaff) {
		this.totalStaff = totalStaff;
	}
	public int getTotalJoin() {
		return totalJoin;
	}
	public void setTotalJoin(int totalJoin) {
		this.totalJoin = totalJoin;
	}
	public int getTotalLeave() {
		return totalLeave;
	}
	public void setTotalLeave(int totalLeave) {
		this.totalLeave = totalLeave;
	}
	public int getTotalPromotion() {
		return totalPromotion;
	}
	public void setTotalPromotion(int totalPromotion) {
		this.totalPromotion = totalPromotion;
	}
	public int getTuningIn() {
		return tuningIn;
	}
	public void setTuningIn(int tuningIn) {
		this.tuningIn = tuningIn;
	}
	public int getTuningOut() {
		return tuningOut;
	}
	public void setTuningOut(int tuningOut) {
		this.tuningOut = tuningOut;
	}
	public int getRaiseASalary() {
		return raiseASalary;
	}
	public void setRaiseASalary(int raiseASalary) {
		this.raiseASalary = raiseASalary;
	}
}
