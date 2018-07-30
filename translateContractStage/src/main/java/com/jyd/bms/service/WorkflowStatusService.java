package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Workflow;
import com.jyd.bms.bean.WorkflowStatus;
import com.jyd.bms.dao.WorkfowStatusDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("WorkflowStatusService")
public class WorkflowStatusService extends BaseService<WorkflowStatus> {
	@Autowired(required = true)
	private WorkfowStatusDAO workflowStatusDAO;
	
	public List<WorkflowStatus> getWorkflowStatusByWorkfow(Workflow workflow) throws DAOException{
		return workflowStatusDAO.findWorkflowStatusByWorkflow(workflow);
	}

	@Override
	public void setDAO() {
		this.baseDAO = workflowStatusDAO;
	}
}
