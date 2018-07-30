package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Record;
import com.jyd.bms.dao.RecordDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class RecordDAOImpl extends HibernateBaseTemplate<Record> implements RecordDAO {

	@SuppressWarnings("unchecked")
	public List<Record> getAllRecord() throws DAOException {
		String hql = "";
		hql = "from Record";
		return super.getQueryResult(hql.toString());

	}

	@SuppressWarnings("unchecked")
	@Override
	public int getRecordCount(String condition) throws DAOException {
		String hql = "";
		if (condition.trim().equals("")) {
			hql = "select count(*) from Record";
			List<Long> recordList = super.getQueryResult(hql);
			return recordList.get(0).intValue();
		} else {
			hql = "select count(*) from Record where employee.name like :condition";
			Map<String, String> parameterMap = new HashMap<String, String>();
			parameterMap.put("condition", "%" + condition + "%");
			List<Long> recordList = super.getQueryResult(hql, parameterMap);
			return recordList.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Record> getPagingRecords(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		Map<String, String> parameterMap = new HashMap<String, String>();
		if (condition.trim().equals("")) {
			hql = "from Record";
		} else {
			hql = "from Record where employee.name like :condition";
			parameterMap.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql, parameterMap, firstResult, maxResults);
	}

	@Override
	public List<Record> getRecordByEmployee(int firstResult, int maxResults, String condition,Employee emp) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		map.put("emp", emp);
		if(condition.equals("")) {
			map.put("condition", "%"+condition+"%");
			hql = "FROM Record where employee =:emp group by customerContract";
		}else {
			hql = "FROM Record where employee =:emp group by customerContract";
		}
		return super.getPagingQueryResult(hql, map, firstResult, maxResults);
	}
}
