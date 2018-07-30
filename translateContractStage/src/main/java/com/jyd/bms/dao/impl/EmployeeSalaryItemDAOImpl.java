package com.jyd.bms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeSalaryItem;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dao.EmployeeSalaryItemDAO;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class EmployeeSalaryItemDAOImpl extends HibernateBaseTemplate<EmployeeSalaryItem>
		implements EmployeeSalaryItemDAO {

	@SuppressWarnings("unchecked")
	@Override
	public int getEmployeeSalaryItemCount(String condition, Integer type, String date, boolean flag,
			String salaryItemType) throws DAOException {

		StringBuffer hql = new StringBuffer("");
		Map<String, Object> map = new HashMap<>();

		hql.append("select count(*) from EmployeeSalaryItem where 1=1 ");
		if (!flag) {
			if (!condition.equals("")) {
				hql.append(" and employee.name like :condition");
				map.put("condition", "%" + condition + "%");
			}
			if (type != null) {
				hql.append(" and salaryItem.type = :type ");
				map.put("type", type);
			}
			if (!date.equals("")) {
				hql.append(" and dates = :date");
				map.put("date", date);
			}
			if (!salaryItemType.equals("")) {
				hql.append(" and salaryItem.salaryItem = :salaryItemType");
				map.put("salaryItemType", salaryItemType);
			}
		}
		List<Long> lstCount = super.getQueryResult(hql.toString(), map);
		return lstCount.get(0).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeSalaryItem> getPagingEmployeeSalaryItem(int firstResult, int maxResults, String condition,
			Integer type, String date, boolean flag, String salaryItemType) throws DAOException {
		StringBuffer hql = new StringBuffer("");
		Map<String, Object> map = new HashMap<>();

		hql.append("from EmployeeSalaryItem where 1=1");
		if (!flag) {
			if (!condition.equals("")) {
				hql.append(" and employee.name like :condition");
				map.put("condition", "%" + condition + "%");
			}
			if (type != null) {
				hql.append(" and salaryItem.type = :type ");
				map.put("type", type);
			}
			if (!date.equals("")) {
				hql.append(" and dates = :date");
				map.put("date", date);
			}
			if (!salaryItemType.equals("")) {
				hql.append(" and salaryItem.salaryItem = :salaryItemType");
				map.put("salaryItemType", salaryItemType);
			}
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeSalaryItem> getAllEmployeeSalaryItem(Integer type) throws DAOException {
		StringBuffer hql = new StringBuffer("");
		Map<String, Object> map = new HashMap<>();

		hql.append("from EmployeeSalaryItem");
		if (null != type) {
			hql.append(" where salaryItem.type = :type ");
			map.put("type", type);
		}
		List<EmployeeSalaryItem> list = super.getQueryResult(hql.toString(), map);
		return list.isEmpty() ? null : list;
	}

	/**
	 * @category 获取手工录入的值
	 * @param emp
	 * @return
	 * @throws DAOException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public double getEmployeeSalaryItemByEmployee(SalaryItem salaryItem, Employee emp, String yearMs)
			throws DAOException {
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		Map map = new HashMap();
		map.put("emp", emp);
		map.put("yearMs", yearMs);
		map.put("salaryItem", salaryItem);
		String hql = "from EmployeeSalaryItem where employee =:emp and dates =:yearMs and salaryItem =:salaryItem";
		List<EmployeeSalaryItem> list = getQueryResult(hql, map);
		if (list.size() == 0)
			return 0d;
		else
			return list.get(0).getMoney();
	}

	/**
	 * 批量获取手工录入的值
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, EmployeeSalaryDataDTO> getEmployeeSalaryItemValueByEmployeeList(SalaryItem salaryItem,
			List<Employee> listEmployee, String yearMonth) throws DAOException, ParseException {
		String hql = "from EmployeeSalaryItem where employee in (:listEmployee) and dates =:yearMonth and salaryItem =:salaryItem";
		Map<String, Object> map = new HashMap<>();
		map.put("listEmployee", listEmployee);
		map.put("yearMonth", yearMonth);
		map.put("salaryItem", salaryItem);
		List<EmployeeSalaryDataDTO> list = getQueryResult(hql, map);

		Map<String, EmployeeSalaryDataDTO> mapEmployeeSalaryDataDTO = new HashMap<>();

		for (EmployeeSalaryDataDTO employeeSalaryDataDTO : list) {
			mapEmployeeSalaryDataDTO.put(employeeSalaryDataDTO.getEmployeeId() + "_" + salaryItem.getCode(),
					employeeSalaryDataDTO);
		}
		return mapEmployeeSalaryDataDTO;
	}

}
