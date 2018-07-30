package com.jyd.bms.dto;

/**
 * 付款申请书DTO
 * @author xiaozhi
 *
 */
public class PayApplyMainDTO {
	private String year;//年
	private String month;//月
	private String day;//日
	private String storeName;//门店名称
	private String createUser;//当前用户
	private double total;//小计
	private double realPay;//实际付款金额
	private String moneyBig;//实际付款人民币大写
	
	
	public double getRealPay() {
		return realPay;
	}
	public void setRealPay(double realPay) {
		this.realPay = realPay;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getMoneyBig() {
		return moneyBig;
	}
	public void setMoneyBig(String moneyBig) {
		this.moneyBig = moneyBig;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
}
