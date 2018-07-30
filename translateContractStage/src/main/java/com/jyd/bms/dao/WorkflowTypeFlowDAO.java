package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.WorkflowType;
import com.jyd.bms.bean.WorkflowTypeFlow;
import com.jyd.bms.tool.exception.DAOException;

public interface WorkflowTypeFlowDAO extends HibernateBase <WorkflowTypeFlow>{
	/**
	 * 依据工作流类型获取工作流类型对应的表单及流程数据
	 * 
	 * @param workFlowType
	 *            工作流类型
	 * @return 工作流类型对应的表单及流程
	 * @throws DAOException
	 */
	public List<WorkflowTypeFlow> getWorkflowTypeFlowList(WorkflowType workFlowType) throws DAOException;
}
