package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @category Generated 2018-05-16 16:26:22 by GeneratedTool
 * @author mjy
 */
@Entity
public class CusContractMonth implements Serializable {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int baMonthType;

	// 月结类型 0:按人 1:按合同 2:按门店
	public int getBaMonthType() {
		return baMonthType;
	}

	public void setBaMonthType(int baMonthType) {
		this.baMonthType = baMonthType;
	}

	private int state;

	// 状态,0正常，1结束，-1审批中，2转逾期，3转账外资产
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private Date settlementMonth;

	// 结算时间
	public Date getSettlementMonth() {
		return settlementMonth;
	}

	public void setSettlementMonth(Date settlementMonth) {
		this.settlementMonth = settlementMonth;
	}

	private Date createDate;

	// 创建日期
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	private Date updateDate;

	// 修改时间
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	private String createUser;

	// 创建用户
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	private String updateUser;

	// 修改用户
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	private Set<CusContractMonthDetailed> cusContractMonthDetaileds = new HashSet<CusContractMonthDetailed>();

	public Set<CusContractMonthDetailed> getCusContractMonthDetaileds() {
		return cusContractMonthDetaileds;
	}

	public void setCusContractMonthDetaileds(Set<CusContractMonthDetailed> cusContractMonthDetaileds) {
		this.cusContractMonthDetaileds = cusContractMonthDetaileds;
	}

}