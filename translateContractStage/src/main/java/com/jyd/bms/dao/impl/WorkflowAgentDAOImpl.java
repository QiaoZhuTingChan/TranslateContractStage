package com.jyd.bms.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.WorkflowAgent;
import com.jyd.bms.bean.WorkflowType;
import com.jyd.bms.dao.WorkflowAgentDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class WorkflowAgentDAOImpl extends HibernateBaseTemplate<WorkflowAgent> implements WorkflowAgentDAO {

	public List<WorkflowAgent> findWorkflowAgentByWorkflow(WorkflowType workflowType,List<Employee> emps) throws DAOException {
		Date now = Calendar.getInstance().getTime();
		String hql = "";
		hql = "from WorkflowAgent where workflowType = :workflowType and processEmployee in (:emps) and beginTime<=:now and endTime>=:now";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("workflowType", workflowType);
		map.put("emps", emps);
		map.put("now",now);
		
		return super.getQueryResult(hql, map);
	}
	
	public List<WorkflowAgent> findWorkflowAgentByEmps(List<Employee> emps) throws DAOException {
		Date now = Calendar.getInstance().getTime();
		String hql = "";
		hql = "from WorkflowAgent where workflowType is null and processEmployee in (:emps) and beginTime<=:now and endTime>=:now";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		//map.put("workflow", workflow);
		map.put("emps", emps);
		map.put("now", now);
		
		return super.getQueryResult(hql, map);
	}
	
	public List<WorkflowAgent> findWorkflowAgentByProcessEmp(List<Employee> emps) throws DAOException{
		Date now = Calendar.getInstance().getTime();
		String hql = "";
		hql = "from WorkflowAgent where processEmployee in (:emps) and beginTime<=:now and endTime>=:now";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		//map.put("workflow", workflow);
		map.put("emps", emps);
		map.put("now", now);
		
		return super.getQueryResult(hql, map);
	}
	
	public WorkflowAgent findWorkflowAgentByEmp(Employee emp) throws DAOException {
		Date now = Calendar.getInstance().getTime();
		String hql = "";
		hql = "from WorkflowAgent where workflowType is null and processEmployee = :emp and begin<=:now and end>=:now";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		//map.put("workflow", workflow);
		map.put("emp", emp);
		map.put("now", now);
		Object obj = super.getUniqueResult(hql, map);
		return obj == null ? null : (WorkflowAgent)obj;
		//return (WorkflowAgent) super.getUniqueResult(hql, map);
	}
	
	public List<WorkflowAgent> findWorkflowAgentByProcessEmp(Employee processEmp) throws DAOException{
		//Date now = Calendar.getInstance().getTime();
		String hql = "";
		hql = "from WorkflowAgent where processEmployee = :processEmp";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		//map.put("workflow", workflow);
		map.put("processEmp", processEmp);
		//map.put("now", now);
		
		return super.getQueryResult(hql, map);
	}

	/**
	 * @category 根据工作流和时间和代理人搜索所有代理人
	 * @param workflowType
	 * 工作流类型
	 * @param beginDate
	 * 开始时间
	 * @param endDate
	 * 结束时间
	 * @param agentEmp
	 * 代理人
	 * @return
	 * 返回代理人集合
	 * @throws DAOException
	 */
	@Override
	public List<WorkflowAgent> findWorkflowAgentByWorkflowTypeAndDate(Employee agentEmp, WorkflowType workflowType,
			Date beginDate, Date endDate) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if(workflowType!=null) {
			hql = "from WorkflowAgent where agentEmployee = :agentEmp and workflowType=:workflowType and beginTime>=:beginDate and endTime<=:endDate";
			map.put("workflowType", workflowType);
		}else {
			hql = "from WorkflowAgent where agentEmployee = :agentEmp and beginTime>=:beginDate and endTime<=:endDate";
		}
		map.put("agentEmp", agentEmp);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		return super.getQueryResult(hql, map);
	}
	
	

}
