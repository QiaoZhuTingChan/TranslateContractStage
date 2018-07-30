package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.BaThirdpartQueryType;
import com.jyd.bms.dao.BaThirdpartQueryTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-16 16:48:05 by GeneratedTool
 * @author mjy
 */
@Service("BaThirdpartQueryTypeService")
public class BaThirdpartQueryTypeService extends BaseService<BaThirdpartQueryType> {
	@Autowired(required = true)
	private BaThirdpartQueryTypeDAO baThirdpartQueryTypeDAO;

	public int getBaThirdpartQueryTypeCount(String condition) throws DAOException {
		return baThirdpartQueryTypeDAO.getBaThirdpartQueryTypeCount(condition);
	}

	public List<BaThirdpartQueryType> getPagingBaThirdpartQueryType(int firstResult, int maxResults, String condition)
			throws DAOException {
		return baThirdpartQueryTypeDAO.getPagingBaThirdpartQueryType(firstResult, maxResults, condition);
	}

	public List<BaThirdpartQueryType> getAllBaThirdpartQueryType() throws DAOException {
		return baThirdpartQueryTypeDAO.getAllBaThirdpartQueryType();
	}

	@Override

	public void setDAO() {
		this.baseDAO = baThirdpartQueryTypeDAO;
	}

	public List<BaThirdpartQueryType> getBaThirdpartQueryTypeBelongToBairongCompany() throws DAOException{
		return baThirdpartQueryTypeDAO.getBaThirdpartQueryTypeBelongToBairongCompany();
	}
}
