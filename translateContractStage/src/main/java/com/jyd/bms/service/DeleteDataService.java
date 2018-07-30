package com.jyd.bms.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.DeleteDataDAO;

@Service("DeleteDataService")
public class DeleteDataService {
	
	@Autowired
	private DeleteDataDAO deleteDataDAO;

	public int deleteDateByStoreAndDate(int storeId, Date date) {
		
		return deleteDataDAO.deleteDateByStoreAndDate(storeId, date);
		
	}
	public int deleteDateByStoreAndDate1(int storeId, Date date) {
		
		return deleteDataDAO.deleteDateByStoreAndDate1(storeId, date);
		
	}
	public int deleteDateByStoreAndDate2(int storeId, Date date) {
		
		return deleteDataDAO.deleteDateByStoreAndDate2(storeId, date);
		
	}
	public int deleteDateByStoreAndDate2(int storeid, List<String> contractNumList) {
		return deleteDataDAO.deleteDateByStoreAndDate2(storeid, contractNumList);
	}
	public int deleteDateByStoreAndDate1(int storeid, List<String> contractNumList) {
		return deleteDataDAO.deleteDateByStoreAndDate1(storeid, contractNumList);
	}
}
