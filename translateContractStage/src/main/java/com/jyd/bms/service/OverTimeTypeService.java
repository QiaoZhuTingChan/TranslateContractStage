package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.OverTimeType;
import com.jyd.bms.dao.OverTimeTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("OverTimeTypeService")
public class OverTimeTypeService extends BaseService<OverTimeType> {

	@Autowired(required = true)
	private OverTimeTypeDAO overTimeTypeDAO;

	// 获取记录条数
	public int getOverTimeTypeCount(String condition) throws DAOException {
		return overTimeTypeDAO.getOverTimeTypeCount(condition);
	}

	// 分页
	public List<OverTimeType> getPagingOverTimeType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return overTimeTypeDAO.getPagingOverTimeType(firstResult, maxResults, condition);
	}

	// 获取所有记录
	public List<OverTimeType> getAllOverTimeType() throws DAOException {
		return overTimeTypeDAO.getAllOverTimeType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = overTimeTypeDAO;
	}

}
