package com.jyd.bms.dto;

/**
 * 付款申请书附加DTO
 * @author xiaozhi
 *
 */
public class PayApplySubDTO {
	private String loanBig;//借款金额大写
	private String moneyBig;//实际付款金额大写
	private double realPay;//实际付款金额
	private double returnPointMoney;//返点金额

	public String getLoanBig() {
		return loanBig;
	}

	public void setLoanBig(String loanBig) {
		this.loanBig = loanBig;
	}

	public double getRealPay() {
		return realPay;
	}

	public void setRealPay(double realPay) {
		this.realPay = realPay;
	}

	public String getMoneyBig() {
		return moneyBig;
	}

	public void setMoneyBig(String moneyBig) {
		this.moneyBig = moneyBig;
	}

	public double getReturnPointMoney() {
		return returnPointMoney;
	}

	public void setReturnPointMoney(double returnPointMoney) {
		this.returnPointMoney = returnPointMoney;
	}
}
