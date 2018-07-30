package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ContractFaceTrial implements Serializable{
	private int id;
	private CustomerContract customerContract;	//合同 
	private String companyBussiness;			//	主营业务及上下游合作企业
	private double monthSaleroom;				//	月销售额
	private double machine;						//	设备
	private double grossProfitRate;				//	毛利率
	private double storeMaterial;				//	库存及材料
	private double employeeWage;				//	工资
	private int totalEmployee;					//	员工人数
	private double accountReceivable;			//	应收款
	private double accountPayable;				//	应付款
	private double placeRental;					//	场地租金
	private double placeArea;					//	场地面积
	private double otherCharge;					//	其他费用
	private double profit;						//	盈利情况
	private String companyNature;				//	单位性质
	private String companyScale;				//	单位规模
	private String industry;					//	所属行业
	private String department;					//	所在部门
	private String position;					//	当前职位
	private String duty;						//	工作内容
	private double salary;						//	每月薪金
	private double otherEarning;				//	其它收入
	private Date joinDate;						//	入职时间
	private int salaryDate;						//	每月支薪日
	private String childRemark;					//	小孩情况
	private String mateRemark;					//	配偶工作情况
	private String personalRemark;				//	个人工作经历
	private double housePropertyOne;			//	房产1市价
	private double houseAreaOne;				//	面积
	private double houseOneAmountInArear;		//	欠款金额
	private double housePropertyTwo;			//	房产2市价
	private double houseAreaTwo;				//	面积
	private double houseTwoAmountInArear;		//	欠款金额
	private String carBrandOne;					//	车产1品牌
	private double carMarketPriceOne;			//	市场价
	private double carOneAmountInArear;			//	欠款金额
	private String carBrandTwo;					//	车产2品牌
	private double carMarketPriceTwo;			//	市场价
	private double carTwoAmountInArear;			//	欠款金额
	private String creditCardBankNameOne;		//	信用卡1发卡行
	private double limitOne;					//	最高额度
	private double creditCardOneAmountInArear;	//	欠款金额
	private String creditCardBankNameTwo;		//	信用卡1发卡行
	private double limitTwo;					//	最高额度
	private double creditCardTwoAmountInArear;	//	欠款金额
	private double totalLimit;					//	信用卡总额度
	private double totalAmountInArear;			//	信用卡总欠款
	private String homeVisitCheck;				//	家访核查点
	private Date mortgageRepayDate;				//	按揭还款日
	private Date mortgageMaturityDate;			//	按揭到期日
	private PropertyType propertyOne;			//	房产1
	private PropertyType propertyTwo;			//	房产2
	private String remark;						// 	备注
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getMortgageRepayDate() {
		return mortgageRepayDate;
	}
	public void setMortgageRepayDate(Date mortgageRepayDate) {
		this.mortgageRepayDate = mortgageRepayDate;
	}
	public Date getMortgageMaturityDate() {
		return mortgageMaturityDate;
	}
	public void setMortgageMaturityDate(Date mortgageMaturityDate) {
		this.mortgageMaturityDate = mortgageMaturityDate;
	}
	public PropertyType getPropertyOne() {
		return propertyOne;
	}
	public void setPropertyOne(PropertyType propertyOne) {
		this.propertyOne = propertyOne;
	}
	public PropertyType getPropertyTwo() {
		return propertyTwo;
	}
	public void setPropertyTwo(PropertyType propertyTwo) {
		this.propertyTwo = propertyTwo;
	}
	public CustomerContract getCustomerContract() {
		return customerContract;
	}
	public void setCustomerContract(CustomerContract customerContract) {
		this.customerContract = customerContract;
	}
	public String getCompanyBussiness() {
		return companyBussiness;
	}
	public void setCompanyBussiness(String companyBussiness) {
		this.companyBussiness = companyBussiness;
	}
	public double getMonthSaleroom() {
		return monthSaleroom;
	}
	public void setMonthSaleroom(double monthSaleroom) {
		this.monthSaleroom = monthSaleroom;
	}
	public double getMachine() {
		return machine;
	}
	public void setMachine(double machine) {
		this.machine = machine;
	}
	public double getGrossProfitRate() {
		return grossProfitRate;
	}
	public void setGrossProfitRate(double grossProfitRate) {
		this.grossProfitRate = grossProfitRate;
	}
	public double getStoreMaterial() {
		return storeMaterial;
	}
	public void setStoreMaterial(double storeMaterial) {
		this.storeMaterial = storeMaterial;
	}
	public double getEmployeeWage() {
		return employeeWage;
	}
	public void setEmployeeWage(double employeeWage) {
		this.employeeWage = employeeWage;
	}
	public int getTotalEmployee() {
		return totalEmployee;
	}
	public void setTotalEmployee(int totalEmployee) {
		this.totalEmployee = totalEmployee;
	}
	public double getAccountReceivable() {
		return accountReceivable;
	}
	public void setAccountReceivable(double accountReceivable) {
		this.accountReceivable = accountReceivable;
	}
	public double getAccountPayable() {
		return accountPayable;
	}
	public void setAccountPayable(double accountPayable) {
		this.accountPayable = accountPayable;
	}
	public double getPlaceRental() {
		return placeRental;
	}
	public void setPlaceRental(double placeRental) {
		this.placeRental = placeRental;
	}
	public double getPlaceArea() {
		return placeArea;
	}
	public void setPlaceArea(double placeArea) {
		this.placeArea = placeArea;
	}
	public double getOtherCharge() {
		return otherCharge;
	}
	public void setOtherCharge(double otherCharge) {
		this.otherCharge = otherCharge;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public String getCompanyNature() {
		return companyNature;
	}
	public void setCompanyNature(String companyNature) {
		this.companyNature = companyNature;
	}
	public String getCompanyScale() {
		return companyScale;
	}
	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getOtherEarning() {
		return otherEarning;
	}
	public void setOtherEarning(double otherEarning) {
		this.otherEarning = otherEarning;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getSalaryDate() {
		return salaryDate;
	}
	public void setSalaryDate(int salaryDate) {
		this.salaryDate = salaryDate;
	}
	public String getChildRemark() {
		return childRemark;
	}
	public void setChildRemark(String childRemark) {
		this.childRemark = childRemark;
	}
	public String getMateRemark() {
		return mateRemark;
	}
	public void setMateRemark(String mateRemark) {
		this.mateRemark = mateRemark;
	}
	public String getPersonalRemark() {
		return personalRemark;
	}
	public void setPersonalRemark(String personalRemark) {
		this.personalRemark = personalRemark;
	}
	public double getHousePropertyOne() {
		return housePropertyOne;
	}
	public void setHousePropertyOne(double housePropertyOne) {
		this.housePropertyOne = housePropertyOne;
	}
	public double getHouseAreaOne() {
		return houseAreaOne;
	}
	public void setHouseAreaOne(double houseAreaOne) {
		this.houseAreaOne = houseAreaOne;
	}
	public double getHouseOneAmountInArear() {
		return houseOneAmountInArear;
	}
	public void setHouseOneAmountInArear(double houseOneAmountInArear) {
		this.houseOneAmountInArear = houseOneAmountInArear;
	}
	public double getHousePropertyTwo() {
		return housePropertyTwo;
	}
	public void setHousePropertyTwo(double housePropertyTwo) {
		this.housePropertyTwo = housePropertyTwo;
	}
	public double getHouseAreaTwo() {
		return houseAreaTwo;
	}
	public void setHouseAreaTwo(double houseAreaTwo) {
		this.houseAreaTwo = houseAreaTwo;
	}
	public double getHouseTwoAmountInArear() {
		return houseTwoAmountInArear;
	}
	public void setHouseTwoAmountInArear(double houseTwoAmountInArear) {
		this.houseTwoAmountInArear = houseTwoAmountInArear;
	}
	public String getCarBrandOne() {
		return carBrandOne;
	}
	public void setCarBrandOne(String carBrandOne) {
		this.carBrandOne = carBrandOne;
	}
	public double getCarMarketPriceOne() {
		return carMarketPriceOne;
	}
	public void setCarMarketPriceOne(double carMarketPriceOne) {
		this.carMarketPriceOne = carMarketPriceOne;
	}
	public double getCarOneAmountInArear() {
		return carOneAmountInArear;
	}
	public void setCarOneAmountInArear(double carOneAmountInArear) {
		this.carOneAmountInArear = carOneAmountInArear;
	}
	public String getCarBrandTwo() {
		return carBrandTwo;
	}
	public void setCarBrandTwo(String carBrandTwo) {
		this.carBrandTwo = carBrandTwo;
	}
	public double getCarMarketPriceTwo() {
		return carMarketPriceTwo;
	}
	public void setCarMarketPriceTwo(double carMarketPriceTwo) {
		this.carMarketPriceTwo = carMarketPriceTwo;
	}
	public double getCarTwoAmountInArear() {
		return carTwoAmountInArear;
	}
	public void setCarTwoAmountInArear(double carTwoAmountInArear) {
		this.carTwoAmountInArear = carTwoAmountInArear;
	}
	public String getCreditCardBankNameOne() {
		return creditCardBankNameOne;
	}
	public void setCreditCardBankNameOne(String creditCardBankNameOne) {
		this.creditCardBankNameOne = creditCardBankNameOne;
	}
	public double getLimitOne() {
		return limitOne;
	}
	public void setLimitOne(double limitOne) {
		this.limitOne = limitOne;
	}
	public double getCreditCardOneAmountInArear() {
		return creditCardOneAmountInArear;
	}
	public void setCreditCardOneAmountInArear(double creditCardOneAmountInArear) {
		this.creditCardOneAmountInArear = creditCardOneAmountInArear;
	}
	public String getCreditCardBankNameTwo() {
		return creditCardBankNameTwo;
	}
	public void setCreditCardBankNameTwo(String creditCardBankNameTwo) {
		this.creditCardBankNameTwo = creditCardBankNameTwo;
	}
	public double getLimitTwo() {
		return limitTwo;
	}
	public void setLimitTwo(double limitTwo) {
		this.limitTwo = limitTwo;
	}
	public double getCreditCardTwoAmountInArear() {
		return creditCardTwoAmountInArear;
	}
	public void setCreditCardTwoAmountInArear(double creditCardTwoAmountInArear) {
		this.creditCardTwoAmountInArear = creditCardTwoAmountInArear;
	}
	public double getTotalLimit() {
		return totalLimit;
	}
	public void setTotalLimit(double totalLimit) {
		this.totalLimit = totalLimit;
	}
	public double getTotalAmountInArear() {
		return totalAmountInArear;
	}
	public void setTotalAmountInArear(double totalAmountInArear) {
		this.totalAmountInArear = totalAmountInArear;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getHomeVisitCheck() {
		return homeVisitCheck;
	}
	public void setHomeVisitCheck(String homeVisitCheck) {
		this.homeVisitCheck = homeVisitCheck;
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
