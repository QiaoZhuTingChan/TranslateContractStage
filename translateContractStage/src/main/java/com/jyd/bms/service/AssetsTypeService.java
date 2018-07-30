package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.AssetsType;
import com.jyd.bms.bean.EducationType;
import com.jyd.bms.dao.AssetsTypeDAO;
import com.jyd.bms.dao.EducationTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("AssetsTypeService")
public class AssetsTypeService extends BaseService<AssetsType> {
	@Autowired(required = true)
	private AssetsTypeDAO assetsTypeDAO;

	// 获取记录条数
	public int getAssetsTypeCount(String condition) throws DAOException {
		return assetsTypeDAO.getAssetsTypeCount(condition);
	}

	// 分页
	public List<AssetsType> getPagingAssetsType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return assetsTypeDAO.getPagingAssetsType(firstResult, maxResults, condition);
	}

	// 获取所有记录
	public List<AssetsType> getAllAssetsType() throws DAOException {
		return assetsTypeDAO.getAllAssetsType();
	}

	@Override
	public void setDAO() {
		this.baseDAO = assetsTypeDAO;
	}

}
