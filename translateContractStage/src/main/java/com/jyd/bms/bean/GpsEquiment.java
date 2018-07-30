package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * Gps的安装位置
 * 
 * @author zyn
 *
 */

@Entity
public class GpsEquiment implements Serializable {

	private int id;
	private Gpsinstall gpsId;//
	private String equimentName;// 设备编号
	private int equimentType;//０－表示有线设备　１－表示无线设备
	private String equimentLocton;// 设备安装位置
	private String remark;// 备注
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Gpsinstall getGpsId() {
		return gpsId;
	}

	public void setGpsId(Gpsinstall gpsId) {
		this.gpsId = gpsId;
	}

	public int getEquimentType() {
		return equimentType;
	}

	public void setEquimentType(int equimentType) {
		this.equimentType = equimentType;
	}

	public String getEquimentName() {
		return equimentName;
	}

	public void setEquimentName(String equimentName) {
		this.equimentName = equimentName;
	}

	public String getEquimentLocton() {
		return equimentLocton;
	}

	public void setEquimentLocton(String equimentLocton) {
		this.equimentLocton = equimentLocton;
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
