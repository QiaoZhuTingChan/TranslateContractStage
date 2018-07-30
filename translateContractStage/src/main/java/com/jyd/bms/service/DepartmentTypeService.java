package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.DepartmentType;
import com.jyd.bms.dao.DepartmentTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("DepartmentTypeService")
public class DepartmentTypeService extends BaseService<DepartmentType> {
	@Autowired(required = true)
	private DepartmentTypeDAO departmentTypeDAO;

	public int getDepartmentTypeCount(String condition) throws DAOException {
		return departmentTypeDAO.getDepartmentTypeCount(condition);
	}

	public List<DepartmentType> getPagingDepartmentType(int firstResult, int maxResults, String condition) throws DAOException {
		return departmentTypeDAO.getPagingDepartmentType(firstResult, maxResults, condition);
	}

	public List<DepartmentType> getAllDepartmentType() throws DAOException {
		return departmentTypeDAO.getAllDepartmentType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = departmentTypeDAO;
	}

}
