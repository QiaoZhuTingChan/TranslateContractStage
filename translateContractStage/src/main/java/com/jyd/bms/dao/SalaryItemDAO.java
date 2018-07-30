package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.tool.exception.DAOException;

public interface SalaryItemDAO extends HibernateBase<SalaryItem> {
	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryItem> getAllSalaryItem() throws DAOException;

	/**
	 * @category 统计条数
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getSalaryItemCount(String condition) throws DAOException;

	/**
	 * @category 查找薪资项目并且分页
	 * @param firstResult
	 *            开始页
	 * @param maxResults
	 *            条数
	 * @param condition
	 *            参数
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryItem> getPagingSalaryItem(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 根据type=8 来查找薪资项目 type=8即：手工录入项目
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<SalaryItem> getSalaryItemByEigthType() throws DAOException;

	/**
	 * @category 查询薪资项目通过编码
	 * @return
	 * @throws DAOException
	 */
	public SalaryItem getSalaryItemByCode(String code) throws DAOException;

}
