package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.PositionType;
import com.jyd.bms.tool.exception.DAOException;

public interface PositionTypeDAO extends HibernateBase<PositionType> {
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getPositionTypeCount(String condition) throws DAOException;

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<PositionType> getPagingPositionType(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * 查询所有职位
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<PositionType> getAllPositionType() throws DAOException;

	/**
	 * 通过名字查找职位
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public PositionType getPositionTypeByName(String condition) throws DAOException;

	/**
	 * 根据部门获取职位
	 * 
	 * @param department
	 * @return
	 */
	public List<PositionType> getPositionsByDepartment(String department);

	public List<PositionType> getPositionTypeByPara(String condition) throws DAOException;
}
