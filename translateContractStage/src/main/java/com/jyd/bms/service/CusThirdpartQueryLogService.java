package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.CusThirdpartQueryLog;
import com.jyd.bms.dao.CusThirdpartQueryLogDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-04-20 13:41:29 by GeneratedTool
 * @author mjy
 */
@Service("CusThirdpartQueryLogService")
public class CusThirdpartQueryLogService extends BaseService<CusThirdpartQueryLog> {
	@Autowired(required = true)
	private CusThirdpartQueryLogDAO cusThirdpartQueryLogDAO;

	public int getCusThirdpartQueryLogCount(String condition) throws DAOException {
		return cusThirdpartQueryLogDAO.getCusThirdpartQueryLogCount(condition);
	}

	public List<CusThirdpartQueryLog> getPagingCusThirdpartQueryLog(int firstResult, int maxResults, String condition)
			throws DAOException {
		return cusThirdpartQueryLogDAO.getPagingCusThirdpartQueryLog(firstResult, maxResults, condition);
	}

	public List<CusThirdpartQueryLog> getAllCusThirdpartQueryLog() throws DAOException {
		return cusThirdpartQueryLogDAO.getAllCusThirdpartQueryLog();
	}

	@Override

	public void setDAO() {
		this.baseDAO = cusThirdpartQueryLogDAO;
	}
}
