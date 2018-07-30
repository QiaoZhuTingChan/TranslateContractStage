package com.jyd.bms.dto;

import org.zkoss.zul.Checkbox;

import com.jyd.bms.bean.FundContractStageRepayment;

public class FundContractStageRepaymentCheckbox {
	private Checkbox checkbox;
	private FundContractStageRepayment fundContractStageRepayment;
	public Checkbox getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(Checkbox checkbox) {
		this.checkbox = checkbox;
	}
	public FundContractStageRepayment getFundContractStageRepayment() {
		return fundContractStageRepayment;
	}
	public void setFundContractStageRepayment(FundContractStageRepayment fundContractStageRepayment) {
		this.fundContractStageRepayment = fundContractStageRepayment;
	}
	
}
