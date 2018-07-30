package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @category Generated 2018-05-25 14:16:51 by GeneratedTool
 * @author mjy 资金方产品
 */
@Entity
public class FundProduct implements Serializable {
	private int id;
	private String name;// 产品名称
	private RepaymentType repaymentTypeId;// 分期类型
	private ProductType productTypeId;// 产品类型
	private ContractVersion contractVersion; // 合同版本
	private String remark;// 备注
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 修改时间
	private String createUser;// 创建用户
	private String updateUser;// 修改用户
	private Timestamp interestDate;// 利息还款日
	private Timestamp capitalDate;// 本金还款日

	private Set<FundProductPara> fundProductParas = new HashSet<FundProductPara>();
	private Set<FundContractCost> fundProductCosts = new HashSet<FundContractCost>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RepaymentType getRepaymentTypeId() {
		return repaymentTypeId;
	}

	public void setRepaymentTypeId(RepaymentType repaymentTypeId) {
		this.repaymentTypeId = repaymentTypeId;
	}

	public ProductType getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(ProductType productTypeId) {
		this.productTypeId = productTypeId;
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

	public Timestamp getInterestDate() {
		return interestDate;
	}

	public void setInterestDate(Timestamp interestDate) {
		this.interestDate = interestDate;
	}

	public Timestamp getCapitalDate() {
		return capitalDate;
	}

	public void setCapitalDate(Timestamp capitalDate) {
		this.capitalDate = capitalDate;
	}

	public ContractVersion getContractVersion() {
		return contractVersion;
	}

	public void setContractVersion(ContractVersion contractVersion) {
		this.contractVersion = contractVersion;
	}

	public Set<FundProductPara> getFundProductParas() {
		return fundProductParas;
	}

	public void setFundProductParas(Set<FundProductPara> fundProductParas) {
		this.fundProductParas = fundProductParas;
	}

	public Set<FundContractCost> getFundProductCosts() {
		return fundProductCosts;
	}

	public void setFundProductCosts(Set<FundContractCost> fundProductCosts) {
		this.fundProductCosts = fundProductCosts;
	}


}