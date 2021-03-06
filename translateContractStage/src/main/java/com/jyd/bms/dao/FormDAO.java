package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Form;
import com.jyd.bms.tool.exception.DAOException;

public interface FormDAO extends HibernateBase<Form> {
	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public int getFormCount(String condition) throws DAOException;

	/**
	 * 按查询条件获取分页记录
	 * 
	 * @param firstResult
	 *            开始行
	 * @param maxResults
	 *            结束行
	 * @param condition
	 *            查询条件
	 * @return 分页数据
	 * @throws DAOException
	 */
	public List<Form> getPagingForm(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * 获取所有记录
	 * 
	 * @return 所有记录
	 * @throws DAOException
	 */
	public List<Form> getAllForm() throws DAOException;

	/**
	 * 按表单名称获取记录
	 * 
	 * @param name
	 *            表单名称
	 * @return 表单
	 * @throws DAOException
	 */
	public List<Form> getFormByName(String name) throws DAOException;
}
