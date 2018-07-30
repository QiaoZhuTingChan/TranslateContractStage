package com.jyd.bms.dto;

import java.util.Map;

import com.jyd.bms.bean.ContractStage;
/**
 * 合同分期DTO
 * @author ganpeng
 *
 */
public class ContractStageDTO {
	private ContractStage contractStage;
	private double remainCapital;
	private double forwardPayCapital;
	private Map contractStageCostMap;
	private double serviceFee;//每期服务费
	private double forwardRepaymentPenalty;//每期提前还款违约金
	public double getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public double getForwardRepaymentPenalty() {
		return forwardRepaymentPenalty;
	}
	public void setForwardRepaymentPenalty(double forwardRepaymentPenalty) {
		this.forwardRepaymentPenalty = forwardRepaymentPenalty;
	}
	public ContractStage getContractStage() {
		return contractStage;
	}
	public void setContractStage(ContractStage contractStage) {
		this.contractStage = contractStage;
	}
	public double getRemainCapital() {
		return remainCapital;
	}
	public void setRemainCapital(double remainCapital) {
		this.remainCapital = remainCapital;
	}
	public double getForwardPayCapital() {
		return forwardPayCapital;
	}
	public void setForwardPayCapital(double forwardPayCapital) {
		this.forwardPayCapital = forwardPayCapital;
	}
	public Map getContractStageCostMap() {
		return contractStageCostMap;
	}
	public void setContractStageCostMap(Map contractStageCostMap) {
		this.contractStageCostMap = contractStageCostMap;
	}
}
