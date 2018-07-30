package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.WorkflowOptionalProcessor;
import com.jyd.bms.bean.WorkflowStatus;
import com.jyd.bms.dao.WorkflowOptionalProcessorDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class WorkflowOptionalProcessorDAOImpl extends HibernateBaseTemplate<WorkflowOptionalProcessor>
		implements WorkflowOptionalProcessorDAO {
	
	public List<WorkflowOptionalProcessor> findWorkflowOptionalProcessorByWorkflowStatus(WorkflowStatus workflowStatus) throws DAOException{
		String hql = "";
		hql = "from WorkflowOptionalProcessor where workflowStatus = :workflowStatus";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("workflowStatus", workflowStatus);
		return super.getQueryResult(hql, map);
	}

}
