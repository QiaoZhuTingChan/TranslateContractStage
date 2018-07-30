package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.StoreSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("StoreSalaryService")
public class StoreSalaryService extends BaseService<Store> {
	
	@Autowired(required = true)
	private StoreSalaryDAO storeSalaryDAO;

	/**
	 * 获取门店下所有员工
	 * @param store
	 * @param yearMonth
	 * @return
	 * @throws DAOException
	 */
	public List<Employee> getEmployeeByStoreAndYearmonth(Store store, String yearMonth) throws DAOException {
		return storeSalaryDAO.getEmployeeByStoreAndYearmonth(store, yearMonth);
	}

	@Override
	public void setDAO() {
		// TODO Auto-generated method stub

	}

}