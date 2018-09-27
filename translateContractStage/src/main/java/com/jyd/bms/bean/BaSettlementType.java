package com.jyd.bms.bean;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
/**
 * @category Generated 2018-08-28 16:59:51 by GeneratedTool
 * @author mjy
 */
@Entity
public class BaSettlementType implements Serializable {
	private static final long serialVersionUID = 369865620902766469L;
	private int id;
	private String settlementType;// 结清类型
	private String remark;// 备注
	private Timestamp createDate;// 创建日期
	private String createUser;// 创建人
	private Timestamp updateDate;// 修改日期
	private String updateUser;// 修改人
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSettlementType() {
		return settlementType;
	}
	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
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
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}