package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int papers;// 证件类型
	private Department department;
	private Department headDepartment;//所属总部部门
	private Employee director;
	private String name;
	private boolean sex;
	private String sexString;
	private PositionType position;
	private Date birthday;
	private String IDNo;
	private String bankName;// 开户行
	private String photo;
	private Date entryDate;
	private Date obtainmentDate;
	private boolean fertility;
	private String fertilityString;
	private String politicalStatus;
	private EducationType educationBackground;
	private String graduateSchool;
	private String major;
	private Date graduationDate;
	private Date workDate;
	private String nativePlace;
	private String householdRegistionPlace;
	private String currentAdress;
	private String contactInformation;
	private String email;
	private String bankCardNo;
	private String referees;
	private int state;
	private int shiftState;  //班次状态
	private Date leaveTime;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private Date effectiveDate;// 生效日期
	private BaEmployeeProperties employeeProperties;//用工属性
	private int formalType;//转正类型 0.按期1.提前2.延期
	private Set<Contract> contracts = new HashSet<Contract>();
	private Set<Contact> contacts = new HashSet<Contact>();
	private Set<WorkflowOptionalProcessor> workflowOptionalProcessors = new HashSet<WorkflowOptionalProcessor>();
	private Set<WorkExperience> experiences = new HashSet<WorkExperience>();
	private Set<EmployeeDuty> employeeDutys = new HashSet<EmployeeDuty>();
	private Set<EmployeeBaseSalary> salarys = new HashSet<EmployeeBaseSalary>();
	private Set<EmployeeSalary> salaryStructures = new HashSet<EmployeeSalary>();
	
	
	
	public int getFormalType() {
		return formalType;
	}

	public void setFormalType(int formalType) {
		this.formalType = formalType;
	}

	public Set<EmployeeSalary> getSalaryStructures() {
		return salaryStructures;
	}

	public void setSalaryStructures(Set<EmployeeSalary> salaryStructures) {
		this.salaryStructures = salaryStructures;
	}

	public BaEmployeeProperties getEmployeeProperties() {
		return employeeProperties;
	}

	public void setEmployeeProperties(BaEmployeeProperties employeeProperties) {
		this.employeeProperties = employeeProperties;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Set<WorkExperience> getExperiences() {
		return experiences;
	}

	public void setExperiences(Set<WorkExperience> experiences) {
		this.experiences = experiences;
	}

	public Employee() {
	}

	public int getPapers() {
		return papers;
	}

	public void setPapers(int papers) {
		this.papers = papers;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

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

	public Department getHeadDepartment() {
		return headDepartment;
	}

	public void setHeadDepartment(Department headDepartment) {
		this.headDepartment = headDepartment;
	}

	public Employee getDirector() {
		return director;
	}

	public void setDirector(Employee director) {
		this.director = director;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PositionType getPosition() {
		return position;
	}

	public void setPosition(PositionType position) {
		this.position = position;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIDNo() {
		return IDNo;
	}

	public void setIDNo(String iDNo) {
		IDNo = iDNo;
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

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getSexString() {
		return this.sex == true ? "男" : "女";
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isFertility() {
		return fertility;
	}

	public void setFertility(boolean fertility) {
		this.fertility = fertility;
	}

	public String getFertilityString() {
		return this.fertility == true ? "已婚" : "未婚";
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public EducationType getEducationBackground() {
		return educationBackground;
	}

	public void setEducationBackground(EducationType educationBackground) {
		this.educationBackground = educationBackground;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getHouseholdRegistionPlace() {
		return householdRegistionPlace;
	}

	public void setHouseholdRegistionPlace(String householdRegistionPlace) {
		this.householdRegistionPlace = householdRegistionPlace;
	}

	public String getCurrentAdress() {
		return currentAdress;
	}

	public void setCurrentAdress(String currentAdress) {
		this.currentAdress = currentAdress;
	}

	public int getShiftState() {
		return shiftState;
	}

	public void setShiftState(int shiftState) {
		this.shiftState = shiftState;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getReferees() {
		return referees;
	}

	public void setReferees(String referees) {
		this.referees = referees;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
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

	

	public void setSexString(String sexString) {
		this.sexString = sexString;
	}

	public Set<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}


	public Set<WorkflowOptionalProcessor> getWorkflowOptionalProcessors() {
		return workflowOptionalProcessors;
	}

	public void setWorkflowOptionalProcessors(Set<WorkflowOptionalProcessor> workflowOptionalProcessors) {
		this.workflowOptionalProcessors = workflowOptionalProcessors;
	}

	public void setFertilityString(String fertilityString) {
		this.fertilityString = fertilityString;
	}

	public Date getEffectivedate() {
		return effectiveDate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectiveDate = effectivedate;
	}

	public Set<EmployeeBaseSalary> getSalarys() {
		return salarys;
	}

	public void setSalarys(Set<EmployeeBaseSalary> salarys) {
		this.salarys = salarys;
	}

	public Set<EmployeeDuty> getEmployeeDutys() {
		return employeeDutys;
	}

	public void setEmployeeDutys(Set<EmployeeDuty> employeeDutys) {
		this.employeeDutys = employeeDutys;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", papers=" + papers + ", department=" + department + ", headDepartment="
				+ headDepartment + ", director=" + director + ", name=" + name + ", sex=" + sex + ", sexString="
				+ sexString + ", position=" + position + ", birthday=" + birthday + ", IDNo=" + IDNo + ", bankName="
				+ bankName + ", photo=" + photo + ", entryDate=" + entryDate + ", obtainmentDate=" + obtainmentDate
				+ ", fertility=" + fertility + ", fertilityString=" + fertilityString + ", politicalStatus="
				+ politicalStatus + ", educationBackground=" + educationBackground + ", graduateSchool="
				+ graduateSchool + ", major=" + major + ", graduationDate=" + graduationDate + ", workDate=" + workDate
				+ ", nativePlace=" + nativePlace + ", householdRegistionPlace=" + householdRegistionPlace
				+ ", currentAdress=" + currentAdress + ", contactInformation=" + contactInformation + ", email=" + email
				+ ", bankCardNo=" + bankCardNo + ", referees=" + referees + ", state=" + state + ", shiftState="
				+ shiftState + ", leaveTime=" + leaveTime + ", remark=" + remark + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", createUser=" + createUser + ", updateUser=" + updateUser
				+ ", effectiveDate=" + effectiveDate + ", contracts=" + contracts + ", contacts=" + contacts
				+ ", workflowOptionalProcessors=" + workflowOptionalProcessors + ", experiences=" + experiences
				+ ", employeeDutys=" + employeeDutys + ", salarys=" + salarys + "]";
	}	

}