package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.UploadFileType;
import com.jyd.bms.dao.UploadFileTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class UploadFileTypeDAOImpl extends HibernateBaseTemplate<UploadFileType> implements UploadFileTypeDAO {

	public int getUploadFileTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from UploadFileType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from UploadFileType where uploadFileType like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<UploadFileType> getPagingUploadFileType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from UploadFileType";
		} else {
			hql = "from UploadFileType where uploadFileType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);

	}

	public List<UploadFileType> getAllUploadFileType() throws DAOException {
		String hql = "";
		hql = "from UploadFileType order by sortIndex asc";
		return super.getQueryResult(hql.toString());
	}

}
