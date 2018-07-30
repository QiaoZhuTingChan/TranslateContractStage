package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.InsuranceType;
import com.jyd.bms.dao.SalaryInsuranceTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * 工资保险类型service
 * 
 * @author zhi
 *
 */
@Service("SalaryInsuranceTypeService")
public class SalaryInsuranceTypeService extends BaseService<InsuranceType> {

	@Autowired(required = true)
	private SalaryInsuranceTypeDAO salaryInsuranceTypeDAO;

	/**
	 * 模糊查询获取记录条数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getSalaryInsuranceTypeCount(String condition) throws DAOException {
		return salaryInsuranceTypeDAO.getSalaryInsuranceTypeCount(condition);
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
	public List<InsuranceType> getPagingSalaryInsuranceType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return salaryInsuranceTypeDAO.getPagingSalaryInsuranceType(firstResult, maxResults, condition);
	}

	/**
	 * 获取所有记录
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<InsuranceType> getAllSalaryInsuranceType() throws DAOException {
		return salaryInsuranceTypeDAO.getAllSalaryInsuranceType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = salaryInsuranceTypeDAO;
	}

}
