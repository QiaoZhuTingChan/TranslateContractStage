package com.jyd.bms.dao;

import java.util.List;

import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreRepaymentAccount;
import com.jyd.bms.tool.exception.DAOException;
/**
 * 
 * @author hong
 * @category 门店还款账户
 *　
 */
public interface StoreRepaymentAccountDAO extends HibernateBase <StoreRepaymentAccount>{
	public int getStoreRepaymentAccountCount(String condition)
			throws DAOException;

	public List<StoreRepaymentAccount> getPagingStoreRepaymentAccount(int firstResult, int maxResults,
			String condition) throws DAOException;
	
	public List<StoreRepaymentAccount> getAllStoreRepaymentAccount() throws DAOException;

	/**
	 * @category 根据门店查找还款人
	 * @return
	 * @throws DAOException
	 */
	public List<StoreRepaymentAccount> getStoreRepaymentAccountByStore(Store store) throws DAOException;
}
