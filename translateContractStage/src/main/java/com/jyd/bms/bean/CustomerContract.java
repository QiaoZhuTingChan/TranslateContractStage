package com.jyd.bms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import com.jyd.bms.tool.NumberToCNUtil;

@Entity
@SuppressWarnings("serial")
public class CustomerContract implements Serializable {
	private int id;
	private String name;
	private String IDNo;
	private String address;
	private String phone;
	private String bankNo;
	private String contractNum;// 合同编号
	private BusinessSource businessSource;// 业务来源
	private AssetsType assetsType;// 资产类型
	private Product product;
	private String purpose;
	private double amount;// 借款金额
	private double expLoanAmount;
	private double principal;// 合同本金
	private RepaymentStage stage;// 还款期数
	private ContractVersion version;
	private String plate;// 车牌号码
	private String engineNo;
	private String vin;
	private int state;
	private Date startDate; // 合同开始日期
	private Date endDate;// 合同结束日期
	private Date realLoanDate;// 合同放款开始日期
	private Date realLoanEndDate;// 合同放款结束日期
	private Date settlementDate;// 结清日期
	private String vehicleModel;
	private CustomerInfo customerInfo;
	private RepaymentAccount repaymentAccount;
	private String mortgagor;
	private String repayAccount;
	private String repayName;
	private String bankName;
	private String brand;// 品牌
	private String repaymentBankName;
	private Mortgager mortgager;
	private Store store;
	private VehicleInfo vehicleInfo;
	private String mortgagorIdcard;
	private String mortgagorAdress;
	private Employee founder;// 合同创建人
	private Employee responsiblePerson;// 合同负责人
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private double carValueAtion; // 评估价
	private double purchasePrice; // 开票价
	private Date purchaseDate;// 汽车购买日期
	private String purchaseDaxie;// 购买价大写
	private String evaluatedCap;// 评估价
	private String principalAmount;// 合同本金大写
	private int month;
	private double lateFee;// 逾期费
	private int overdueDays;
	private double mentionPay;// 提还金
	private Date sellerDefaultDate;// 转催收日期
	private Date trailCarDate;// 拖车日期
	private Date sellCarDate;// 卖车日期
	private double sellCarAmount;// 卖车金额
	private double collectPincipal;// 转催收已收回本金
	private double collectInterest;// 转催收已收回利息
	private double collectLateFee;// 转催收已收回逾期费
	private double hasFlagPincipal;// 已平账本金
	private double hasFlagLateFee;// 已平账逾期费
	private double hasFlagInterest;// 已平账利息
	private ContractManageType contractManageType;// 合同管理费类别
	private Double contractManageValue;// 合同管理费
	private double bidAmount;// 上标金额
	private String bidAmountUapper;// 上标金额大写
	private String amountUapper;// 借款金额大写
	private double returnPointNum;// 返点数
	private double surplusCapital;// 剩余本金
	private double surplusInterest;// 剩余本金
	private double surplusOtherFee;// 剩余本金
	private String email;// 邮箱
	private BaCalcStageVersion stageVersion;// 分期计算版本
	private RepaymentType repaymentType;// 分期方式
	private int renewal;// 是否续期，标记为1，则该合同续期。默认为0
	private ProductType productType;// 产品类型
	private String proType;// 产品类型
	private int feeStage;// 服务费期数
	private BaProductClassify baProductClassify;//产品分类
	private BaSettlementType baSettlementType;//结清类型
	private Employee followEmployee;//追踪人
	
	public Employee getFollowEmployee() {
		return followEmployee;
	}

	public void setFollowEmployee(Employee followEmployee) {
		this.followEmployee = followEmployee;
	}

	public BaSettlementType getBaSettlementType() {
		return baSettlementType;
	}

	public void setBaSettlementType(BaSettlementType baSettlementType) {
		this.baSettlementType = baSettlementType;
	}

	public BaProductClassify getBaProductClassify() {
		return baProductClassify;
	}

	public void setBaProductClassify(BaProductClassify baProductClassify) {
		this.baProductClassify = baProductClassify;
	}

	public int getFeeStage() {
		return feeStage;
	}

