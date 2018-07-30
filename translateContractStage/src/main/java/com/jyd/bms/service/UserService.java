package com.jyd.bms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.User;
import com.jyd.bms.dao.UserDAO;
import com.jyd.bms.dto.OnlineUserDTO;
import com.jyd.bms.tool.exception.DAOException;

@Service("UserService")
public class UserService extends BaseService<User> {
	@Autowired(required = true)
	private UserDAO userDao;

	public int getUserCount(String condition) throws DAOException {
		return userDao.getUserCount(condition);
	}

	public List<User> getPagingUser(int firstResult, int maxResults, String condition) throws DAOException {
		return userDao.getPagingUser(firstResult, maxResults, condition);
	}

	public User checkLogin(String loginName, String password) throws DAOException {
		return userDao.checkLogin(loginName, password);
	}

	public User getUserByLoginName(String loginName) throws DAOException {
		return userDao.getUserByLoginName(loginName);
	}

	/**
	 * 获取在线用户列表
	 * 
	 * @param listEmployeeId
	 *            用户Id列表
	 * @return
	 * @throws DAOException
	 */
	public List<OnlineUserDTO> getAllOnlineUser(List<Integer> listEmployeeId) throws DAOException {
		return userDao.getAllOnlineUser(listEmployeeId);
	}

	@Override
	public void setDAO() {
		this.baseDAO = userDao;
	}

	public List<User> getUsersByEmployeeList(List<Employee> employeeList) throws DAOException {
		return userDao.getUsersByEmployeeList(employeeList);
	}
}
