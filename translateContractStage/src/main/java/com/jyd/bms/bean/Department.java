package com.jyd.bms.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Employee deparmentSupervisor;// 主管
	private String departmentName;
	private int actualNums;
	private int totalActualNums;
	private int staffNums;
	private int totalStaffNums;
	private String remark;
	private Department parentDepartment;
	private Store store;
	private int state;
	private DepartmentType departmentType;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private Set<Staff> staffs = new HashSet<Staff>();
	private Set<Employee> employees = new HashSet<Employee>();

	public Department() {
	}

	public Department(Department dept) {
		this.id = dept.id;
		this.departmentName = dept.departmentName;
		this.deparmentSupervisor = dept.deparmentSupervisor;
		this.actualNums = dept.actualNums;
		this.totalActualNums = dept.totalActualNums;
		this.staffNums = dept.staffNums;
		this.totalStaffNums = dept.totalStaffNums;
		this.parentDepartment = dept.parentDepartment;
		this.store = dept.store;
		this.remark = dept.remark;
		this.createDate = dept.createDate;
		this.updateDate = dept.updateDate;
		this.createUser = dept.createUser;
		this.updateUser = dept.updateUser;
		this.staffs = dept.staffs;
		this.employees = dept.employees;
	}

	public Department(int id, String deptName, Employee deparmentSupervisor, int actualNums, int totalActualNums,
			int staffNums, int totalStaffNums, Department parentDepartment, Store store, String remark,
			Timestamp createDate, Timestamp updateDate, String createUser, String updateUser, Set<Staff> staffs,
			Set<Employee> emps) {
		super();
		this.id = id;
		this.departmentName = deptName;
		this.deparmentSupervisor = deparmentSupervisor;
		this.actualNums = actualNums;
		this.totalActualNums = totalActualNums;
		this.staffNums = staffNums;
		this.totalStaffNums = totalStaffNums;
		this.parentDepartment = parentDepartment;
		this.store = store;
		this.remark = remark;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.createUser = createUser;
		this.updateUser = updateUser;
		this.staffs = staffs;
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getDeparmentSupervisor() {
		return deparmentSupervisor;
	}

	public void setDeparmentSupervisor(Employee deparmentSupervisor) {
		this.deparmentSupervisor = deparmentSupervisor;
	}

	public int getActualNums() {
		return actualNums;
	}

	public void setActualNums(int actualNums) {
		this.actualNums = actualNums;
	}

	public int getTotalActualNums() {
		return totalActualNums;
	}

	public void setTotalActualNums(int totalActualNums) {
		this.totalActualNums = totalActualNums;
	}

	public int getStaffNums() {
		return staffNums;
	}

	public void setStaffNums(int staffNums) {
		this.staffNums = staffNums;
	}

	public int getTotalStaffNums() {
		return totalStaffNums;
	}

	public void setTotalStaffNums(int totalStaffNums) {
		this.totalStaffNums = totalStaffNums;
	}

	public Department getParentDepartment() {
		return parentDepartment;
	}

	public void setParentDepartment(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public DepartmentType getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(DepartmentType departmentType) {
		this.departmentType = departmentType;
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

	public Set<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Object deepCopy() throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeObject(this);

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

		ObjectInputStream ois = new ObjectInputStream(bis);

		return ois.readObject();
	}

}
