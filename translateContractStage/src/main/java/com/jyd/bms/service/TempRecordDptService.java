package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.TempRecordDpt;
import com.jyd.bms.dao.TempRecordDptDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("TempRecordDptService")
public class TempRecordDptService extends BaseService<TempRecordDpt> {
	@Autowired(required = true)
	private TempRecordDptDAO tempRecordDptDAO;

	// 获取所有记录
	public List<TempRecordDpt> getAllTempRecordDpt() throws DAOException {
		return tempRecordDptDAO.getAllTempRecordDpt();
	}
	@Override
	public void setDAO() {
		this.baseDAO = tempRecordDptDAO;
	}
}
