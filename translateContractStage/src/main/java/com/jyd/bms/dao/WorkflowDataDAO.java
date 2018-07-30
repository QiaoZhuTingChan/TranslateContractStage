package com.jyd.bms.dao;


import com.jyd.bms.bean.WorkflowData;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.UpdateException;
/**
 * 
 * @author hong
 * @category 工作流数据接口
 */
public interface WorkflowDataDAO extends HibernateBase <WorkflowData>{
	
	/**
	 * @category 依据键查找工作流数据值
	 * @param key 键
	 * @return　值
	 * @throws DAOException
	 */
	public String findWorkflowDataValue(String key) throws DAOException;
	/**
	 * 更新Key对应的值
	 * @param kye 键
	 * @param value 值
	 * @throws DAOException
	 */
	public void updateWorkflowDataValue(String key,String value) throws DAOException;

}
