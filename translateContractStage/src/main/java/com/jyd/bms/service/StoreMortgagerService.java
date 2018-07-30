package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreMortgager;
import com.jyd.bms.dao.StoreMortgagerDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("StoreMortgagerService")
public class StoreMortgagerService extends BaseService<StoreMortgager> {
	@Autowired(required = true)
	private StoreMortgagerDAO storeMortgagerDAO;

	public int getStoreMortgagerCount(String condition) throws DAOException {
		return storeMortgagerDAO.getStoreMortgagerCount(condition);
	}

	public List<StoreMortgager> getPagingStoreMortgager(int firstResult, int maxResults, String condition)
			throws DAOException {
		return storeMortgagerDAO.getPagingStoreMortgager(firstResult, maxResults, condition);
	}

	public List<StoreMortgager> getAllStoreMortgager() throws DAOException {
		return storeMortgagerDAO.getAllStoreMortgager();
	}
	/**
	 * @category  查找门店抵押人
	 * @param store
	 * @return 门店抵押人
	 */
	public List<StoreMortgager> getStoreMortgagerByStore(Store store) throws DAOException {
		return storeMortgagerDAO.getStoreMortgagerByStore(store);
	}

	@Override
	public void setDAO() {
		this.baseDAO = storeMortgagerDAO;
	}

}
