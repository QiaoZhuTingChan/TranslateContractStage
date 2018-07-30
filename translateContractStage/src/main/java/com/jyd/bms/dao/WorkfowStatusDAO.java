package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Workflow;
import com.jyd.bms.bean.WorkflowStatus;
import com.jyd.bms.tool.exception.DAOException;

public interface WorkfowStatusDAO extends HibernateBase <WorkflowStatus>{
	/**
	 * 依据工作流获取工作流状态数据
	 * 
	 * @param workFlow
	 *            工作流
	 * @return 工作流状态
	 * @throws DAOException
	 */
	public List<WorkflowStatus> getWorkflowStatusList(Workflow workFlow) throws DAOException;
	
	public List<WorkflowStatus> findWorkflowStatusByWorkflowAndProcessor(Workflow workflow,Employee processor) throws DAOException;
	
	public List<WorkflowStatus> findWorkflowStatusByWorkflow(Workflow workflow) throws DAOException;
		
	
}
