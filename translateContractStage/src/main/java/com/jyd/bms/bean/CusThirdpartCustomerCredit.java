package com.jyd.bms.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * 客户征信
 * 
 * @author aa
 *
 */
@Entity
public class CusThirdpartCustomerCredit {
	private int id;
	private BaThirdpartQueryType baThirdpartQueryType;// 第三方公司开启查询服务类型外键
	private String idCard;// 身份证
	private String phone;// 手机号码
	private String name;// 姓名
	private Timestamp queryDate;// 查询日期
	private String htmlsrc;// 生成的html路劲
	private Timestamp createDate;// 创建时间
	private Timestamp updateDate;// 修改时间
	private String createUser;// 创建者
	private String updateUser;// 修改者

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BaThirdpartQueryType getBaThirdpartQueryType() {
		return baThirdpartQueryType;
	}

	public void setBaThirdpartQueryType(BaThirdpartQueryType baThirdpartQueryType) {
		this.baThirdpartQueryType = baThirdpartQueryType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Timestamp queryDate) {
		this.queryDate = queryDate;
	}

	public String getHtmlsrc() {
		return htmlsrc;
	}

	public void setHtmlsrc(String htmlsrc) {
		this.htmlsrc = htmlsrc;
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