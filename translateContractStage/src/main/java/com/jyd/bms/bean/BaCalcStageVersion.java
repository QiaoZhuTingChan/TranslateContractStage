package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @category Generated 2018-06-11 09:33:06 by GeneratedTool
 * @author mjy
 */
@Entity
public class BaCalcStageVersion implements Serializable {
	private int id;
	private String process;// 类名
	private String version;// 版本
	private Timestamp createDate;// 创建日期
	private Timestamp updateDate;// 更新日期
	private String createUser;// 创建人
	private String updateUser;// 更新人
	private String remark;//

	public String getProcess() {
		return process;
	}

	public String getVersion() {
		return version;
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

	public String getRemark() {
		return remark;
	}

	public int getId() {
		return id;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public void setVersion(String version) {
		this.version = version;
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

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setId(int id) {
		this.id = id;
	}
}