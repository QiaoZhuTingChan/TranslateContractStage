package com.jyd.bms.bean;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * @category Generated 2018-05-09 17:33:57 by GeneratedTool
 * @author mjy
 */
@Entity
public class BaSalaryLevel implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String salaryLevel;// 薪资级别
	private String remark;// 备注
	private String createUser;// 创建人
	private String updateUser;// 更新人
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 更新时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSalaryLevel() {
		return salaryLevel;
	}
	public void setSalaryLevel(String salaryLevel) {
		this.salaryLevel = salaryLevel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
}