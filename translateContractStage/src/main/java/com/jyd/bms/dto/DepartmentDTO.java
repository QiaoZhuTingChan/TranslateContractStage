package com.jyd.bms.dto;

public class DepartmentDTO {
	private int id;
	private Integer parentDeptDTO;
	private String supervisor;
	private String storeName;
	private String deptName;
	private int actualNums;
	private int totalActualNums;
	private int staffNums;
	private int totalStaffNums;
	private String remark;
	private int index;

	public DepartmentDTO(int id, String deptName, Integer parentDeptDTO, String supervisor, int actualNums,
			int totalActualNums, int staffNums, int totalStaffNums, String storeName, String remark) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.parentDeptDTO = parentDeptDTO;
		this.supervisor = supervisor;
		this.storeName = storeName;
		this.actualNums = actualNums;
		this.totalActualNums = totalActualNums;
		this.staffNums = staffNums;
		this.totalStaffNums = totalStaffNums;
	}

	public DepartmentDTO(int id, Integer parentDeptDTO, Long actualNums, Long totalActualNums, Long staffNums,
			Long totalStaffNums) {
		super();
		this.id = id;
		this.parentDeptDTO = parentDeptDTO == null ? 0 : parentDeptDTO.intValue();
		this.actualNums = actualNums == null ? 0 : actualNums.intValue();
		this.totalActualNums = totalActualNums == null ? 0 : totalActualNums.intValue();
		this.staffNums = staffNums == null ? 0 : staffNums.intValue();
		this.totalStaffNums = totalStaffNums == null ? 0 : totalStaffNums.intValue();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getActualNums() {
		return actualNums;
	}

	public void setActualNums(int actualNums) {
		this.actualNums = actualNums;
	}

	public int getTotalActualNums() {
		return totalActualNums;
	}

	public void setTotalActualNums(int totalActualNums) {
		this.totalActualNums = totalActualNums;
	}

	public int getStaffNums() {
		return staffNums;
	}

	public void setStaffNums(int staffNums) {
		this.staffNums = staffNums;
	}

	public int getTotalStaffNums() {
		return totalStaffNums;
	}

	public void setTotalStaffNums(int totalStaffNums) {
		this.totalStaffNums = totalStaffNums;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getParentDeptDTO() {
		return parentDeptDTO;
	}

	public void setParentDeptDTO(Integer parentDeptDTO) {
		this.parentDeptDTO = parentDeptDTO;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}