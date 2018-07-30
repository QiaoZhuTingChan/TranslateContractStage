package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.WorkflowType;
import com.jyd.bms.bean.WorkflowTypeFlow;
import com.jyd.bms.dao.WorkflowTypeFlowDAO;
import com.jyd.bms.tool.exception.DAOException;
@Repository
public class WorkflowTypeFlowDAOImpl extends HibernateBaseTemplate<WorkflowTypeFlow> implements WorkflowTypeFlowDAO {
	/**
	 * 依据工作流类型获取工作流类型对应的表单及流程数据
	 * 
	 * @param workFlowType
	 *            工作流类型
	 * @return 工作流类型对应的表单及流程
	 * @throws DAOException
	 */
	public List<WorkflowTypeFlow> getWorkflowTypeFlowList(WorkflowType workFlowType) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();

		hql = "from WorkflowTypeFlow where workflowType = :workflowType";
		map.put("workflowType", workFlowType);

		return super.getQueryResult(hql.toString(), map);
	}

}
