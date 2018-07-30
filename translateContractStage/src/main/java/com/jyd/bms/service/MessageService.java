/*package com.jyd.bms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zkoss.zkplus.spring.SpringUtil;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Message;
import com.jyd.bms.bean.MessageData;
import com.jyd.bms.common.Environment;
import com.jyd.bms.dao.MessageDAO;
import com.jyd.bms.dao.MessageDataDAO;
import com.jyd.bms.dto.ServerMessage;
import com.jyd.bms.message.MessageSender;
import com.jyd.bms.tool.exception.CreateException;
import com.jyd.bms.tool.exception.DAOException;

@Service("MessageService")
public class MessageService extends BaseService<Message> {
	@Autowired(required = true)
	private MessageDAO messageDAO;

	@Autowired(required = true)
	private MessageDataDAO messageDataDAO;

	*//**
	 * 保存消息
	 * 
	 * @param message
	 *            消息
	 * @param data
	 *            保存到redis的值
	 * @return 保存的结果
	 * @throws DAOException
	 *//*
	public boolean saveMessage(Message message, String data) throws CreateException, DAOException {
		String key = UUID.randomUUID().toString().replaceAll("-", "");
		message.setMessageKey(key);
		MessageData messageData = new MessageData();
		messageData.setKey(message.getMessageKey());
		messageData.setValue(data);
		messageDataDAO.add(messageData);
		messageDAO.add(message);

		ServerMessage serverMessage = new ServerMessage();
		serverMessage.setType("newMessage");
		serverMessage.setContent(message.getMessageContent());
		serverMessage.setMessageId(message.getId());

		MessageSender messageSender = new MessageSender();
		messageSender.sendMessageToUser(serverMessage,message.getEmployee().getId() );
		
		int total = getMessageCountByEmpAndState(message.getEmployee());
		ServerMessage serverMessageTotal = new ServerMessage();
		serverMessageTotal.setType("totalMessage");
		serverMessageTotal.setContent(String.valueOf(total));
		messageSender.sendMessageToUser(serverMessageTotal,message.getEmployee().getId() );

		return true;
	}

	*//**
	 * 获取员工未处理消息
	 * 
	 * @param emp
	 *            员工
	 * @return 消息列表
	 *//*
	public List<Message> getMessageByEmpAndState(Employee emp) throws DAOException, CreateException {
		return messageDAO.findMessageByEmpAndState(emp);
	}

	*//**
	 * 获取员工未处理消息条数
	 * 
	 * @param emp
	 *            员工
	 * @return 消息条数
	 *//*
	public int getMessageCountByEmpAndState(Employee emp) throws DAOException {
		return messageDAO.getMessageCountByEmpAndState(emp);
	}

	*//**
	 * 获取员工消息条数
	 * 
	 * @param emp
	 *            员工
	 * @param state
	 *            消息状态
	 * @param messageType
	 *            消息类型
	 * @return 消息列表
	 *//*
	public int getMessageCount(Employee emp, int state, String condition) throws DAOException {
		return messageDAO.findMessageCount(emp, state, condition);
	}

	*//**
	 * 获取员工消息分页
	 * 
	 * @param firstResult
	 *            起始页
	 * @param maxResults
	 *            尾页
	 * @param emp
	 *            员工
	 * @param state
	 *            消息状态
	 * @param condition
	 *            查询条件
	 * @return 消息列表
	 *//*
	public List<Message> getMessageByEmpAndState(int firstResult, int maxResults, Employee emp, int state,
			String condition) throws DAOException {
		return messageDAO.getPagingMessage(firstResult, maxResults, emp, state, condition);
	}

	@Override
	public void setDAO() {
		this.baseDAO = messageDAO;

	}

}
*/