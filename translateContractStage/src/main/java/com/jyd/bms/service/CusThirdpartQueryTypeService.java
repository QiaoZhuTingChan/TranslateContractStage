package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.CusThirdpartQueryType;
import com.jyd.bms.dao.CusThirdpartQueryTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-04-20 10:34:54 by GeneratedTool
 * @author mjy
 */
@Service("CusThirdpartQueryTypeService")
public class CusThirdpartQueryTypeService extends BaseService<CusThirdpartQueryType> {
	@Autowired(required = true)
	private CusThirdpartQueryTypeDAO cusThirdpartQueryTypeDAO;

	public int getCusThirdpartQueryTypeCount(String condition) throws DAOException {
		return cusThirdpartQueryTypeDAO.getCusThirdpartQueryTypeCount(condition);
	}

	public List<CusThirdpartQueryType> getPagingCusThirdpartQueryType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return cusThirdpartQueryTypeDAO.getPagingCusThirdpartQueryType(firstResult, maxResults, condition);
	}

	public List<CusThirdpartQueryType> getAllCusThirdpartQueryType() throws DAOException {
		return cusThirdpartQueryTypeDAO.getAllCusThirdpartQueryType();
	}

	
	
	/**
	 * 查询所有状态为true的CusThirdpartQueryType
	 * @return
	 * @throws DAOException 
	 */
	public List<CusThirdpartQueryType> getCusThirdpartQueryTypeWhichStatusIsTrue() throws DAOException{
		return cusThirdpartQueryTypeDAO.getCusThirdpartQueryTypeWhichStatusIsTrue();
	}
	
	
	@Override

	public void setDAO() {
		this.baseDAO = cusThirdpartQueryTypeDAO;
	}
}
