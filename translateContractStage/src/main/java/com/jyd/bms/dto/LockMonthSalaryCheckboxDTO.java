package com.jyd.bms.dto;

import org.zkoss.zul.Checkbox;

import com.jyd.bms.bean.LockMonthSalary;

public class LockMonthSalaryCheckboxDTO {
	private Checkbox checkbox;
	private LockMonthSalary lockMonthSalary;
	
	public Checkbox getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(Checkbox checkbox) {
		this.checkbox = checkbox;
	}
	public LockMonthSalary getLockMonthSalary() {
		return lockMonthSalary;
	}
	public void setLockMonthSalary(LockMonthSalary lockMonthSalary) {
		this.lockMonthSalary = lockMonthSalary;
	}

}