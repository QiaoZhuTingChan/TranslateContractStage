package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 员工薪资历史
 * @author ganpeng
 *
 */
public class EmployeeSalaryHistory implements Serializable{
	private int id;
	private Employee employee;
	private SalaryStructure salaryStructure;
	private Date effectiveDate;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	
	private Set<EmployeeBaseSalaryHistory> employeeBaseSalaryHistorys = new HashSet<>();
	
	public Set<EmployeeBaseSalaryHistory> getEmployeeBaseSalaryHistorys() {
		return employeeBaseSalaryHistorys;
	}
	public void setEmployeeBaseSalaryHistorys(Set<EmployeeBaseSalaryHistory> employeeBaseSalaryHistorys) {
		this.employeeBaseSalaryHistorys = employeeBaseSalaryHistorys;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public SalaryStructure getSalaryStructure() {
		return salaryStructure;
	}
	public void setSalaryStructure(SalaryStructure salaryStructure) {
		this.salaryStructure = salaryStructure;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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
