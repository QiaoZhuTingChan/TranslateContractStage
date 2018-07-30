package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * 车辆评估实体类
 * 
 * @author zyn
 *
 */
@Entity
public class CusCarAssess implements Serializable {
	private int id;
	private boolean louver;// 天窗
	private boolean seat;// 真皮座椅
	private boolean launch;// 车辆是否一键启动
	private boolean powertSeat;// 是否是电动座椅
	private boolean powerBoot;// 电动尾箱
	private boolean seatHeating;// 前排座椅是否可以加热
	private boolean gps;// 是否有导航
	private boolean electronicSuspension;// "是否是电子悬挂
	private boolean LookedUpAndPrompt;// 车辆抬头提示
	private int seatNum;// "0－表示５座车 １－表示７座车"
	private String carAccessory;// 车辆的附件
	private String carVeer;// 车辆转向
	private String engine;// 发动机
	private String speedchangingbox;// 变速箱
	private String absorber;// 减震器
	private String exhaustpipe;// 排气管－排气系统
	private String airConditioningEquipment;// 空调
	private String checkTheResult;// 车辆检查结果
	private String carCondition;// 车况状态
	private String fault;// 故障
	private String remark;//
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private CustomerContract customerContract;// 合同外键

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLouver() {
		return louver;
	}

	public void setLouver(boolean louver) {
		this.louver = louver;
	}

	public boolean isSeat() {
		return seat;
	}

	public void setSeat(boolean seat) {
		this.seat = seat;
	}

	public boolean isLaunch() {
		return launch;
	}

	public void setLaunch(boolean launch) {
		this.launch = launch;
	}

	public boolean isPowertSeat() {
		return powertSeat;
	}

	public void setPowertSeat(boolean powertSeat) {
		this.powertSeat = powertSeat;
	}

	public boolean isPowerBoot() {
		return powerBoot;
	}

	public void setPowerBoot(boolean powerBoot) {
		this.powerBoot = powerBoot;
	}

	public boolean isSeatHeating() {
		return seatHeating;
	}

	public void setSeatHeating(boolean seatHeating) {
		this.seatHeating = seatHeating;
	}

	public boolean isGps() {
		return gps;
	}

	public void setGps(boolean gps) {
		this.gps = gps;
	}

	public boolean isElectronicSuspension() {
		return electronicSuspension;
	}

	public void setElectronicSuspension(boolean electronicSuspension) {
		this.electronicSuspension = electronicSuspension;
	}

	public boolean isLookedUpAndPrompt() {
		return LookedUpAndPrompt;
	}

	public void setLookedUpAndPrompt(boolean lookedUpAndPrompt) {
		LookedUpAndPrompt = lookedUpAndPrompt;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public String getCarAccessory() {
		return carAccessory;
	}

	public void setCarAccessory(String carAccessory) {
		this.carAccessory = carAccessory;
	}

	public String getCarVeer() {
		return carVeer;
	}

	public void setCarVeer(String carVeer) {
		this.carVeer = carVeer;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getSpeedchangingbox() {
		return speedchangingbox;
	}

	public void setSpeedchangingbox(String speedchangingbox) {
		this.speedchangingbox = speedchangingbox;
	}

	public String getAbsorber() {
		return absorber;
	}

	public void setAbsorber(String absorber) {
		this.absorber = absorber;
	}

	public String getExhaustpipe() {
		return exhaustpipe;
	}

	public void setExhaustpipe(String exhaustpipe) {
		this.exhaustpipe = exhaustpipe;
	}

	public String getAirConditioningEquipment() {
		return airConditioningEquipment;
	}

	public void setAirConditioningEquipment(String airConditioningEquipment) {
		this.airConditioningEquipment = airConditioningEquipment;
	}

	public String getCheckTheResult() {
		return checkTheResult;
	}

	public void setCheckTheResult(String checkTheResult) {
		this.checkTheResult = checkTheResult;
	}

	public String getCarCondition() {
		return carCondition;
	}

	public void setCarCondition(String carCondition) {
		this.carCondition = carCondition;
	}

	public String getFault() {
		return fault;
	}

	public void setFault(String fault) {
		this.fault = fault;
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

	public CustomerContract getCustomerContract() {
		return customerContract;
	}

	public void setCustomerContract(CustomerContract customerContract) {
		this.customerContract = customerContract;
	}

}
