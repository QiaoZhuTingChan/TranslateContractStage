package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.LockMonthSalary;
import com.jyd.bms.dao.LockMonthSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;

//每月薪资锁定
@Repository
public class LockMonthSalaryDAOImpl extends HibernateBaseTemplate<LockMonthSalary> implements LockMonthSalaryDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<LockMonthSalary> getMonthAll(int year) throws DAOException {
		Map<String, Object> map = new HashMap<>();
		String hql = "from LockMonthSalary where month like :month";
		map.put("month", year+"%");
		List<LockMonthSalary> list = getQueryResult(hql, map);
		return list;
	}
}