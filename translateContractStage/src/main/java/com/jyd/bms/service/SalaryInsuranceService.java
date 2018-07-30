package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Insurance;
import com.jyd.bms.dao.InsuranceDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * 工资保险
 * 
 * @author li
 *
 */
@Service("SalaryInsuranceService")
public class SalaryInsuranceService extends BaseService<Insurance> {

	@Autowired(required = true)
	private InsuranceDAO insuranceDAO;

	/**
	 * 获取记录条数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getInsuranceCount(String condition) throws DAOException {
		return insuranceDAO.getInsuranceCount(condition);
	}

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Insurance> getPagingInsurance(int firstResult, int maxResults, String condition) throws DAOException {
		return insuranceDAO.getPagingInsurance(firstResult, maxResults, condition);
	}

	/**
	 * 获取所有记录
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Insurance> getInsurance() throws DAOException {
		return insuranceDAO.getInsurance();
	}

	@Override
	public void setDAO() {
		this.baseDAO = insuranceDAO;
	}

}
