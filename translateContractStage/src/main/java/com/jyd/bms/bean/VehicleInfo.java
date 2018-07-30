package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class VehicleInfo implements Serializable {
	private int id;
	private String brand;
	private String color;
	private Date initialDateOfRegistration;// 购买日期(初次登记日期)
	private String plate;
	private Double purchasePrice;
	private Double valuationPrice;
	private int milesOfTraveled;
	private Date insuranceExpirationDate;// 保险到期日
	private Date annualRiskDueDate;// 年检到期日期
	private String engineNo;
	private String vin;
	private CustomerInfo customer;
	private VehicleType vehicleType;
	private String remark;
	private Date releaseDate; // 出厂日期
	private String gearbox; // 变速箱
	private String displacement; // 排量
	private String emissions; // 排放标准
	private String vehicleLevel; // 车辆级别
	private String door; // 车门
	private String oil; // 燃油
	private String driveMode; // 驱动方式
	private Date timeToMarket; // 上市时间
	private String alloction; // 配置
	private String model; // 型号
	private String trimEvluate; // 内饰评价
	private String seat; // 座椅
	private String trim; // 内饰
	private String carBodyEvluate; // 车体评价
	private Date mortgageRepaymentDate; // 按揭还款日
	private Date mortgageDueDate; //按揭到期日
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getInitialDateOfRegistration() {
		return initialDateOfRegistration;
	}

	public void setInitialDateOfRegistration(Date initialDateOfRegistration) {
		this.initialDateOfRegistration = initialDateOfRegistration;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getCarBodyEvluate() {
		return carBodyEvluate;
	}

	public void setCarBodyEvluate(String carBodyEvluate) {
		this.carBodyEvluate = carBodyEvluate;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getValuationPrice() {
		return valuationPrice;
	}

	public void setValuationPrice(Double valuationPrice) {
		this.valuationPrice = valuationPrice;
	}

	public int getMilesOfTraveled() {
		return milesOfTraveled;
	}

	public void setMilesOfTraveled(int milesOfTraveled) {
		this.milesOfTraveled = milesOfTraveled;
	}

	public Date getInsuranceExpirationDate() {
		return insuranceExpirationDate;
	}

	public void setInsuranceExpirationDate(Date insuranceExpirationDate) {
		this.insuranceExpirationDate = insuranceExpirationDate;
	}

	public Date getAnnualRiskDueDate() {
		return annualRiskDueDate;
	}

	public void setAnnualRiskDueDate(Date annualRiskDueDate) {
		this.annualRiskDueDate = annualRiskDueDate;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public CustomerInfo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getEmissions() {
		return emissions;
	}

	public void setEmissions(String emissions) {
		this.emissions = emissions;
	}

	public String getVehicleLevel() {
		return vehicleLevel;
	}

	public void setVehicleLevel(String vehicleLevel) {
		this.vehicleLevel = vehicleLevel;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	public String getOil() {
		return oil;
	}

	public void setOil(String oil) {
		this.oil = oil;
	}

	public String getDriveMode() {
		return driveMode;
	}

	public void setDriveMode(String driveMode) {
		this.driveMode = driveMode;
	}

	public Date getTimeToMarket() {
		return timeToMarket;
	}

	public void setTimeToMarket(Date timeToMarket) {
		this.timeToMarket = timeToMarket;
	}

	public String getAlloction() {
		return alloction;
	}

	public void setAlloction(String alloction) {
		this.alloction = alloction;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTrimEvluate() {
		return trimEvluate;
	}

	public void setTrimEvluate(String trimEvluate) {
		this.trimEvluate = trimEvluate;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public Date getMortgageRepaymentDate() {
		return mortgageRepaymentDate;
	}

	public void setMortgageRepaymentDate(Date mortgageRepaymentDate) {
		this.mortgageRepaymentDate = mortgageRepaymentDate;
	}

	public Date getMortgageDueDate() {
		return mortgageDueDate;
	}

	public void setMortgageDueDate(Date mortgageDueDate) {
		this.mortgageDueDate = mortgageDueDate;
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
