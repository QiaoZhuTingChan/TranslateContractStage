package com.jyd.bms.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.WorkflowAgent;
import com.jyd.bms.bean.WorkflowType;
import com.jyd.bms.dao.WorkflowAgentDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("WorkflowAgentService")
public class WorkflowAgentService extends BaseService<WorkflowAgent> {
	@Autowired(required = true)
	private WorkflowAgentDAO workflowAgentDAO;

	public List<WorkflowAgent> getAgentByProcessEmp(Employee processEmp) throws DAOException{
		//List<Employee> agents = new ArrayList<Employee>();
		List<WorkflowAgent> workflowAgents = workflowAgentDAO.findWorkflowAgentByProcessEmp(processEmp);
		//if(workflowAgents.isEmpty()) {
			//return null;
		//}else {
		//	for(WorkflowAgent workflowAgent : workflowAgents) {
		//		agents.add(workflowAgent.getAgentEmp());
		//	}
		//}
		return workflowAgents;
	}

	public List<WorkflowAgent> findWorkflowAgentByWorkflowTypeAndDate(Employee agentEmp, WorkflowType workflowType,
			Date beginDate, Date endDate) throws DAOException {
		return workflowAgentDAO.findWorkflowAgentByWorkflowTypeAndDate(agentEmp, workflowType, beginDate, endDate);
	}
	@Override
	public void setDAO() {
		this.baseDAO = workflowAgentDAO;
	}

}
