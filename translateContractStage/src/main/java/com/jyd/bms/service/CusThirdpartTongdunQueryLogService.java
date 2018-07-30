package com.jyd.bms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jyd.bms.bean.CusThirdpartTongdunQueryLog;
import com.jyd.bms.dao.CusThirdpartTongdunQueryLogDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-02 09:34:37 by GeneratedTool
 * @author mjy
 */
@Service("CusThirdpartTongdunQueryLogService")
public class CusThirdpartTongdunQueryLogService extends BaseService<CusThirdpartTongdunQueryLog> {
	@Autowired(required = true)
	private CusThirdpartTongdunQueryLogDAO cusThirdpartTongdunQueryLogDAO;

	public int getCusThirdpartTongdunQueryLogCount(String condition) throws DAOException {
		return cusThirdpartTongdunQueryLogDAO.getCusThirdpartTongdunQueryLogCount(condition);
	}

	public List<CusThirdpartTongdunQueryLog> getPagingCusThirdpartTongdunQueryLog(int firstResult, int maxResults,
			String condition) throws DAOException {
		return cusThirdpartTongdunQueryLogDAO.getPagingCusThirdpartTongdunQueryLog(firstResult, maxResults, condition);
	}

	public List<CusThirdpartTongdunQueryLog> getAllCusThirdpartTongdunQueryLog() throws DAOException {
		return cusThirdpartTongdunQueryLogDAO.getAllCusThirdpartTongdunQueryLog();
	}

	@Override

	public void setDAO() {
		this.baseDAO = cusThirdpartTongdunQueryLogDAO;
	}
}
