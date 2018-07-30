package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 同盾客户征信
 * 
 * @author aa
 *
 */
@Entity
public class CusThirdpartTongdunCustomerCredit {
	private int id;
	private String idCard;// 身份证
	private String mobilephone;// 手机号码
	private Timestamp queryDate;// 查询日期
	private String htmlsrc;// 生成的html路劲

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
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

}