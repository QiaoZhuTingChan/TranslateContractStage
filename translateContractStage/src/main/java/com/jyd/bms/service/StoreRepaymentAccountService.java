package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.StoreRepaymentAccount;
import com.jyd.bms.dao.StoreRepaymentAccountDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("StoreRepaymentAccountService")
public class StoreRepaymentAccountService extends BaseService<StoreRepaymentAccount> {
	@Autowired(required = true)
	private StoreRepaymentAccountDAO storeRepaymentAccountDAO;

	public int getStoreRepaymentAccountCount(String condition) throws DAOException {
		return storeRepaymentAccountDAO.getStoreRepaymentAccountCount(condition);
	}

	public List<StoreRepaymentAccount> getPagingStoreRepaymentAccount(int firstResult, int maxResults, String condition)
			throws DAOException {
		return storeRepaymentAccountDAO.getPagingStoreRepaymentAccount(firstResult, maxResults, condition);
	}

	public List<StoreRepaymentAccount> getAllStoreRepaymentAccount() throws DAOException {
		return storeRepaymentAccountDAO.getAllStoreRepaymentAccount();
	}

	/**
	 * @category 根据门店查找还款人
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<StoreRepaymentAccount> getStoreRepaymentAccountByStore(Store store) throws DAOException {
		return storeRepaymentAccountDAO.getStoreRepaymentAccountByStore(store);
	}
	@Override
	public void setDAO() {
		this.baseDAO = storeRepaymentAccountDAO;
	}

}
