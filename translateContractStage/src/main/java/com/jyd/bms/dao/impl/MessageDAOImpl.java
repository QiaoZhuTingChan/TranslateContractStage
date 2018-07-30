package com.jyd.bms.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.DutyType;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Message;
import com.jyd.bms.bean.MessageType;
import com.jyd.bms.dao.MessageDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class MessageDAOImpl extends HibernateBaseTemplate<Message> implements MessageDAO {

	public List<Message> findMessageByEmpAndState(Employee emp) throws DAOException{
		String hql = "";
		hql = "from Message where employee = :emp and state = 0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		return super.getQueryResult(hql, map);

	}
	
	public int getMessageCountByEmpAndState(Employee emp) throws DAOException {
		String hql = "";
		hql = "select count(*) from Message where employee = :emp and state = 0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("emp", emp);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}
	
	public int findMessageCount(Employee emp,int state,String condition) throws DAOException {
		String hql = "";
		if(condition==null) {
			hql = "select count(*) from Message where employee = :emp and state = :state";
			Map map = new HashMap();
			map.put("emp", emp);
			map.put("state", state);
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}else {
			hql = "select count(*) from Message where employee = :emp and state = :state and (messageType.messageType like :condition or messageContent like :condition) ";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("emp", emp);
			map.put("state", state);
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}
	
	public List<Message> getPagingMessage(int firstResult, int maxResults, Employee emp,int state,String condition) throws DAOException{
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition==null) {
			hql = "from Message where employee = :emp and state = :state";
			map.put("emp", emp);
			map.put("state", state);
		} else {
			hql = "from Message where employee = :emp and state = :state and (messageType.messageType like :condition or messageContent like :condition) order by createDate desc";
			map.put("emp", emp);
			map.put("state", state);
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

}
