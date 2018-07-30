package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.EvectionType;
import com.jyd.bms.dao.EvectionTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("EvectionTypeService")
public class EvectionTypeService extends BaseService<EvectionType> {
	@Autowired(required = true)
	private EvectionTypeDAO evectionTypeDAO;

	// 获取记录条数
	public int getEvectionTypeCount(String condition) throws DAOException {
		return evectionTypeDAO.getEvectionTypeCount(condition);
	}

	// 分页
	public List<EvectionType> getPagingEvectionType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return evectionTypeDAO.getPagingEvectionType(firstResult, maxResults, condition);
	}

	// 获取所有记录
	public List<EvectionType> getAllEvectionType() throws DAOException {
		return evectionTypeDAO.getAllEvectionType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = evectionTypeDAO;
	}

}
