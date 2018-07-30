package com.jyd.bms.dto;

public class OnlineUserDTO {
	private int userId;
	private String loginName;
	private String name;
	private String department;
	private String store;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public OnlineUserDTO(int userId,String loginName, String name, String department, String store) {
		this.userId = userId;
		this.loginName = loginName;
		this.name = name;
		this.department = department;
		this.store = store;
	}
}
