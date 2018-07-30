package com.jyd.bms.bean;

import javax.persistence.Entity;

@Entity
public class ScheduleType {
	private int id;
	private String scheduleType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}
}
