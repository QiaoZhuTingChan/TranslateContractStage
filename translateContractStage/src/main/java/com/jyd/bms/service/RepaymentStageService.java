package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.dao.RepaymentStageDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("RepaymentStageService")
public class RepaymentStageService extends BaseService<RepaymentStage> {
	@Autowired(required = true)
	private RepaymentStageDAO repaymentStageDAO;

	public int getRepaymentStageCount(String condition) throws DAOException {
		return repaymentStageDAO.getRepaymentStageCount(condition);
	}

	public List<RepaymentStage> getPagingRepaymentStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		return repaymentStageDAO.getPagingRepaymentStage(firstResult, maxResults, condition);
	}

	public List<RepaymentStage> getAllRepaymentStage() throws DAOException {
		return repaymentStageDAO.getAllRepaymentStage();
	}

	@Override
	public void setDAO() {
		this.baseDAO = repaymentStageDAO;
	}

	public RepaymentStage getRepaymentStageById(int stage) throws DAOException{
		return repaymentStageDAO.getRepaymentStageById(stage);
	}
	/**
	 * 根据还款期限值，拿到还款期限实体
	 * @param repaymentStage
	 * @return
	 * @throws DAOException 
	 */
	public RepaymentStage getRepaymentStageByRepaymentStage(int repaymentStage) throws DAOException {
		return repaymentStageDAO.getRepaymentStageByRepaymentStage(repaymentStage);
	}

}
