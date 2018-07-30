package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.jyd.bms.tool.Des;

/**
 * 保险
 * 
 * @author ganpeng
 *
 */
public class Insurance implements Serializable {
	private int id;
	private InsuranceType insuranceType; // 保险类型
	private Employee employee; // 员工
	private Date beginDate; // 开始时间
	private Date endDate; // 结束时间
	private int valid; // 是否生效
	private String remark; // 备注
	private Timestamp createDate; // 创建时间
	private Timestamp updateDate; // 修改时间
	private String createUser; // 创建人
	private String updateUser; // 修改人
	private double value; // 值
	private String stringValue; // 加密后的值

	public String getStringValue() {
		try {
			stringValue = Des.get3DESEncrypt(value);
		} catch (Exception e) {
			stringValue = "";
		}
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
		try {
			value = Double.parseDouble(Des.get3DESDecrypt(stringValue));
		} catch (Exception e) {
			value = 0d;
		}
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
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
