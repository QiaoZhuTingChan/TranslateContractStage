package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.WorkflowOptionalProcessor;
import com.jyd.bms.bean.WorkflowStatus;
import com.jyd.bms.dao.WorkflowOptionalProcessorDAO;

import com.jyd.bms.tool.exception.DAOException;

@Service("WorkflowOptionalProcessorService")
public class WorkflowOptionalProcessorService extends BaseService<WorkflowOptionalProcessor> {
	@Autowired(required = true)
	private WorkflowOptionalProcessorDAO workflowOptionalProcessorDAO;
	
	public List<WorkflowOptionalProcessor> getWorkflowOptionalProcessorByWorkflowStatus(WorkflowStatus workflowStatus) throws DAOException{
		return workflowOptionalProcessorDAO.findWorkflowOptionalProcessorByWorkflowStatus(workflowStatus);
	}

	@Override
	public void setDAO() {
		this.baseDAO = workflowOptionalProcessorDAO;
	}
}
