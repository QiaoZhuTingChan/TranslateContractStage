package com.jyd.bms.dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ScheduleType;
import com.jyd.bms.bean.TaskLog;
import com.jyd.bms.common.StaticVariable;
import com.jyd.bms.dao.TaskLogDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class TaskLogDAOImpl extends HibernateBaseTemplate<TaskLog> implements TaskLogDAO {

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
	public boolean checkTaskLogIsRun(Timestamp date, ScheduleType scheduleType) throws DAOException {
		String hql = "from TaskLog where runDate = :date and scheduleType = :scheduleType";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("date", date);
		map.put("scheduleType", scheduleType);
		List<TaskLog> list = super.getQueryResult(hql, map);
		if (list.size() > 0)
			return true;
		else
			return false;
	}

	@Override
	public int getTaskLogCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from TaskLog order by runDate desc";
			List<Long> lis = super.getQueryResult(hql);
			return lis.get(0).intValue();
		} else {
			hql = "select count(*) from TaskLog where scheduleType=:condition order by runDate desc";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", condition);
			List<Long> lis = super.getQueryResult(hql, map);
			return lis.get(0).intValue();
		}
	}

	@Override
	public List<TaskLog> getPagingTaskLog(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from TaskLog order by runDate desc";
		} else {
			hql = "from TaskLog where scheduleType=:condition order by runDate desc";
			map.put("condition", condition);
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@Override
	public List<TaskLog> getPagingTaskLogParam(int firstResult, int maxResults, Map<String, Object> mapPara)
			throws DAOException, ParseException {
		StringBuilder hql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> map = new HashMap<>();
		hql.append("from TaskLog where 1=1");

		String condition = mapPara.get("condition").toString();
		String beginDate = mapPara.get("beginDate").toString();
		String endDate = mapPara.get("endDate").toString();
		int type = (int) mapPara.get("type");
		if (type != 0) {

			if (type == StaticVariable.JOB_LATE_FEE) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_MONTHLY_STATEMENT) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_WEEKS_STATEMENT) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_GPS) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_LATE_STAGE_EMAIL) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_RECORD_PERSON) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
		} else if (type == StaticVariable.JOB_PLEASE_SELECT) {

		}

		if (!beginDate.equals("")) {
			map.put("startDate", sdf.parse(beginDate));
			hql.append(" and runDate >=:startDate");
		}
		if (!endDate.equals("")) {
			map.put("endDate", sdf.parse(endDate));
			hql.append(" and runDate <=:endDate");
		}
		hql.append(" order by runDate desc");
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@Override
	public int getTaskLogParamCount(Map<String, Object> mapPara) throws DAOException, ParseException {
		StringBuilder hql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> map = new HashMap<>();

		hql.append("select count(1) from TaskLog where 1=1");
		String condition = mapPara.get("condition").toString();
		String beginDate = mapPara.get("beginDate").toString();
		String endDate = mapPara.get("endDate").toString();
		int type = (int) mapPara.get("type");
		if (type != 0) {

			if (type == StaticVariable.JOB_LATE_FEE) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_MONTHLY_STATEMENT) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_WEEKS_STATEMENT) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_GPS) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_LATE_STAGE_EMAIL) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
			if (type == StaticVariable.JOB_RECORD_PERSON) {
				hql.append(" and scheduleType.id=:scheduleType");
				map.put("scheduleType", type);
			}
		} else if (type == StaticVariable.JOB_PLEASE_SELECT) {

		}

		if (!beginDate.equals("")) {
			map.put("startDate", sdf.parse(beginDate));
			hql.append(" and runDate >=:startDate");
		}
		if (!endDate.equals("")) {
			map.put("endDate", sdf.parse(endDate));
			hql.append(" and runDate <=:endDate");
		}
		List<Long> lis = super.getQueryResult(hql.toString(), map);
		return lis.get(0).intValue();
	}

}
