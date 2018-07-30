package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.UploadFileType;
import com.jyd.bms.tool.exception.DAOException;
/**
 * 
 * @author hong
 * @category 文件类型接口 
 */
public interface UploadFileTypeDAO extends HibernateBase<UploadFileType>{
	public int getUploadFileTypeCount(String condition) throws DAOException ;

	public List<UploadFileType> getPagingUploadFileType(int firstResult, int maxResults, String condition) throws DAOException;
	
	public List<UploadFileType> getAllUploadFileType() throws DAOException;
}
