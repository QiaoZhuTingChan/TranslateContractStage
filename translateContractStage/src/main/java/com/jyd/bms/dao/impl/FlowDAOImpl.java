package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jyd.bms.bean.Flow;
import com.jyd.bms.dao.FlowDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class FlowDAOImpl extends HibernateBaseTemplate<Flow> implements FlowDAO {
	/**
	 * 按查询条件获取记录条数
	 * 
	 * @param condition
	 * @return 记录条数
	 * @throws DAOException
	 */
	public int getFlowCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Flow";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Flow where name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
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
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Flow";
		} else {
			hql = "from Flow where name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	/**
	 * 获取所有记录
	 * 
	 * @return 所有记录
	 * @throws DAOException
	 */
	public List<Flow> getAllFlow() throws DAOException {
		String hql = "from Flow";
		return super.getQueryResult(hql.toString());
	}

	/**
	 * 按流程名称获取记录
	 * 
	 * @param name
	 *            流程名称
	 * @return 流程
	 * @throws DAOException
	 */
	@Transactional
	public List<Flow> getFlowByName(String name) throws DAOException {
		String hql = "from Flow where name = :name";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("name", name);
		List<Flow> list = super.getQueryResult(hql, map);
		return list;
	}

}
