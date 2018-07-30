package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreMortgager;
import com.jyd.bms.tool.exception.DAOException;
/**
 * 
 * @author hong
 * @category 门店抵押人接口 
 *
 */
public interface StoreMortgagerDAO extends HibernateBase<StoreMortgager> {
	public int getStoreMortgagerCount(String condition) throws DAOException;

	public List<StoreMortgager> getPagingStoreMortgager(int firstResult, int maxResults, String condition)
			throws DAOException;

	public List<StoreMortgager> getAllStoreMortgager() throws DAOException;

	/**
	 * @category  查找门店抵押人
	 * @param store
	 * @return 门店抵押人
	 */
	public List<StoreMortgager> getStoreMortgagerByStore(Store store) throws DAOException;

}
