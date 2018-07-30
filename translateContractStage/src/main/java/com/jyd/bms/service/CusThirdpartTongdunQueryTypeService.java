package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CusThirdpartTongdunQueryType;
import com.jyd.bms.dao.CusThirdpartTongdunQueryTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-02 09:35:24 by GeneratedTool
 * @author mjy
 */
@Service("CusThirdpartTongdunQueryTypeService")
public class CusThirdpartTongdunQueryTypeService extends BaseService<CusThirdpartTongdunQueryType> {
	@Autowired(required = true)
	private CusThirdpartTongdunQueryTypeDAO cusThirdpartTongdunQueryTypeDAO;

	public int getCusThirdpartTongdunQueryTypeCount(String condition) throws DAOException {
		return cusThirdpartTongdunQueryTypeDAO.getCusThirdpartTongdunQueryTypeCount(condition);
	}

	public List<CusThirdpartTongdunQueryType> getPagingCusThirdpartTongdunQueryType(int firstResult, int maxResults,
			String condition) throws DAOException {
		return cusThirdpartTongdunQueryTypeDAO.getPagingCusThirdpartTongdunQueryType(firstResult, maxResults,
				condition);
	}

	public List<CusThirdpartTongdunQueryType> getAllCusThirdpartTongdunQueryType() throws DAOException {
		return cusThirdpartTongdunQueryTypeDAO.getAllCusThirdpartTongdunQueryType();
	}
	
	
	/**
	 * 查询所有状态为true的CusThirdpartTongdunQueryType
	 * @return
	 * @throws DAOException 
	 */
	public List<CusThirdpartTongdunQueryType> getCusThirdpartTongdunQueryTypeWhichStatusIsTrue() throws DAOException{
		return cusThirdpartTongdunQueryTypeDAO.getCusThirdpartTongdunQueryTypeWhichStatusIsTrue();
	}
	

	@Override
	public void setDAO() {
		this.baseDAO = cusThirdpartTongdunQueryTypeDAO;
	}
}
