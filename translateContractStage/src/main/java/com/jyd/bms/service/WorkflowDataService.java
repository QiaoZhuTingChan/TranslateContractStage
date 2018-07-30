package com.jyd.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.WorkflowData;
import com.jyd.bms.common.Environment;
import com.jyd.bms.dao.WorkflowDataDAO;
import com.jyd.bms.tool.JedisUtil;
import com.jyd.bms.tool.exception.CreateException;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.UpdateException;

@Service("WorkflowDataService")
public class WorkflowDataService extends BaseService<WorkflowData> {
	@Autowired(required = true)
	private WorkflowDataDAO workflowDataDAO;

	/**
	 * 获取流程数据值，当redis服务器有数据，直接从redis服务器拿数据
	 * 
	 * @param key
	 *            流程数据键
	 * @return 流程数据值
	 */
	public String getWorkflowDataValue(String key) throws DAOException {
		if (Environment.getRedisOnService() == true) {
			JedisUtil jedisUtil = JedisUtil.getInstance();
			JedisUtil.Strings strings = jedisUtil.new Strings();

			String value = strings.get(key);
			if (value != null)
				return value;
		}

		return workflowDataDAO.findWorkflowDataValue(key);
	}
	/**
	 * 更新Key对应的值
	 * @param kye 键
	 * @param value 值
	 * @throws DAOException
	 */
	public void updateWorkflowDataValue(String key,String value) throws DAOException{
		if (Environment.getRedisOnService() == true) {
			JedisUtil jedisUtil = JedisUtil.getInstance();
			JedisUtil.Strings strings = jedisUtil.new Strings();
			strings.set(key, value);
		}
		
		workflowDataDAO.updateWorkflowDataValue(key, value);
	}
	
	/**
	 * 保存WorkflowData，当redis服务器处于服务状态时，保存一份到redis服务器
	 * @param key
	 * @param value
	 * @throws CreateException
	 */
	public void saveWorkflowData(String key, String value) throws CreateException {
		if (Environment.getRedisOnService() == true) {
			JedisUtil jedisUtil = JedisUtil.getInstance();
			JedisUtil.Strings strings = jedisUtil.new Strings();

			strings.set(key, value);
		}

		WorkflowData data = new WorkflowData();
		data.setKey(key);
		data.setValue(value);
		workflowDataDAO.add(data);
	}

	@Override
	public void setDAO() {
		this.baseDAO = workflowDataDAO;
	}

}
