package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.InsuranceType;
import com.jyd.bms.tool.exception.DAOException;

/**
 * 工资保险类型dao接口
 * 
 * @author zhi
 *
 */
public interface SalaryInsuranceTypeDAO extends HibernateBase<InsuranceType> {

	/**
	 * 查询记录数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getSalaryInsuranceTypeCount(String condition) throws DAOException;

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
			throws DAOException;

	/**
	 * 查询所有工资保险类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<InsuranceType> getAllSalaryInsuranceType() throws DAOException;

}
