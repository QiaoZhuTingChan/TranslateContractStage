package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Workflow;
import com.jyd.bms.dao.WorkflowDAO;
import com.jyd.bms.dao.WorkfowStatusDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("WorkflowService")
public class WorkflowService extends BaseService<Workflow> {
	@Autowired(required = true)
	private WorkflowDAO workflowDAO;
	@Autowired(required = true)
	private WorkfowStatusDAO workflowStatusDAO;

	/**
	 * 获取员工可参与的流程
	 * @param firstResult 起始页
	 * @param maxResults 尾页
	 * @param emp 员工
	 * @param condition 流程状态
	 * @return 流程列表
	 */
	public List<Workflow> getWorkflowByProcessor(int firstResult, int maxResults, Employee emp,String type, String condition)
			throws Exception {
		List<Workflow> workflows = workflowDAO.findWorkflowByProcessorAndState(emp,type, condition, firstResult, maxResults);
		// if(workflows.isEmpty()) {
		// throw new Exception("There is no workflow!");
		// }
		return workflows;
	}

	/**
	 * 根据状态获取流程
	 * @param firstResult 起始页
	 * @param maxResults 尾页
	 * @param state 流程状态
	 * @param message 参数
	 * @return 流程列表
	 */
	public List<Workflow> getWorkflowByState(int firstResult, int maxResults, int state, String message)
			throws Exception {
		List<Workflow> workflows = workflowDAO.findWorkflowByState(state, message, firstResult, maxResults);
		// if(workflows.isEmpty()) {
		// throw new Exception("There is no workflow!");
		// }
		return workflows;
	}

	/**
	 * 获取员工可参与的流程数目
	 * @param processor 员工
	 * @param condition 流程状态	 
	 * @return 流程数目
	 */
	public int getWorkflowProcessorCount(Employee processor,String type, String condition) throws DAOException {
		return workflowDAO.getWorkflowProcessorCount(processor,type, condition);
	}

	/**
	 * 根据状态和参数获取流程数目
	 * @param state 流程状态
	 * @param condition 参数	 
	 * @return 流程数目
	 */
	public int getWorkflowStateCount(int state, String condition) throws DAOException {
		return workflowDAO.getWorkflowStateCount(state, condition);
	}

	@Override
	public void setDAO() {
		this.baseDAO = workflowDAO;
	}
}
