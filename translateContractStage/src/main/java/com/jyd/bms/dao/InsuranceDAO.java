package com.jyd.bms.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Insurance;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * 工资保险dao接口
 * @author li
 *
 */
public interface InsuranceDAO extends HibernateBase<Insurance>{

	/**
	 * 查询总记录数
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getInsuranceCount(String condition) throws DAOException ;
	
	/**
	 * 分页查询
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 */
	public List<Insurance> getPagingInsurance(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 查询所有工资保险数据
	 * @return
	 * @throws DAOException
	 */
	public List<Insurance> getInsurance() throws DAOException;
	
	
   /**
	 * 获取员工的保险金额
	 * 
	 * @param employee
	 *         员工
	 * @param beginDate
	 *         开始时间
	 * @param insurance
	 *         保险
	 * @return
	 * @throws DAOException
     * @throws ParseException 
	 */
	public double getInsuranceTypeValue(SalaryItem salaryItem, Employee employee, String yearMonth) throws DAOException, ParseException;
	
	
	
	/**
	 * 批量获取员工的保险金额
	 * 
	 * @param listEmployee
	 *        员工
	 * @param beginDate
	 *        开始时间
	 * @param insurance
	 *        保险
	 * @return
	 * @throws DAOException
	 * @throws ParseException 
	 */
	public Map<String, EmployeeSalaryDataDTO> getInsuranceTypeValueByEmployeeList(SalaryItem salaryItem,
			List<Employee> listEmployee,String yearMonth) throws DAOException, ParseException;
}