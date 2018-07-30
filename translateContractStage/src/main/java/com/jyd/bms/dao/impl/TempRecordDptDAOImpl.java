package com.jyd.bms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.TempRecordDpt;
import com.jyd.bms.dao.TempRecordDptDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class TempRecordDptDAOImpl extends HibernateBaseTemplate<TempRecordDpt> implements TempRecordDptDAO {



	public List<TempRecordDpt> getAllTempRecordDpt() throws DAOException {
		String hql = "";
		hql = "from TempRecordDpt";
		return super.getQueryResult(hql.toString());

	}

}
