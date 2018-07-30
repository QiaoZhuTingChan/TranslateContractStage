package com.jyd.bms.dto;

/**
 * 合同费用DTO
 * @author ganpeng
 *
 */
public class ContractStageCostDTO {
	private String costType;
	private Double value;

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
