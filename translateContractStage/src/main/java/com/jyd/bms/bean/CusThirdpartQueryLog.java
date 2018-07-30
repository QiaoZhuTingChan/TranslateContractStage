package com.jyd.bms.bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 查询日志
 * 
 * @author aa
 *
 */
@Entity
public class CusThirdpartQueryLog {
	private int id;
	private BaThirdpartQueryType baThirdpartQueryType;// 查询类型id
	private Timestamp startDate;// 开始时间
	private Timestamp endDate;// 结束时间
	private String sendContent;// 发送内容
	private String receiveContent;// 接收内容
	private String state;// 状态

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

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getSendContent() {
		return sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public String getReceiveContent() {
		return receiveContent;
	}

	public void setReceiveContent(String receiveContent) {
		this.receiveContent = receiveContent;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}