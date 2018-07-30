package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreLender;
import com.jyd.bms.dao.StoreLenderDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("StoreLenderService")
public class StoreLenderService extends BaseService<StoreLender> {
	@Autowired(required = true)
	private StoreLenderDAO storeLenderDAO;

	public int getStoreLenderCount(String condition) throws DAOException {
		return storeLenderDAO.getStoreLenderCount(condition);
	}

	public List<StoreLender> getPagingStoreLender(int firstResult, int maxResults, String condition)
			throws DAOException {
		return storeLenderDAO.getPagingStoreLender(firstResult, maxResults, condition);
	}

	public List<StoreLender> getAllStoreLender() throws DAOException {
		return storeLenderDAO.getAllStoreLender();
	}
	/**
	 * @category 通过门店查出借人
	 * @param store
	 * @return　出借人
	 * @throws DAOException
	 */
	public List<StoreLender> getStoreLenderByStore(Store store)throws DAOException{
		return storeLenderDAO.getStoreLenderByStore(store);
	}
	@Override
	public void setDAO() {
		this.baseDAO = storeLenderDAO;
	}

}
