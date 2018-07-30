package com.jyd.bms.dto;

import org.zkoss.zul.Checkbox;
import com.jyd.bms.bean.ContractRepayment;
public class ContractRepaymentCheckbox {
	private Checkbox checkbox;
	private ContractRepayment contractRepayment;
	public Checkbox getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(Checkbox checkbox) {
		this.checkbox = checkbox;
	}
	public ContractRepayment getContractRepayment() {
		return contractRepayment;
	}
	public void setContractRepayment(ContractRepayment contractRepayment) {
		this.contractRepayment = contractRepayment;
	}
	
}
