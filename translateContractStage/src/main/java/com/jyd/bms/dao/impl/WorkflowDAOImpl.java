package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Workflow;
import com.jyd.bms.dao.WorkflowDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category 工作流DAO具体实现
 * @author hong
 */
@Repository
public class WorkflowDAOImpl extends HibernateBaseTemplate<Workflow> implements WorkflowDAO {
	/**
	 * @category 依据状态和参数统计工作流
	 * @param Int
	 *            state 状态
	 * @param String
	 *            condition 参数
	 * @return 工作流数量
	 * @throws DAOException
	 */
	public int getWorkflowStateCount(int state, String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Workflow where state = :state";
			Map map = new HashMap();
			map.put("state", state);
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Workflow where state = :state and remark like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("state", state);
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	/**
	 * @category 依据员工和参数统计工作流
	 * @param Employee
	 *            processor 员工
	 * @param String
	 *            condition 参数
	 * @return 工作流数量
	 * @throws DAOException
	 */
	public int getWorkflowProcessorCount(Employee processor, String type, String condition) throws DAOException {
		String hql = "";
		condition = "%" + condition + "%";
		if (type.equals("退回")) {
			hql = "select count(*) from Workflow workflow inner join workflow.workflowStatuss workflowStatus inner join workflowStatus.workflowOptionalProcessors workflowOptionalProcessor where workflowOptionalProcessor.employee = :processor and workflow.state=2 and workflow.remark like :condition group by workflow.id";
		} else if (type.equals("已审批")) {
			hql = "select count(*) from Workflow workflow inner join workflow.workflowStatuss workflowStatus where workflowStatus.processEmployee = :processor and workflowStatus.endTime is not null and workflow.state!=-1 and workflow.remark like :condition group by workflow.id";
		} else if (type.equals("已到达未审批")) {
			hql = "select count(*) from Workflow workflow inner join workflow.workflowStatuss workflowStatus inner join workflowStatus.workflowOptionalProcessors workflowOptionalProcessor where workflowOptionalProcessor.employee = :processor and workflowStatus.arriveTime is not null and workflowStatus.endTime is null and workflow.state!=-1 and workflow.remark like :condition group by workflow.id";
		} else if (type.equals("未到达未审批")) {
			hql = "select count(*) from Workflow workflow inner join workflow.workflowStatuss workflowStatus inner join workflowStatus.workflowOptionalProcessors workflowOptionalProcessor where workflowOptionalProcessor.employee = :processor and workflowStatus.arriveTime is null and workflow.state!=-1 and workflow.remark like :condition group by workflow.id";
		}
		Map map = new HashMap();
		map.put("processor", processor);
		map.put("condition", condition);
		List<Long> lstCount = super.getQueryResult(hql, map);
		if (lstCount.isEmpty()) {
			return 0;
		}
		return lstCount.size();
	}

	public List<Workflow> getPagingWorkflow(int firstResult, int maxResults, String condition) throws DAOException {
		return null;
	}

	public List<Workflow> getAllForm() throws DAOException {
		return null;
	}

	/**
	 * @category 依据状态和参数和起始页查找工作流
	 * @param Int
	 *            state 状态
	 * @param String
	 *            condition 参数
	 * @param Int
	 *            firstResult 起始页
	 * @return List<Workflow> 工作流集合
	 * @throws DAOException
	 */
	public List<Workflow> findWorkflowByState(int state, String condition, int firstResult, int maxResults)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		hql = "from Workflow where state = :state and remark like :condition order by createDate desc";
		map.put("state", state);
		map.put("condition", "%" + condition + "%");
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	/**
	 * @category 依据员工和参数和分页查找工作流
	 * @param Employee
	 *            processor 员工
	 * @param String
	 *            condition 参数
	 * @param int
	 *            firstResult 开始页
	 * @param int
	 *            maxResults 结束页
	 * @return 工作流集合
	 * @throws DAOException
	 */
	public List<Workflow> findWorkflowByProcessorAndState(Employee processor, String type, String condition,
			int firstResult, int maxResults) throws DAOException {
		String hql = "";
		condition = "%" + condition + "%";
		if (type.equals("退回")) {
			hql = "select workflow from Workflow workflow inner join workflow.workflowStatuss workflowStatus inner join workflowStatus.workflowOptionalProcessors workflowOptionalProcessor where workflowOptionalProcessor.employee = :processor and workflow.state=2 and workflow.remark like :condition group by workflow.id order by workflow.createDate desc";
		} else if (type.equals("已审批")) {
			hql = "select workflow from Workflow workflow inner join workflow.workflowStatuss workflowStatus where workflowStatus.processEmployee = :processor and workflowStatus.endTime is not null and workflow.state!=-1 and workflow.remark like :condition group by workflow.id order by workflow.createDate desc";
		} else if (type.equals("已到达未审批")) {
			hql = "select workflow from Workflow workflow inner join workflow.workflowStatuss workflowStatus inner join workflowStatus.workflowOptionalProcessors workflowOptionalProcessor where workflowOptionalProcessor.employee = :processor and workflowStatus.arriveTime is not null and workflowStatus.endTime is null and workflow.state!=-1 and workflow.remark like :condition group by workflow.id order by workflow.createDate desc";
		} else if (type.equals("未到达未审批")) {
			hql = "select workflow from Workflow workflow inner join workflow.workflowStatuss workflowStatus inner join workflowStatus.workflowOptionalProcessors workflowOptionalProcessor where workflowOptionalProcessor.employee = :processor and workflowStatus.arriveTime is null and workflow.state!=-1 and workflow.remark like :condition group by workflow.id order by workflow.createDate desc";
		}
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("processor", processor);
		map.put("condition", condition);
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}
}
