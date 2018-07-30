package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.StoreDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("StoreService")
public class StoreService extends BaseService<Store> {
	@Autowired(required = true)
	private StoreDAO storeDAO;

	public int getStoreCount(String condition) throws DAOException {
		return storeDAO.getStoreCount(condition);
	}

	public List<Store> getPagingStore(int firstResult, int maxResults, String condition) throws DAOException {
		return storeDAO.getPagingStore(firstResult, maxResults, condition);
	}

	public List<Store> getAllStore() throws DAOException {
		return storeDAO.getAllStore();
	}
	
	/**
	 * 根据身份证号获取门店信息
	 * @param idNos
	 * @return
	 * @throws DAOException
	 */
	public List<Store> getStoresByIdNOs(String idNos)  throws DAOException{	
		return storeDAO.getStoresByIdNOs(idNos);
	}

	@Override
	public void setDAO() {
		this.baseDAO = storeDAO;
	}
	
	public Store getStoreByName(String condition) throws DAOException{
		return storeDAO.getStoreByName(condition);
	}
}
