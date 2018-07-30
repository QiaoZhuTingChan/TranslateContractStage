package com.jyd.bms.dao.impl;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractLateFee;
import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.MonthSalary;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.MonthSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DeleteException;

@Repository
public class MonthSalaryDAOImpl extends HibernateBaseTemplate<MonthSalary> implements MonthSalaryDAO {

	/**
	 * 查询月薪资
	 * 
	 * @throws DeleteException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public MonthSalary getMonthSalary(Employee employee, String yearMonth) throws DAOException {
		String hql = " from MonthSalary where employee =:employee and yearMonth =:yearMonth";

		Map map = new HashMap<>();
		map.put("employee", employee);
		map.put("yearMonth", yearMonth);

		List<MonthSalary> list = getQueryResult(hql, map);
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * 查询员工月薪资结果
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int getEmployeeSalaryViewCount(String condition, String yearMonth) throws DAOException {
		String hql = "select count(*) from MonthSalary m where 1=1";
		Map<String, Object> map = new HashMap<>();
		if(!condition.equals("")) {
			hql += " and m.employee.name like :condition";
			map.put("condition", "%" +condition+ "%");
		}
		if(!yearMonth.equals("")) {
			hql += " and m.yearMonth = :yearMonth";
			map.put("yearMonth", yearMonth);
		}
		List<Long> list = super.getQueryResult(hql, map);
		return list.get(0).intValue();
	}

	/**
	 * 分页
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<MonthSalary> getPagingEmployeeSalaryView(int firstResult, int maxResults, String condition,
			String yearMonth) throws DAOException {
		String hql = "from MonthSalary m where 1=1";
		Map<String, Object> map = new HashMap<>();
		if(!condition.equals("")) {
			hql += " and m.employee.name like :condition";
			map.put("condition", "%" +condition+ "%");
		}
		if(!yearMonth.equals("")) {
			hql += " and m.yearMonth = :yearMonth";
			map.put("yearMonth", yearMonth);
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	/**
	 * 查询所有
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<MonthSalary> getAllEmployeeSalaryView() throws DAOException {
		String hql = "";
		hql = "from MonthSalary";
		return super.getQueryResult(hql.toString());
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MonthSalary> getMonthSalaryLocked(Employee employee, Department department, Store store,
			String yearMonth) throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();

		hql.append(" from MonthSalary where islock = :islock and yearMonth = :yearMonth");
		if (employee != null) {
			hql.append(" and employee = :employee");
			map.put("islock", true);
			map.put("yearMonth", yearMonth);
			map.put("employee", employee);
		}
		if (department != null) {
			hql.append(" and department = :department");
			map.put("islock", false);
			map.put("yearMonth", yearMonth);
			map.put("department", department);
		}
		if (store != null) {
			hql.append(" and store = :store");
			map.put("islock", false);
			map.put("yearMonth", yearMonth);
			map.put("store", store);
		}

		List<MonthSalary> list = super.getQueryResult(hql.toString(), map);
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MonthSalary> getMonthSalaryByEmployee(Employee employee, Department department, Store store,
			String yearMonth) throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();

		hql.append("from MonthSalary where 1=1 and islock = false");
		if (employee != null) {
			hql.append(" and employee = :employee");
			map.put("employee", employee);
		}
		if (department != null) {
			hql.append(" and department = :department");
			map.put("department", department);
		}
		if (store != null) {
			hql.append(" and store = :store");
			map.put("store", store);
		}
		if (yearMonth != null) {
			hql.append(" and yearMonth = :yearMonth");
			map.put("yearMonth", yearMonth);
		}

		List<MonthSalary> list = super.getQueryResult(hql.toString(), map);
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<ContractLateFee> getPagingSalaryView(int firstResult, int maxResults, Map<String, Object> mapPara)
			throws DAOException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSalaryViewCount(Map<String, Object> mapPara) throws DAOException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

}
