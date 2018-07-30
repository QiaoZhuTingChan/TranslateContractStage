package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class CustomerInfo implements Serializable {
	private int id;
	private String name;
	private boolean sex;
	private Date birthday;
	private boolean maritalStatus;
	private String mobilePhone;
	private String idNum;
	private String bankName;// 银行名称
	private String bankCard;// 银行卡号
	private String householdRegistrationAddress;
	private EducationType educationalBackground;
	private boolean workType;// 新增职业性质
	private String companyAddress;// 新增公司地址
	private String email;
	private String qq;
	private String wechat;
	private String presentAddress;
	private String presentAddressPhone;
	private int initialResidenceTimeYear;
	private int initialResidenceTimeMonth;
	private int movedIntoYear;
	private int numOfDepentdent;
	private String estateCategory;
	private String spouseName;
	private String spousePhone;
	private String spouseIdNum;
	private Double rent;
	private String workUnit;
	private String unitNature;
	private String industry;
	private String position;
	private int initialServiceYear;
	private String unitAddress;
	private String unitPhone;
	private Double salary;
	private Double otherIncome;
	private Double monthTotalIncome;
	private String unitForm;
	private String legarRepresentative;
	private Double shares;
	private Date setUpTime;
	private boolean familyKnowTheLoan;
	private String holidayLeaveTheProvince;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private Set<ContactInfo> contacts = new HashSet<ContactInfo>();
	private Set<VehicleInfo> vehicles = new HashSet<VehicleInfo>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public boolean isWorkType() {
		return workType;
	}

	public void setWorkType(boolean workType) {
		this.workType = workType;
	}

	public void setFamilyKnowTheLoan(boolean familyKnowTheLoan) {
		this.familyKnowTheLoan = familyKnowTheLoan;
	}

	public String getHouseholdRegistrationAddress() {
		return householdRegistrationAddress;
	}

	public void setHouseholdRegistrationAddress(String householdRegistrationAddress) {
		this.householdRegistrationAddress = householdRegistrationAddress;
	}

	public EducationType getEducationalBackground() {
		return educationalBackground;
	}

	public void setEducationalBackground(EducationType educationalBackground) {
		this.educationalBackground = educationalBackground;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public int getInitialResidenceTimeYear() {
		return initialResidenceTimeYear;
	}

	public void setInitialResidenceTimeYear(int initialResidenceTimeYear) {
		this.initialResidenceTimeYear = initialResidenceTimeYear;
	}

	public int getInitialResidenceTimeMonth() {
		return initialResidenceTimeMonth;
	}

	public void setInitialResidenceTimeMonth(int initialResidenceTimeMonth) {
		this.initialResidenceTimeMonth = initialResidenceTimeMonth;
	}

	public int getMovedIntoYear() {
		return movedIntoYear;
	}

	public void setMovedIntoYear(int movedIntoYear) {
		this.movedIntoYear = movedIntoYear;
	}

	public int getNumOfDepentdent() {
		return numOfDepentdent;
	}

	public void setNumOfDepentdent(int numOfDepentdent) {
		this.numOfDepentdent = numOfDepentdent;
	}

	public String getEstateCategory() {
		return estateCategory;
	}

	public void setEstateCategory(String estateCategory) {
		this.estateCategory = estateCategory;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseIdNum() {
		return spouseIdNum;
	}

	public void setSpouseIdNum(String spouseIdNum) {
		this.spouseIdNum = spouseIdNum;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getUnitNature() {
		return unitNature;
	}

	public void setUnitNature(String unitNature) {
		this.unitNature = unitNature;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getInitialServiceYear() {
		return initialServiceYear;
	}

	public void setInitialServiceYear(int initialServiceYear) {
		this.initialServiceYear = initialServiceYear;
	}

	public String getUnitAddress() {
		return unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPresentAddressPhone() {
		return presentAddressPhone;
	}

	public void setPresentAddressPhone(String presentAddressPhone) {
		this.presentAddressPhone = presentAddressPhone;
	}

	public String getSpousePhone() {
		return spousePhone;
	}

	public void setSpousePhone(String spousePhone) {
		this.spousePhone = spousePhone;
	}

	public String getUnitPhone() {
		return unitPhone;
	}

	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(Double otherIncome) {
		this.otherIncome = otherIncome;
	}

	public Double getMonthTotalIncome() {
		return monthTotalIncome;
	}

	public void setMonthTotalIncome(Double monthTotalIncome) {
		this.monthTotalIncome = monthTotalIncome;
	}

	public String getUnitForm() {
		return unitForm;
	}

	public void setUnitForm(String unitForm) {
		this.unitForm = unitForm;
	}

	public String getLegarRepresentative() {
		return legarRepresentative;
	}

	public void setLegarRepresentative(String legarRepresentative) {
		this.legarRepresentative = legarRepresentative;
	}

	public Double getShares() {
		return shares;
	}

	public void setShares(Double shares) {
		this.shares = shares;
	}

	public Date getSetUpTime() {
		return setUpTime;
	}

	public void setSetUpTime(Date setUpTime) {
		this.setUpTime = setUpTime;
	}

	public Boolean getFamilyKnowTheLoan() {
		return familyKnowTheLoan;
	}

	public void setFamilyKnowTheLoan(Boolean familyKnowTheLoan) {
		this.familyKnowTheLoan = familyKnowTheLoan;
	}

	public String getHolidayLeaveTheProvince() {
		return holidayLeaveTheProvince;
	}

	public void setHolidayLeaveTheProvince(String holidayLeaveTheProvince) {
		this.holidayLeaveTheProvince = holidayLeaveTheProvince;
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

	public Set<ContactInfo> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactInfo> contacts) {
		this.contacts = contacts;
	}

	public Set<VehicleInfo> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<VehicleInfo> vehicles) {
		this.vehicles = vehicles;
	}

}
