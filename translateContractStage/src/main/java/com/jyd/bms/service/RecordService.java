package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Record;
import com.jyd.bms.dao.RecordDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("RecordService")
public class RecordService extends BaseService<Record> {
	@Autowired(required = true)
	private RecordDAO recordDAO;

	/**
	 * 查询所有记录
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Record> getAllContact() throws DAOException {
		return recordDAO.getAllRecord();
	}

	/**
	 * 根据条件查询记录总数
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getRecordCount(String condition) throws DAOException {
		return recordDAO.getRecordCount(condition);
	}

	/**
	 * 根据条件分页查询记录
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<Record> getPagingRecords(int firstResult, int maxResults, String condition) throws DAOException {
		return recordDAO.getPagingRecords(firstResult, maxResults, condition);
	}

	@Override
	public void setDAO() {
		this.baseDAO = recordDAO;
	}

}
