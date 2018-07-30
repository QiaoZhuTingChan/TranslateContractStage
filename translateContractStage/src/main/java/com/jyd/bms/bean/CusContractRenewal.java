package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

/**
 * @category Generated 2018-07-02 14:28:13 by GeneratedTool
 * @author mjy
 */
@Entity
public class CusContractRenewal implements Serializable {
	private int id;
	private CustomerContract contract;// 借款合同
	private Date startDate;// 开始时间
	private Date endDate;// 结束时间
	private int preStage;// 原先合同期数
	private Date preEndDate;// 原先合同结束时间
	private int stage;// 续期期数
	private String remark;// 备注
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 修改时间
	private String createUser;// 创建用户
	private String updateUser;// 修改用户

	public CustomerContract getContract() {
		return contract;
	}

	public void setContract(CustomerContract contract) {
		this.contract = contract;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public int getPreStage() {
		return preStage;
	}

	public Date getPreEndDate() {
		return preEndDate;
	}

	public int getStage() {
		return stage;
	}

	public String getRemark() {
		return remark;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public int getId() {
		return id;
	}

	

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setPreStage(int preStage) {
		this.preStage = preStage;
	}

	public void setPreEndDate(Date preEndDate) {
		this.preEndDate = preEndDate;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setId(int id) {
		this.id = id;
	}
}