package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.WorkflowType;
import com.jyd.bms.dao.WorkflowTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("WorkflowTypeService")
public class WorkflowTypeService extends BaseService<WorkflowType> {
	@Autowired(required = true)
	private WorkflowTypeDAO workflowTypeDAO;

	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public int getWorkflowTypeCount(String condition) throws DAOException {
		return workflowTypeDAO.getWorkflowTypeCount(condition);
	}

	/**
	 * 按查询条件获取分页记录
	 * 
	 * @param firstResult
	 *            开始行
	 * @param maxResults
	 *            结束行
	 * @param condition
	 *            查询条件
	 * @return 分页数据
	 * @throws DAOException
	 */
	public List<WorkflowType> getPagingWorkflowType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return workflowTypeDAO.getPagingWorkflowType(firstResult, maxResults, condition);
	}

	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public List<WorkflowType> getAllWorkflowType() throws DAOException {
		return workflowTypeDAO.getAllWorkflowType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = workflowTypeDAO;
	}
}
