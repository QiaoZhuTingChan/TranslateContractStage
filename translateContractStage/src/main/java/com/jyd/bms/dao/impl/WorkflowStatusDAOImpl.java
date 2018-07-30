package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Workflow;
import com.jyd.bms.bean.WorkflowStatus;
import com.jyd.bms.dao.WorkfowStatusDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class WorkflowStatusDAOImpl extends HibernateBaseTemplate<WorkflowStatus> implements WorkfowStatusDAO {
	/**
	 * 依据工作流获取工作流状态数据
	 * 
	 * @param workFlow
	 *            工作流
	 * @return 工作流状态
	 * @throws DAOException
	 */
	public List<WorkflowStatus> getWorkflowStatusList(Workflow workFlow) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		hql = "from WorkflowStatus where workflow = :workflow";
		map.put("workflow", workFlow);
		return super.getQueryResult(hql.toString(), map);
	}

	public List<WorkflowStatus> findWorkflowStatusByWorkflowAndProcessor(Workflow workflow, Employee processor)
			throws DAOException {
		String hql = "";
		hql = "from WorkflowStatus where workflow = :workflow and processEmployee = :processor";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("workflow", workflow);
		map.put("processor", processor);
		return super.getQueryResult(hql, map);
	}
	
	public List<WorkflowStatus> findWorkflowStatusByWorkflow(Workflow workflow) throws DAOException{
		String hql = "";
		hql = "from WorkflowStatus where workflow = :workflow";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("workflow", workflow);
		return super.getQueryResult(hql, map);
	}

}
