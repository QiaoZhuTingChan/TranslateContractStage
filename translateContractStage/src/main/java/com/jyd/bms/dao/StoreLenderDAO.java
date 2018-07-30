package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreLender;
import com.jyd.bms.tool.exception.DAOException;

/**
 * 
 * @author hong
 * @category 门店出借人
 *
 */
public interface StoreLenderDAO extends HibernateBase<StoreLender> {
	public int getStoreLenderCount(String condition) throws DAOException;

	public List<StoreLender> getPagingStoreLender(int firstResult, int maxResults, String condition)
			throws DAOException;

	/**
	 * @category 查询所有门店出借人
	 * @return 出借人集合
	 * @throws DAOException
	 */
	public List<StoreLender> getAllStoreLender() throws DAOException;

	/**
	 * @category 通过门店查出借人
	 * @param store
	 * @return 出借人
	 * @throws DAOException
	 */
	public List<StoreLender> getStoreLenderByStore(Store store) throws DAOException;

}
