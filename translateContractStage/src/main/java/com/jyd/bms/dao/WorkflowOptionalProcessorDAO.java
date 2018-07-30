package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.WorkflowOptionalProcessor;
import com.jyd.bms.bean.WorkflowStatus;
import com.jyd.bms.tool.exception.DAOException;

public interface WorkflowOptionalProcessorDAO extends HibernateBase<WorkflowOptionalProcessor> {
	
	public List<WorkflowOptionalProcessor> findWorkflowOptionalProcessorByWorkflowStatus(WorkflowStatus workflowStatus) throws DAOException;

}
