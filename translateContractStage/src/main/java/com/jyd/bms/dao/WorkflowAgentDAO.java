package com.jyd.bms.dao;

import java.util.Date;
import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.WorkflowAgent;
import com.jyd.bms.bean.WorkflowType;
import com.jyd.bms.tool.exception.DAOException;

public interface WorkflowAgentDAO extends HibernateBase<WorkflowAgent> {
	
	public List<WorkflowAgent> findWorkflowAgentByWorkflow(WorkflowType workflowType,List<Employee> emps) throws DAOException;
	
	public List<WorkflowAgent> findWorkflowAgentByEmps(List<Employee> emps) throws DAOException;
	
	public List<WorkflowAgent> findWorkflowAgentByProcessEmp(List<Employee> emps) throws DAOException;
	
	public WorkflowAgent findWorkflowAgentByEmp(Employee emp) throws DAOException;
	
	public List<WorkflowAgent> findWorkflowAgentByProcessEmp(Employee processEmp) throws DAOException;
	
	/**
	 * @category 根据工作流和时间和代理人搜索所有代理人
	 * @param workflowType
	 * 工作流类型
	 * @param beginDate
	 * 开始时间
	 * @param endDate
	 * 结束时间
	 * @param agentEmp
	 * 代理人
	 * @return
	 * 返回代理人集合
	 * @throws DAOException
	 */
	public List<WorkflowAgent> findWorkflowAgentByWorkflowTypeAndDate(Employee agentEmp,WorkflowType workflowType,Date beginDate,Date endDate) throws DAOException;
		
}
