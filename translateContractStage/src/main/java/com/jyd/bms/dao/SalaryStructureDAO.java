package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.bean.SalaryStructure;
import com.jyd.bms.tool.exception.DAOException;

public interface SalaryStructureDAO extends HibernateBase<SalaryStructure>{
	
	/**
	 * 查询记录数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getSalaryStructureCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryStructure> getPagingSalaryStructure(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有出差类型
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryStructure> getAllSalaryStructure() throws DAOException;
	
	
	/**
	 * 导出excel表
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryItem> getSalaryItemByformula(SalaryStructure salaryStructure) throws DAOException;
	
	

}
