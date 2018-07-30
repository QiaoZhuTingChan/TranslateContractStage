package com.jyd.bms.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.PageUseLog;
import com.jyd.bms.dao.PageUseLogDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("PageUseLogService")
public class PageUseLogService extends BaseService<PageUseLog> {
	@Autowired(required = true)
	private PageUseLogDAO pageUseLogDAO;

	/**
	 * 查询
	 * 
	 * @param condition
	 * @param begin
	 * @param end
	 * @return
	 * @throws DAOException
	 */
	public int getPageUseLogCount(String condition, Timestamp begin, Timestamp end) throws DAOException {
		return pageUseLogDAO.getPageUseLogCount(condition, begin, end);
	}

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @param begin
	 * @param end
	 * @return
	 * @throws DAOException
	 */
	public List<PageUseLog> getPagingPageUseLog(int firstResult, int maxResults, String condition, Timestamp begin,
			Timestamp end) throws DAOException {
		return pageUseLogDAO.getPagingPageUseLog(firstResult, maxResults, condition, begin, end);
	}

	@Override
	public void setDAO() {
		this.baseDAO = pageUseLogDAO;
	}
}
