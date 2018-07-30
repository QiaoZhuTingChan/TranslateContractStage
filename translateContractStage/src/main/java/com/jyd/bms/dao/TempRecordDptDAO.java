package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.TempRecordDpt;
import com.jyd.bms.tool.exception.DAOException;

public interface TempRecordDptDAO extends HibernateBase<TempRecordDpt> {


	/**
	 * 查询所有临时记录部门的调用信息
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<TempRecordDpt> getAllTempRecordDpt() throws DAOException;

}
