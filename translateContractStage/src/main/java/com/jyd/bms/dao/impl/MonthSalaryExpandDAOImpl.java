package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.MonthSalary;
import com.jyd.bms.bean.MonthSalaryExpand;
import com.jyd.bms.dao.MonthSalaryExpandDAO;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DeleteException;

@Repository
public class MonthSalaryExpandDAOImpl extends HibernateBaseTemplate<MonthSalaryExpand> implements MonthSalaryExpandDAO{

	/**
	 * 查询个人月薪资明细
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MonthSalaryExpand getMonthSalaryExpand(Employee employee, String yearMonth) throws DAOException {
        String hql = "from MonthSalaryExpand where Employee =:employee and yearMonth =:yearMonth";
       
        Map map = new HashMap<>();
        map.put("employee", employee);
        map.put("yearMonth", yearMonth);
        
        List<MonthSalaryExpand> list = getQueryResult(hql, map);
        if(list.size()>0) {
        	return list.get(0);
        }else {
        	return null;
        }
	}
	
	
	/**
	 * 删除对应子表
	 * @throws DAOException 
	 */
	@Override
	public void deleteAll(MonthSalary monthSalary) throws DeleteException, DAOException{
		String hql = "delete from MonthSalaryExpand where monthSalary =:monthSalary";
		Map<String, Object> map = new HashMap<>();
        map.put("monthSalary", monthSalary);
        super.executeUpdate(hql, map);
	}
	
	
	@Override
	public List<MonthSalaryExpand> getMonthSalaryExpandByMonthSalary(MonthSalary monthSalary) throws DAOException {
		String hql = "from MonthSalaryExpand where monthSalary =:monthSalary";
		Map<String, Object> map = new HashMap<>();
        map.put("monthSalary", monthSalary);
		return super.getQueryResult(hql, map);
	}


}
