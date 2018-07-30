package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.jyd.bms.tool.Des;

/*
 * 每月薪资
 */
@Entity
public class MonthSalary implements Serializable {

	private int id;
	private String yearMonth;// yyyyMM
	private Employee employee;// 员工
	private double total; // 总薪资
	private String stringValue; // 加密后的值
	private String formula;// 公式
	private String remark; // 备注
	private Date createDate; // 创建时间
	private Date updateDate; // 修改时间
	private String createUser; // 创建人
	private String updateUser; // 修改人
	private boolean islock;// 是否锁定
	private String bankCode;// 银行账号
	private Date payDate;// 发薪日期 yyyy-MM-dd
	private Department department; // 部门
	private Store store; // 门店
	
	public String getStringValue() {
		try {
			stringValue = Des.get3DESEncrypt(total);
		} catch (Exception e) {
			stringValue = "";
		}
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
		try {
			total = Double.parseDouble(Des.get3DESDecrypt(stringValue));
		} catch (Exception e) {
			total = 0d;
		}
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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

	public boolean isIslock() {
		return islock;
	}

	public void setIslock(boolean islock) {
		this.islock = islock;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}
