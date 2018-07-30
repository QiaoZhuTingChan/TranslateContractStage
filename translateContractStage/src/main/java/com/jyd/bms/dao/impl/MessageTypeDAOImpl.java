package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.DutyType;
import com.jyd.bms.bean.MessageType;

import com.jyd.bms.dao.MessageTypeDAO;
import com.jyd.bms.tool.exception.DAOException;
@Repository
public class MessageTypeDAOImpl extends HibernateBaseTemplate<MessageType> implements MessageTypeDAO {
	public int getMessageTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from MessageType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from MessageType where messageType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<MessageType> getPagingMessageType(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from MessageType";
		} else {
			hql = "from MessageType where messageType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<MessageType> getAllMessageType() throws DAOException {
		String hql = "";
		hql = "from MessageType";
		return super.getQueryResult(hql.toString());

	}

}
