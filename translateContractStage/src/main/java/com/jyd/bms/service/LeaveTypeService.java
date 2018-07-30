package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.LeaveType;
import com.jyd.bms.dao.LeaveTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("LeaveTypeService")
public class LeaveTypeService extends BaseService<LeaveType> {

	@Autowired(required = true)
	private LeaveTypeDAO leaveTypeDAO;

	// 获取记录条数
	public int getLeaveTypeCount(String condition) throws DAOException {
		return leaveTypeDAO.getLeaveTypeCount(condition);
	}

	// 分页
	public List<LeaveType> getPagingLeaveType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return leaveTypeDAO.getPagingLeaveType(firstResult, maxResults, condition);
	}

	// 获取所有记录
	public List<LeaveType> getAllLeaveType() throws DAOException {
		return leaveTypeDAO.getAllLeaveType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = leaveTypeDAO;
	}

}
