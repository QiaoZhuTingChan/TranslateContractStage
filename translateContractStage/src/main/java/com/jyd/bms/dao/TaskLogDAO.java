package com.jyd.bms.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jyd.bms.bean.ScheduleType;
import com.jyd.bms.bean.TaskLog;
import com.jyd.bms.tool.exception.DAOException;

public interface TaskLogDAO extends HibernateBase<TaskLog> {
	/**
	 * 检查作业是否已经执行过
	 * 
	 * @param date
	 *            日期
	 * @param scheduleType
	 *            类型
	 * @return
	 * @throws DAOException
	 */
	public boolean checkTaskLogIsRun(Timestamp date, ScheduleType scheduleType) throws DAOException;
	
	public int getTaskLogCount(String condition) throws DAOException;
	
	public List<TaskLog> getPagingTaskLog(int firstResult,int maxResults,String condition) throws DAOException;
	
	public List<TaskLog> getPagingTaskLogParam(int firstResult,int maxResults,Map<String,Object> mapPara) throws DAOException,ParseException;
	
	public int getTaskLogParamCount(Map<String,Object> mapPara) throws DAOException,ParseException; 
}
