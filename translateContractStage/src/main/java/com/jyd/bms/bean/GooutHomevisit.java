package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

/**
 * @category Generated 2018-04-08 10:47:36 by GeneratedTool
 * @author mjy
 */
@SuppressWarnings("serial")
@Entity
public class GooutHomevisit implements Serializable {
	private CustomerContract contract;

	public CustomerContract getContract() {
		return contract;
	}

	public void setContract(CustomerContract contract) {
		this.contract = contract;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String gooutthereason;

	// 外出原因
	public String getGooutthereason() {
		return gooutthereason;
	}

	public void setGooutthereason(String gooutthereason) {
		this.gooutthereason = gooutthereason;
	}

	private Date gooutStartdate;

	// 外出开始时间
	public Date getGooutStartdate() {
		return gooutStartdate;
	}

	public void setGooutStartdate(Date gooutStartdate) {
		this.gooutStartdate = gooutStartdate;
	}

	private Date gooutEnddate;

	// 外出结束时间
	public Date getGooutEnddate() {
		return gooutEnddate;
	}

	public void setGooutEnddate(Date gooutEnddate) {
		this.gooutEnddate = gooutEnddate;
	}

	private String presentAddress;

	// 现住地址
	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	private String propertyAddress;

	// 房产的地址
	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	private String managetPhony;

	// 房产的管理电话
	public String getManagetPhony() {
		return managetPhony;
	}

	public void setManagetPhony(String managetPhony) {
		this.managetPhony = managetPhony;
	}

	private String companyName;

	// 公司名称
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	private String companyAddress;

	// 公司地址
	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	private String companyManagerphony;

	// 公司管理处电话
	public String getCompanyManagerphony() {
		return companyManagerphony;
	}

	public void setCompanyManagerphony(String companyManagerphony) {
		this.companyManagerphony = companyManagerphony;
	}

	private String companyStatus;

	// 公司的规模跟状态
	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	private String comprehensiveEvaluation;

	// 综合评估
	public String getComprehensiveEvaluation() {
		return comprehensiveEvaluation;
	}

	public void setComprehensiveEvaluation(String comprehensiveEvaluation) {
		this.comprehensiveEvaluation = comprehensiveEvaluation;
	}

	private String assessmentLevel;

	// 评估等级
	public String getAssessmentLevel() {
		return assessmentLevel;
	}

	public void setAssessmentLevel(String assessmentLevel) {
		this.assessmentLevel = assessmentLevel;
	}

	private String createUser;

	// 创建用户
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	private Timestamp createDate;

	// 创建时间
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	private String updateUser;

	// 修改用户
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	private Timestamp updateDate;

	// 修改时间
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	private String remark;

	// 外出结果
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
