package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.dao.DepartmentSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class DepartmentSalaryDaoImpl extends HibernateBaseTemplate<Employee> implements DepartmentSalaryDAO {

	/**
	 * 获取当前部门下的所有员工
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeByDepartmentAndYearmonth(Department department, String yearMonth)
			throws DAOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Employee where department =:department";
		map.put("department", department);
		List<Employee> list = getQueryResult(hql, map);
		return list;
	}

}