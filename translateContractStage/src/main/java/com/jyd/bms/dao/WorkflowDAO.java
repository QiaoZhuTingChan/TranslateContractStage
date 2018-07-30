package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Workflow;
import com.jyd.bms.tool.exception.DAOException;
/**
 * 
 * @author hong
 * @category 工作流接口
 */
public interface WorkflowDAO extends HibernateBase <Workflow>{
	/**
	 * @category 依据状态和查询参数统计工作流
	 * @param state　状态
	 * @param condition　查询参数
	 * @return　统计工作流数量
	 * @throws DAOException
	 */
	public int getWorkflowStateCount(int state, String condition) throws DAOException;
	/**
	 * @category 依据员工和查询参数统计工作流
	 * @param processor　员工
	 * @param condition　查询参数
	 * @return　工作流数
	 * @throws DAOException
	 */
	public int getWorkflowProcessorCount(Employee processor,String type, String condition) throws DAOException;

	/**
	 * @category 依据分页和查询参数查询工作流集合
	 * @param firstResult　开始页
	 * @param maxResults　结束页
	 * @param condition　查询参数
	 * @return　工作流集合
	 * @throws DAOException
	 */
	public List<Workflow> getPagingWorkflow(int firstResult, int maxResults, String condition) throws DAOException;

	/**
	 * @category 查询所有表单
	 * @return　表单集合
	 * @throws DAOException
	 */
	public List<Workflow> getAllForm() throws DAOException;
	
	public List<Workflow> findWorkflowByState(int state, String condition, int firstResult, int maxResults) throws DAOException;
	
	public List<Workflow> findWorkflowByProcessorAndState(Employee processor,String type, String condition, int firstResult, int maxResults) throws DAOException;
}
