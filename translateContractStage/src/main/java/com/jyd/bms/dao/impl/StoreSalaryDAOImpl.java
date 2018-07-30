package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.StoreSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class StoreSalaryDAOImpl extends HibernateBaseTemplate<Store> implements StoreSalaryDAO {

	/**
	 * 获取门店下所有员工
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeByStoreAndYearmonth(Store store, String yearMonth) throws DAOException {
       Map<String,Object> map = new HashMap<>();
       String hql = "from Employee where department.store = :store";
       map.put("store", store);
       List<Employee> list = getQueryResult(hql, map);
 	   return list;
	}

}