	public void setFeeStage(int feeStage) {
		this.feeStage = feeStage;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public Date getRealLoanEndDate() {
		return realLoanEndDate;
	}

	public void setRealLoanEndDate(Date realLoanEndDate) {
		this.realLoanEndDate = realLoanEndDate;
	}

	public int getRenewal() {
		return renewal;
	}

	public void setRenewal(int renewal) {
		this.renewal = renewal;
	}

	public double getSurplusCapital() {
		return surplusCapital;
	}

	public void setSurplusCapital(double surplusCapital) {
		this.surplusCapital = surplusCapital;
	}

	public double getSurplusInterest() {
		return surplusInterest;
	}

	public void setSurplusInterest(double surplusInterest) {
		this.surplusInterest = surplusInterest;
	}

	public double getSurplusOtherFee() {
		return surplusOtherFee;
	}

	public void setSurplusOtherFee(double surplusOtherFee) {
		this.surplusOtherFee = surplusOtherFee;
	}

	public Date getRealLoanDate() {
		return realLoanDate;
	}

	public void setRealLoanDate(Date realLoanDate) {
		this.realLoanDate = realLoanDate;
	}

	public RepaymentType getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(RepaymentType repaymentType) {
		this.repaymentType = repaymentType;
	}

	public BaCalcStageVersion getStageVersion() {
		return stageVersion;
	}

	public void setStageVersion(BaCalcStageVersion stageVersion) {
		this.stageVersion = stageVersion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Set<ContractLender> contractLenders = new HashSet<ContractLender>();
	private Set<ContractLateFee> contractLateFees = new HashSet<ContractLateFee>();
	private Set<ContractOverdueAmount> contractOverdueAmounts = new HashSet<ContractOverdueAmount>();
	private Set<ContractPara> contractParas = new HashSet<ContractPara>();
	private Set<ContractStage> contractStages = new HashSet<ContractStage>();
	private Set<ContractUploadfile> contractUploadfiles = new HashSet<ContractUploadfile>();
	private Set<CusContractCost> cusContractCosts = new HashSet<CusContractCost>();
	private Set<Gpsinstall> gpsinstalls = new HashSet<Gpsinstall>();
	private Set<ContractGpsLateFee> gpsLatefes = new HashSet<ContractGpsLateFee>();
	private Set<ContractBorrower> ContractBorrowerSet = new HashSet<ContractBorrower>();

	public String getAmountUapper() {
		return NumberToCNUtil.number2CNMontrayUnit(BigDecimal.valueOf(amount));
	}

	public String getBidAmountUapper() {
		return NumberToCNUtil.number2CNMontrayUnit(BigDecimal.valueOf(bidAmount));
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public double getReturnPointNum() {
		return returnPointNum;
	}

	public void setReturnPointNum(double returnPointNum) {
		this.returnPointNum = returnPointNum;
	}

	public void setPurchaseDaxie(String purchaseDaxie) {
		this.purchaseDaxie = purchaseDaxie;
	}

	public void setEvaluatedCap(String evaluatedCap) {
		this.evaluatedCap = evaluatedCap;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setBidAmountUapper(String bidAmountUapper) {
		this.bidAmountUapper = bidAmountUapper;
	}

	public void setAmountUapper(String amountUapper) {
		this.amountUapper = amountUapper;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public int getId() {
		return id;
	}

	public ContractManageType getContractManageType() {
		return contractManageType;
	}

	public void setContractManageType(ContractManageType contractManageType) {
		this.contractManageType = contractManageType;
	}

	public Double getContractManageValue() {
		return contractManageValue;
	}

	public void setContractManageValue(Double contractManageValue) {
		this.contractManageValue = contractManageValue;
	}

	public Set<ContractGpsLateFee> getGpsLatefes() {
		return gpsLatefes;
	}

	public void setGpsLatefes(Set<ContractGpsLateFee> gpsLatefes) {
		this.gpsLatefes = gpsLatefes;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getExpLoanAmount() {
		return expLoanAmount;
	}

	public void setExpLoanAmount(double expLoanAmount) {
		this.expLoanAmount = expLoanAmount;
	}

	public int getMonth() {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(this.startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(this.endDate);
		int day = endCalendar.get(Calendar.DATE) - startCalendar.get(Calendar.DATE);
		int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		if (month >= 0 && year >= 0) {
			return year * 12 + month;
		} else if (day > 0) {
			return 1;
		}
		return 0;
	}

	public String getPrincipalAmount() {
		return NumberToCNUtil.number2CNMontrayUnit(BigDecimal.valueOf(principal));
	}

	public String getPurchaseDaxie() {
		return NumberToCNUtil.number2CNMontrayUnit(BigDecimal.valueOf(purchasePrice));
	}

	public String getEvaluatedCap() {
		return NumberToCNUtil.number2CNMontrayUnit(BigDecimal.valueOf(carValueAtion));
	}

	public double getCarValueAtion() {
		return carValueAtion;
	}

	public void setCarValueAtion(double carValueAtion) {
		this.carValueAtion = carValueAtion;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}

	public void setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getRepayName() {
		return repayName;
	}

	public void setRepayName(String repayName) {
		this.repayName = repayName;
	}

	public AssetsType getAssetsType() {
		return assetsType;
	}

	public void setAssetsType(AssetsType assetsType) {
		this.assetsType = assetsType;
	}

	public BusinessSource getBusinessSource() {
		return businessSource;
	}

	public void setBusinessSource(BusinessSource businessSource) {
		this.businessSource = businessSource;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public void setPrincipalAmount(String principalAmount) {
		this.principalAmount = principalAmount;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public Mortgager getMortgager() {
		return mortgager;
	}

	public void setMortgager(Mortgager mortgager) {
		this.mortgager = mortgager;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public String getRepaymentBankName() {
		return repaymentBankName;
	}

	public void setRepaymentBankName(String repaymentBankName) {
		this.repaymentBankName = repaymentBankName;
	}

	public String getMortgagorIdcard() {
		return mortgagorIdcard;
	}

	public void setMortgagorIdcard(String mortgagorIdcard) {
		this.mortgagorIdcard = mortgagorIdcard;
	}

	public String getMortgagorAdress() {
		return mortgagorAdress;
	}

	public void setMortgagorAdress(String mortgagorAdress) {
		this.mortgagorAdress = mortgagorAdress;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public RepaymentAccount getRepaymentAccount() {
		return repaymentAccount;
	}

	public void setRepaymentAccount(RepaymentAccount repaymentAccount) {
		this.repaymentAccount = repaymentAccount;
	}

	public String getMortgagor() {
		return mortgagor;
	}

	public void setMortgagor(String mortgagor) {
		this.mortgagor = mortgagor;
	}

	public String getRepayAccount() {
		return repayAccount;
	}

	public void setRepayAccount(String repayAccount) {
		this.repayAccount = repayAccount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIDNo() {
		return IDNo;
	}

	public void setIDNo(String iDNo) {
		IDNo = iDNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getContractNum() {
		return contractNum;

	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public RepaymentStage getStage() {
		return stage;
	}

	public void setStage(RepaymentStage stage) {
		this.stage = stage;
	}

	public ContractVersion getVersion() {
		return version;
	}

	public void setVersion(ContractVersion version) {
		this.version = version;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getSellerDefaultDate() {
		return sellerDefaultDate;
	}

	public void setSellerDefaultDate(Date sellerDefaultDate) {
		this.sellerDefaultDate = sellerDefaultDate;
	}

	public Date getTrailCarDate() {
		return trailCarDate;
	}

	public void setTrailCarDate(Date trailCarDate) {
		this.trailCarDate = trailCarDate;
	}

	public Date getSellCarDate() {
		return sellCarDate;
	}

	public void setSellCarDate(Date sellCarDate) {
		this.sellCarDate = sellCarDate;
	}

	public double getSellCarAmount() {
		return sellCarAmount;
	}

	public void setSellCarAmount(double sellCarAmount) {
		this.sellCarAmount = sellCarAmount;
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

	public Set<ContractLender> getContractLenders() {
		return contractLenders;
	}

	public void setContractLenders(Set<ContractLender> contractLenders) {
		this.contractLenders = contractLenders;
	}

	public Set<ContractLateFee> getContractLateFees() {
		return contractLateFees;
	}

	public void setContractLateFees(Set<ContractLateFee> contractLateFees) {
		this.contractLateFees = contractLateFees;
	}

	public Set<ContractOverdueAmount> getContractOverdueAmounts() {
		return contractOverdueAmounts;
	}

	public void setContractOverdueAmounts(Set<ContractOverdueAmount> contractOverdueAmounts) {
		this.contractOverdueAmounts = contractOverdueAmounts;
	}

	public Set<ContractPara> getContractParas() {
		return contractParas;
	}

	public void setContractParas(Set<ContractPara> contractParas) {
		this.contractParas = contractParas;
	}

	public Set<ContractStage> getContractStages() {
		return contractStages;
	}

	public void setContractStages(Set<ContractStage> contractStages) {
		this.contractStages = contractStages;
	}

	public Set<ContractUploadfile> getContractUploadfiles() {
		return contractUploadfiles;
	}

	public void setContractUploadfiles(Set<ContractUploadfile> contractUploadfiles) {
		this.contractUploadfiles = contractUploadfiles;
	}

	public Set<CusContractCost> getCusContractCosts() {
		return cusContractCosts;
	}

	public void setCusContractCosts(Set<CusContractCost> cusContractCosts) {
		this.cusContractCosts = cusContractCosts;
	}

	public Set<Gpsinstall> getGpsinstalls() {
		return gpsinstalls;
	}

	public void setGpsinstalls(Set<Gpsinstall> gpsinstalls) {
		this.gpsinstalls = gpsinstalls;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public int getOverdueDays() {
		return overdueDays;
	}

	public void setOverdueDays(int overdueDays) {
		this.overdueDays = overdueDays;
	}

	public Set<ContractBorrower> getContractBorrowerSet() {
		return ContractBorrowerSet;
	}

	public void setContractBorrowerSet(Set<ContractBorrower> contractBorrowerSet) {
		ContractBorrowerSet = contractBorrowerSet;
	}

	public Employee getFounder() {
		return founder;
	}

	public void setFounder(Employee founder) {
		this.founder = founder;
	}

	public Employee getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(Employee responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public double getMentionPay() {
		return mentionPay;
	}

	public void setMentionPay(double mentionPay) {
		this.mentionPay = mentionPay;
	}

	public double getCollectPincipal() {
		return collectPincipal;
	}

	public void setCollectPincipal(double collectPincipal) {
		this.collectPincipal = collectPincipal;
	}

	public double getCollectInterest() {
		return collectInterest;
	}

	public void setCollectInterest(double collectInterest) {
		this.collectInterest = collectInterest;
	}

	public double getCollectLateFee() {
		return collectLateFee;
	}

	public void setCollectLateFee(double collectLateFee) {
		this.collectLateFee = collectLateFee;
	}

	public double getHasFlagPincipal() {
		return hasFlagPincipal;
	}

	public void setHasFlagPincipal(double hasFlagPincipal) {
		this.hasFlagPincipal = hasFlagPincipal;
	}

	public double getHasFlagLateFee() {
		return hasFlagLateFee;
	}

	public void setHasFlagLateFee(double hasFlagLateFee) {
		this.hasFlagLateFee = hasFlagLateFee;
	}

	public double getHasFlagInterest() {
		return hasFlagInterest;
	}

	public void setHasFlagInterest(double hasFlagInterest) {
		this.hasFlagInterest = hasFlagInterest;
	}

	@Override
	public String toString() {
		return "CustomerContract [id=" + id + ", name=" + name + ", IDNo=" + IDNo + ", address=" + address + ", phone="
				+ phone + ", bankNo=" + bankNo + ", contractNum=" + contractNum + ", businessSource=" + businessSource
				+ ", assetsType=" + assetsType + ", product=" + product + ", purpose=" + purpose + ", amount=" + amount
				+ ", expLoanAmount=" + expLoanAmount + ", principal=" + principal + ", stage=" + stage + ", version="
				+ version + ", plate=" + plate + ", engineNo=" + engineNo + ", vin=" + vin + ", state=" + state
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", settlementDate=" + settlementDate
				+ ", vehicleModel=" + vehicleModel + ", customerInfo=" + customerInfo + ", repaymentAccount="
				+ repaymentAccount + ", mortgagor=" + mortgagor + ", repayAccount=" + repayAccount + ", repayName="
				+ repayName + ", bankName=" + bankName + ", brand=" + brand + ", repaymentBankName=" + repaymentBankName
				+ ", mortgager=" + mortgager + ", store=" + store + ", vehicleInfo=" + vehicleInfo
				+ ", mortgagorIdcard=" + mortgagorIdcard + ", mortgagorAdress=" + mortgagorAdress + ", founder="
				+ founder + ", responsiblePerson=" + responsiblePerson + ", remark=" + remark + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", createUser=" + createUser + ", updateUser="
				+ updateUser + ", carValueAtion=" + carValueAtion + ", purchasePrice=" + purchasePrice
				+ ", purchaseDate=" + purchaseDate + ", purchaseDaxie=" + purchaseDaxie + ", evaluatedCap="
				+ evaluatedCap + ", principalAmount=" + principalAmount + ", month=" + month + ", lateFee=" + lateFee
				+ ", overdueDays=" + overdueDays + ", mentionPay=" + mentionPay + ", sellerDefaultDate="
				+ sellerDefaultDate + ", trailCarDate=" + trailCarDate + ", sellCarDate=" + sellCarDate
				+ ", sellCarAmount=" + sellCarAmount + ", collectPincipal=" + collectPincipal + ", collectInterest="
				+ collectInterest + ", collectLateFee=" + collectLateFee + ", hasFlagPincipal=" + hasFlagPincipal
				+ ", hasFlagLateFee=" + hasFlagLateFee + ", hasFlagInterest=" + hasFlagInterest
				+ ", contractManageType=" + contractManageType + ", contractManageValue=" + contractManageValue
				+ ", bidAmount=" + bidAmount + ", bidAmountUapper=" + bidAmountUapper + ", amountUapper=" + amountUapper
				+ ", email=" + email + ", contractLenders=" + contractLenders + ", contractLateFees=" + contractLateFees
				+ ", contractOverdueAmounts=" + contractOverdueAmounts + ", contractParas=" + contractParas
				+ ", contractStages=" + contractStages + ", contractUploadfiles=" + contractUploadfiles
				+ ", cusContractCosts=" + cusContractCosts + ", gpsinstalls=" + gpsinstalls + ", gpsLatefes="
				+ gpsLatefes + ", ContractBorrowerSet=" + ContractBorrowerSet + "]";
	}

}
