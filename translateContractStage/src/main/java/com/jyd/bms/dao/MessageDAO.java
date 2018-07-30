package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Message;
import com.jyd.bms.bean.MessageType;
import com.jyd.bms.tool.exception.DAOException;

public interface MessageDAO extends HibernateBase<Message> {
	public List<Message> findMessageByEmpAndState(Employee emp) throws DAOException;

	public int getMessageCountByEmpAndState(Employee emp) throws DAOException;

	public int findMessageCount(Employee emp, int state, String condition) throws DAOException;

	public List<Message> getPagingMessage(int firstResult, int maxResults, Employee emp, int state, String condition)
			throws DAOException;

}
