package com.jyd.bms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.jyd.bms.tool.Des;

/**
 * 月薪资明细
 */
@Entity
public class MonthSalaryExpand implements Serializable {

	private int id;
	private MonthSalary monthSalary;// 每月薪资
	private String code;// 编号
	private double value; // 值
	private String stringValue; // 加密后的值
	private String formula;// 公式
	private Date createDate; // 创建时间

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MonthSalary getMonthSalary() {
		return monthSalary;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMonthSalary(MonthSalary monthSalary) {
		this.monthSalary = monthSalary;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
