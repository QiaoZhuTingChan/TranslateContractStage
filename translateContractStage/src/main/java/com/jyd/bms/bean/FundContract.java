package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * @category Generated 2018-05-25 14:05:15 by GeneratedTool
 * @author mjy 资金方合同
 */
@Entity
public class FundContract implements Serializable {
	private int id;
	private double borrowingAmount;// 合同金额
	private double principal;// 借款金额
	private double supplement;// 补差额
	private double returnThePrincipal;// 应还本金
	private double returnInterest;// 应还利息
	private double returnOfThePrincipal;// 已还本金
	private double waittingOfThePrincipal;// 待还投资本金
	private Timestamp supplementDate;// 补差额时间
	private Timestamp repaymentDate;// 还款日
	private String remark;// 备注
	private String createUser;// 创建用户
	private Date createDate;// 创建时间
	private String updateUser;// 修改用户
	private Date updateDate;// 修改时间
	private int state;// 状态,0正常，1结束，-1审批中，2转逾期，3转账外资产
	private double receiPriceDiff;// 应收差价
	private int returnInterestStage;// 已付利息期数
	private CustomerContract cusContract;// 客户合同
	private Fund fund;// 资金方
	private FundProduct fundProduct;// 资金方产品
	private Set<ContractPara> contractParas = new HashSet<ContractPara>();
	private Set<FundContractStage> fundContractStage = new HashSet<FundContractStage>();
	private Set<FundContractCost> fundContractCosts = new HashSet<FundContractCost>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSupplement() {
		return supplement;
	}

	public int getReturnInterestStage() {
		return returnInterestStage;
	}

	public void setReturnInterestStage(int returnInterestStage) {
		this.returnInterestStage = returnInterestStage;
	}

	public double getReceiPriceDiff() {
		return receiPriceDiff;
	}

	public void setReceiPriceDiff(double receiPriceDiff) {
		this.receiPriceDiff = receiPriceDiff;
	}

	public void setSupplement(double supplement) {
		this.supplement = supplement;
	}

	public Timestamp getSupplementDate() {
		return supplementDate;
	}

	public void setSupplementDate(Timestamp supplementDate) {
		this.supplementDate = supplementDate;
	}

	public Timestamp getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(Timestamp repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public double getBorrowingAmount() {
		return borrowingAmount;
	}

	public void setBorrowingAmount(double borrowingAmount) {
		this.borrowingAmount = borrowingAmount;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getReturnThePrincipal() {
		return returnThePrincipal;
	}

	public void setReturnThePrincipal(double returnThePrincipal) {
		this.returnThePrincipal = returnThePrincipal;
	}

	public double getReturnInterest() {
		return returnInterest;
	}

	public void setReturnInterest(double returnInterest) {
		this.returnInterest = returnInterest;
	}

	public double getReturnOfThePrincipal() {
		return returnOfThePrincipal;
	}

	public void setReturnOfThePrincipal(double returnOfThePrincipal) {
		this.returnOfThePrincipal = returnOfThePrincipal;
	}

	public double getWaittingOfThePrincipal() {
		return waittingOfThePrincipal;
	}

	public void setWaittingOfThePrincipal(double waittingOfThePrincipal) {
		this.waittingOfThePrincipal = waittingOfThePrincipal;
	}

	public CustomerContract getCusContract() {
		return cusContract;
	}

	public void setCusContract(CustomerContract cusContract) {
		this.cusContract = cusContract;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public FundProduct getFundProduct() {
		return fundProduct;
	}

	public void setFundProduct(FundProduct fundProduct) {
		this.fundProduct = fundProduct;
	}

	public Set<ContractPara> getContractParas() {
		return contractParas;
	}

	public void setContractParas(Set<ContractPara> contractParas) {
		this.contractParas = contractParas;
	}

	public Set<FundContractStage> getFundContractStage() {
		return fundContractStage;
	}

	public void setFundContractStage(Set<FundContractStage> fundContractStage) {
		this.fundContractStage = fundContractStage;
	}

	public Set<FundContractCost> getFundContractCosts() {
		return fundContractCosts;
	}

	public void setFundContractCosts(Set<FundContractCost> fundContractCosts) {
		this.fundContractCosts = fundContractCosts;
	}

	@Override
	public String toString() {
		return "FundContract [id=" + id + ", borrowingAmount=" + borrowingAmount + ", principal=" + principal
				+ ", supplement=" + supplement + ", returnThePrincipal=" + returnThePrincipal + ", returnInterest="
				+ returnInterest + ", returnOfThePrincipal=" + returnOfThePrincipal + ", waittingOfThePrincipal="
				+ waittingOfThePrincipal + ", supplementDate=" + supplementDate + ", repaymentDate=" + repaymentDate
				+ ", remark=" + remark + ", createUser=" + createUser + ", createDate=" + createDate + ", updateUser="
				+ updateUser + ", updateDate=" + updateDate + ", state=" + state + ", receiPriceDiff=" + receiPriceDiff
				+ ", returnInterestStage=" + returnInterestStage + ", cusContract=" + cusContract + ", fund=" + fund
				+ ", fundProduct=" + fundProduct + ", contractParas=" + contractParas + ", fundContractStage="
				+ fundContractStage + ", fundContractCosts=" + fundContractCosts + "]";
	}
	
}