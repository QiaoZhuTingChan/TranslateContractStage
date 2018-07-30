package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.ProcessType;
import com.jyd.bms.dao.ProcessTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("ProcessTypeService")
public class ProcessTypeService extends BaseService<ProcessType> {
	@Autowired(required = true)
	private ProcessTypeDAO processTypeDAO;

	public int getProcessTypeCount(String condition) throws DAOException {
		return processTypeDAO.getProcessTypeCount(condition);
	}

	public List<ProcessType> getPagingProcessType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return processTypeDAO.getPagingProcessType(firstResult, maxResults, condition);
	}

	public List<ProcessType> getAllProcessType() throws DAOException {
		return processTypeDAO.getAllProcessType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = processTypeDAO;
	}

}
