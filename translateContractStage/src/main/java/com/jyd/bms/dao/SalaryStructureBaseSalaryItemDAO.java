package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.SalaryStructure;
import com.jyd.bms.bean.SalaryStructureBaseSalaryItem;
import com.jyd.bms.tool.exception.DAOException;

public interface SalaryStructureBaseSalaryItemDAO extends HibernateBase<SalaryStructureBaseSalaryItem>{

	/**
	 * 根据 薪资结构 查询记录数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getSalaryStructureBaseSalaryItemCountBySalaryStructure(String condition, SalaryStructure salaryStructure) throws DAOException;

	/**
	 * 根据 薪资结构 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryStructureBaseSalaryItem> getPagingSalaryStructureBaseSalaryItemBySalaryStructure(int firstResult, int maxResults, String condition, SalaryStructure salaryStructure)
			throws DAOException;

	/**
	 * 查询所有 薪资结构基本薪资项目
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryStructureBaseSalaryItem> getAllSalaryStructureBaseSalaryItem(SalaryStructure salaryStructure) throws DAOException;

	public List<SalaryStructureBaseSalaryItem> getSalaryStructureBaseSalaryItemBySalaryStructure(SalaryStructure salaryStructure) throws DAOException;
}
