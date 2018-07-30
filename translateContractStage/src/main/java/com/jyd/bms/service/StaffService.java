package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Staff;
import com.jyd.bms.dao.StaffDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("StaffService")
public class StaffService extends BaseService<Staff> {
	@Autowired(required = true)
	private StaffDAO staffDAO;

	public int getStaffCount(String condition) throws DAOException {
		return staffDAO.getStaffCount(condition);
	}

	public List<Staff> getPagingStaff(int firstResult, int maxResults, String condition) throws DAOException {
		return staffDAO.getPagingStaff(firstResult, maxResults, condition);
	}

	public List<Staff> getAllStaff() throws DAOException {
		return staffDAO.getAllStaff();
	}

	@Override
	public void setDAO() {
		this.baseDAO = staffDAO;
	}

}
