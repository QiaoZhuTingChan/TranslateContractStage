package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Shift;
import com.jyd.bms.dao.ShiftDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ShiftService")
public class ShiftService extends BaseService<Shift> {

	@Autowired(required = true)
	private ShiftDAO shiftDAO;

	// 获取记录条数
	public int getShiftCount(String condition) throws DAOException {
		return shiftDAO.getShiftCount(condition);
	}

	// 分页
	public List<Shift> getPagingShift(int firstResult, int maxResults, String condition)
			throws DAOException {
		return shiftDAO.getPagingShift(firstResult, maxResults, condition);
	}

	// 获取所有记录
	public List<Shift> getAllShift() throws DAOException {
		return shiftDAO.getAllShift();
	}

	@Override
	public void setDAO() {
		this.baseDAO = shiftDAO;
	}

}
