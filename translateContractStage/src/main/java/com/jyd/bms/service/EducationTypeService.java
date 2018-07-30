package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.EducationType;
import com.jyd.bms.dao.EducationTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("EducationTypeService")
public class EducationTypeService extends BaseService<EducationType> {
	@Autowired(required = true)
	private EducationTypeDAO educationTypeDAO;

	// 获取记录条数
	public int getEducationTypeCount(String condition) throws DAOException {
		return educationTypeDAO.getEducationTypeCount(condition);
	}

	// 分页
	public List<EducationType> getPagingEducationType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return educationTypeDAO.getPagingEducationType(firstResult, maxResults, condition);
	}

	// 获取所有记录
	public List<EducationType> getAllEducationType() throws DAOException {
		return educationTypeDAO.getAllEducationType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = educationTypeDAO;
	}

}
