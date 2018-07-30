package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Flow;
import com.jyd.bms.dao.FlowDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("FlowService")
public class FlowService extends BaseService<Flow> {
	@Autowired(required = true)
	private FlowDAO flowDAO;

	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public int getFlowCount(String condition) throws DAOException {
		return flowDAO.getFlowCount(condition);
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
	public List<Flow> getPagingFlow(int firstResult, int maxResults, String condition) throws DAOException {
		return flowDAO.getPagingFlow(firstResult, maxResults, condition);
	}

	/**
	 * 获取所有记录
	 * 
	 * @return 所有记录
	 * @throws DAOException
	 */
	public List<Flow> getAllFlow() throws DAOException {
		return flowDAO.getAllFlow();
	}

	public List<Flow> getFlowByName(String name) throws DAOException {
		return flowDAO.getFlowByName(name);
	}

	@Override
	public void setDAO() {
		this.baseDAO = flowDAO;
	}

}
