package com.jyd.bms.dto;

import java.util.Date;

/*
 * 导出ecxcel:部门下的员工
 */
public class EmployeeDTO {
	private String name; // 姓名
	private String depatName; // 部门
	private String storeName; // 门店
	private String sex; // 性别
	private String IDNo; // 身份证
	private String position; // 职位
	private Date birthday; // 出生日期
	private Date entryDate; // 入职日期
	private Date obtainmentDate; // 转正日期
	private String fertilityState; // 婚姻状态
	private String politicalStatus; // 政治面貌
	private String education; // 学历
	private String graduateSchool; // 毕业学校
	private String major; // 专业
	private Date graduationDate; // 毕业日期
	private Date workDate; // 参加工作时间
	private String nativePlace; // 籍贯
	private String householdRegistionPlace; // 户籍地址
	private String currentAdress; // 现地址
	private String contactInformation; // 联系方式
	private String email; // 邮件
	private String bankCardNo; // 银行卡号
	private String referees; // 推荐人
	private String remark; // 备注

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFertilityState() {
		return fertilityState;
	}

	public void setFertilityState(String fertilityState) {
		this.fertilityState = fertilityState;
	}

	public String getIDNo() {
		return IDNo;
	}

	public void setIDNo(String iDNo) {
		IDNo = iDNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDepatName() {
		return depatName;
	}

	public void setDepatName(String depatName) {
		this.depatName = depatName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeDTO() {

	}

	public EmployeeDTO(String name, String depatName, String storeName, String sex, String IDNo, String position,
			Date birthday, Date entryDate, Date obtainmentDate, String fertilityState, String politicalStatus,
			String education, String graduateSchool, String major, Date graduationDate, Date workDate,
			String nativePlace, String householdRegistionPlace, String currentAdress, String contactInformation,
			String email, String bankCardNo, String referees, String remark) {
		this.name = name;
		this.depatName = depatName;
		this.storeName = storeName;
		this.sex = sex;
		this.IDNo = IDNo;
		this.position = position;
		this.birthday = birthday;
		this.entryDate = entryDate;
		this.obtainmentDate = obtainmentDate;
		this.fertilityState = fertilityState;
		this.politicalStatus = politicalStatus;
		this.education = education;
		this.graduateSchool = graduateSchool;
		this.major = major;
		this.graduationDate = graduationDate;
		this.workDate = workDate;
		this.nativePlace = nativePlace;
		this.householdRegistionPlace = householdRegistionPlace;
		this.currentAdress = currentAdress;
		this.contactInformation = contactInformation;
		this.email = email;
		this.bankCardNo = bankCardNo;
		this.referees = referees;
		this.remark = remark;
	}
}