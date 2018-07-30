package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @category Generated 2018-05-28 18:32:41 by GeneratedTool
 * @author mjy 资金方产品参数
 */
@Entity
public class FundProductPara implements Serializable {
	private int id;
	private ProductParameter parameter;// 产品参数
	private FundProduct fundProduct;// 资金方产品
	private double value;// 值
	private String remark;// 备注
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 修改时间
	private String createUser;// 创建用户
	private String updateUser;// 修改用户

	public ProductParameter getParameter() {
		return parameter;
	}

	public void setParameter(ProductParameter parameter) {
		this.parameter = parameter;
	}

	public FundProduct getFundProduct() {
		return fundProduct;
	}

	public void setFundProduct(FundProduct fundProduct) {
		this.fundProduct = fundProduct;
	}

	public double getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public int getId() {
		return id;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setId(int id) {
		this.id = id;
	}
}