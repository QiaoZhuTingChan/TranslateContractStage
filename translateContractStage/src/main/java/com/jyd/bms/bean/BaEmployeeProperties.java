package com.jyd.bms.bean;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 *用工属性
 */
@Entity
public class BaEmployeeProperties implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;//主键id
	private String employeeProperties;// 用工属性
	private String createUser;// 创建人
	private String updateUser;// 更新人
	private Timestamp createDate;// 创建日期
	private Timestamp updateDate;// 更新日期
	private String remark;// 备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeProperties() {
		return employeeProperties;
	}
	public void setEmployeeProperties(String employeeProperties) {
		this.employeeProperties = employeeProperties;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}