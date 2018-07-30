package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.WorkflowData;
import com.jyd.bms.dao.WorkflowDataDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category 工作流数据具体实现类
 * @author hong
 */
@Repository
public class WorkflowDataDAOImpl extends HibernateBaseTemplate<WorkflowData> implements WorkflowDataDAO {
	/**
	 * @category 通过key查找工作流数据的value
	 * @param String
	 *            key
	 * @return 工作流表单值
	 */
	public String findWorkflowDataValue(String key) throws DAOException {
		String hql = "";
		hql = "select value from WorkflowData where key = :key";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("key", key);
		List<String> list = super.getQueryResult(hql, map);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 更新Key对应的值
	 * @param kye 键
	 * @param value 值
	 * @throws DAOException
	 */
	public void updateWorkflowDataValue(String key, String value) throws DAOException {
		String hql = "update WorkflowData set value =:value where key = :key";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("key", key);
		map.put("value", value);
		super.executeUpdate(hql, map);
	}
}
