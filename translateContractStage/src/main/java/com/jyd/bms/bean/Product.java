package com.jyd.bms.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Product implements Serializable {
	private int id;
	private String name;
	private ProductType productType;
	private RepaymentType repaymentType;
	private WorkflowType workflowType;
	private ContractVersion contractVersion;// 合同打印版本
	private BaCalcStageVersion stageVersion;// 分期计算版本
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String createUser;
	private String updateUser;
	private Set<ProductCost> productCosts = new HashSet<ProductCost>();
	private Set<ProductUploadfile> productUploadfiles = new HashSet<ProductUploadfile>();
	private Set<ProductStore> productStores = new HashSet<ProductStore>();
	private Set<ProductPara> productParas = new HashSet<ProductPara>();
	private Set<ProductRepaymentStage> productRepaymentStages = new HashSet<ProductRepaymentStage>();
	private Set<ProBusinessSource> proBusinessSources = new HashSet<ProBusinessSource>();


	public Set<ProBusinessSource> getProBusinessSources() {
		return proBusinessSources;
	}

	public void setProBusinessSources(Set<ProBusinessSource> proBusinessSources) {
		this.proBusinessSources = proBusinessSources;
	}

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

	public BaCalcStageVersion getStageVersion() {
		return stageVersion;
	}

	public void setStageVersion(BaCalcStageVersion stageVersion) {
		this.stageVersion = stageVersion;
	}

	public ContractVersion getContractVersion() {
		return contractVersion;
	}

	public void setContractVersion(ContractVersion contractVersion) {
		this.contractVersion = contractVersion;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public RepaymentType getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(RepaymentType repaymentType) {
		this.repaymentType = repaymentType;
	}

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	public Set<ProductCost> getProductCosts() {
		return productCosts;
	}

	public void setProductCosts(Set<ProductCost> productCosts) {
		this.productCosts = productCosts;
	}

	public Set<ProductUploadfile> getProductUploadfiles() {
		return productUploadfiles;
	}

	public void setProductUploadfiles(Set<ProductUploadfile> productUploadfiles) {
		this.productUploadfiles = productUploadfiles;
	}

	public Set<ProductStore> getProductStores() {
		return productStores;
	}

	public void setProductStores(Set<ProductStore> productStores) {
		this.productStores = productStores;
	}

	public Set<ProductPara> getProductParas() {
		return productParas;
	}

	public void setProductParas(Set<ProductPara> productParas) {
		this.productParas = productParas;
	}

	public Set<ProductRepaymentStage> getProductRepaymentStages() {
		return productRepaymentStages;
	}

	public void setProductRepaymentStages(Set<ProductRepaymentStage> productRepaymentStages) {
		this.productRepaymentStages = productRepaymentStages;
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

}
