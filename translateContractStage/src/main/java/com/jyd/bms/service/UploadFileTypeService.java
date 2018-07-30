package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.UploadFileType;
import com.jyd.bms.dao.UploadFileTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("UploadFileTypeService")
public class UploadFileTypeService extends BaseService<UploadFileType> {
	@Autowired(required = true)
	private UploadFileTypeDAO uploadFileTypeDAO;

	public int getUploadFileTypeCount(String condition) throws DAOException {
		return uploadFileTypeDAO.getUploadFileTypeCount(condition);
	}

	public List<UploadFileType> getPagingUploadFileType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return uploadFileTypeDAO.getPagingUploadFileType(firstResult, maxResults, condition);
	}

	public List<UploadFileType> getAllUploadFileType() throws DAOException {
		return uploadFileTypeDAO.getAllUploadFileType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = uploadFileTypeDAO;
	}
}
