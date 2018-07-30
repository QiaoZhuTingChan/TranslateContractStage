package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.MessageType;
import com.jyd.bms.dao.MessageTypeDAO;
import com.jyd.bms.tool.exception.DAOException;
@Service("MessageTypeService")
public class MessageTypeService extends BaseService<MessageType> {
	@Autowired(required = true)
	private MessageTypeDAO messageTypeDAO;
	
	public int getMessageTypeCount(String condition) throws DAOException {
		return messageTypeDAO.getMessageTypeCount(condition);
	}
	
	public List<MessageType> getPagingMessageType(int firstResult, int maxResults, String condition) throws DAOException{
		return messageTypeDAO.getPagingMessageType(firstResult, maxResults, condition);
	}
	
	public List<MessageType> getAllMessageType() throws DAOException{
		return messageTypeDAO.getAllMessageType();
	}

	@Override
	public void setDAO() {
		// TODO Auto-generated method stub
		this.baseDAO = messageTypeDAO;
	}
	
	
}
