package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * @category 面审实体类
 * @author mjy
 * @version v1
 */
@Entity
public class ContractFaceTrialV1 implements Serializable{
	private int id; //主键Id
	private boolean marriageStatus;//婚姻状态
	private String householdAddress;//户籍地址
	private String estateCategory;//房产类别
	private String spouseName;//配偶姓名
	private String spousePhone;//配偶移动电话
	private String spouseIdNum;//配偶身份证
	private String workUnit;//工作单位
	private String unitNature;//单位性质
	private String industry;//所属行业
	private String position;//职业
	private double salary;//薪资
	private double otherIncome;//其他收入
	private String remark;//备注
	private Timestamp createDate;//创建时间
	private Timestamp updateDate;//更新时间
	private String createUser;//创建用户
	private String updateUser;//修改用户
	private String bankName;//银行名称
	private String bankIdcard;//银行卡号
	private CustomerContract customerContract;//合同
	private CustomerInfo customerInfo;//客户
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isMarriageStatus() {
		return marriageStatus;
	}
	public void setMarriageStatus(boolean marriageStatus) {
		this.marriageStatus = marriageStatus;
	}
	public String getHouseholdAddress() {
		return householdAddress;
	}
	public void setHouseholdAddress(String householdAddress) {
		this.householdAddress = householdAddress;
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
	public String getSpousePhone() {
		return spousePhone;
	}
	public void setSpousePhone(String spousePhone) {
		this.spousePhone = spousePhone;
	}
	public String getSpouseIdNum() {
		return spouseIdNum;
	}
	public void setSpouseIdNum(String spouseIdNum) {
		this.spouseIdNum = spouseIdNum;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getOtherIncome() {
		return otherIncome;
	}
	public void setOtherIncome(double otherIncome) {
		this.otherIncome = otherIncome;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankIdcard() {
		return bankIdcard;
	}
	public void setBankIdcard(String bankIdcard) {
		this.bankIdcard = bankIdcard;
	}
	public CustomerContract getCustomerContract() {
		return customerContract;
	}
	public void setCustomerContract(CustomerContract customerContract) {
		this.customerContract = customerContract;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	
}
