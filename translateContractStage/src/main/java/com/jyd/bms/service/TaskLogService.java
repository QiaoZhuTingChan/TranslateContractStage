package com.jyd.bms.service;


import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ScheduleType;
import com.jyd.bms.bean.TaskLog;

import com.jyd.bms.dao.ScheduleTypeDAO;
import com.jyd.bms.dao.TaskLogDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("TaskLogService")
public class TaskLogService extends BaseService<TaskLog>{
	@Autowired(required = true)
	private ScheduleTypeDAO scheduleTypeDAO;
	@Autowired(required = true)
	private TaskLogDAO taskLogDAO;
	
	public int getTaskLogCount(String condition) throws DAOException{
		return taskLogDAO.getTaskLogCount(condition);
	}

	
	public int getTaskLogParamCount(Map<String,Object> mapPara) throws DAOException,ParseException{
		return taskLogDAO.getTaskLogParamCount(mapPara);
	}
	
	
	public List<TaskLog> getPagingTaskLog(int firstResult,int maxResults,String condition) throws DAOException{
		return taskLogDAO.getPagingTaskLog(firstResult, maxResults, condition);
	}
	
	public List<TaskLog> getPagingTaskLogParam(int firstResult,int maxResults,Map<String,Object> mapPara) throws DAOException,ParseException{
		return taskLogDAO.getPagingTaskLogParam(firstResult, maxResults, mapPara);
	}
	
	@Override
	public void setDAO() {
		this.baseDAO=taskLogDAO;
		
	}

}
