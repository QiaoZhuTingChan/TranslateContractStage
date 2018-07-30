package com.jyd.bms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.EmployeeBaseSalary;
import com.jyd.bms.bean.EmployeeBaseSalaryHistory;
import com.jyd.bms.bean.EmployeeSalary;
import com.jyd.bms.bean.EmployeeSalaryHistory;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dao.EmployeeBaseSalaryDAO;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class EmployeeBaseSalaryDaoImpl extends HibernateBaseTemplate<EmployeeBaseSalary> implements EmployeeBaseSalaryDAO {
	/**
	 * 获取员工的基本薪资
	 * 
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public double getEmployeeBaseSalaryValue(SalaryItem salaryItem, Employee employee, String yearMonth)
			throws DAOException, ParseException {
		Date begin = null, end = null;
		String year = yearMonth.substring(0, 4);
		String month = yearMonth.substring(4, 6);

		System.out.println("Year:" + year);
		System.out.println("Month:" + month);

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = year + "-" + month + "-01";

		System.out.println("Date:" + dateString);

		try {
			begin = formatter.parse(dateString);
		} catch (ParseException e) {
			throw e;
		}

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(begin);
		calendar.add(calendar.MONTH, 1);
		calendar.add(calendar.DATE, -1);
		end = calendar.getTime();

		EmployeeSalary employeeSalary = null;
		String employeeSalaryHql = "from EmployeeSalary where employee =:employee and effectiveDate < :date order by effectiveDate desc,updateDate desc";
		Map mapEmployeeSalary = new HashMap();
		mapEmployeeSalary.put("employee", employee);
		mapEmployeeSalary.put("date", end);
		List<EmployeeSalary> listEmployeeSalary = getQueryResult(employeeSalaryHql, mapEmployeeSalary);
		if (listEmployeeSalary.size() > 0) {
			employeeSalary = listEmployeeSalary.get(0);
			// 生效日期小于当前月份，直接取明细数据，不然就取历史数据
			if (employeeSalary.getEffectiveDate().getTime() <= end.getTime()) {
				Map map = new HashMap();
				String hql = "from EmployeeBaseSalary where employee = :employee and baseSalaryItem.id =:specialValue";
				map.put("employee", employee);
				map.put("specialValue", salaryItem.getSpecialValue());

				List<EmployeeBaseSalary> list = getQueryResult(hql, map);
				if (list.size() == 0)
					return 0d;
				else
					return list.get(0).getValue();
			}
		}
		// 取不到合适的数据就取历史数据
		Map mapEmployeeSalaryHistory = new HashMap();
		EmployeeSalaryHistory employeeSalaryHistory = null;
		String employeeSalaryHistoryHql = "from EmployeeSalaryHistory where effectiveDate < :date and employee = :employee order by effectiveDate desc,updateDate desc";
		mapEmployeeSalaryHistory.put("date", end);
		mapEmployeeSalaryHistory.put("employee", employee);

		List<EmployeeSalaryHistory> listEmployeeSalaryHistory = getQueryResult(employeeSalaryHistoryHql,
				mapEmployeeSalaryHistory);
		if (listEmployeeSalaryHistory.size() > 0) {
			employeeSalaryHistory = listEmployeeSalaryHistory.get(0);
			// 取历史明细数据
			Map map = new HashMap();
			String hql = "from EmployeeBaseSalaryHistory where employeeSalaryHistory = :employeeSalaryHistory and baseSalaryItem.id =:specialValue";
			map.put("employeeSalaryHistory", employeeSalaryHistory);
			map.put("specialValue", salaryItem.getSpecialValue());

			List<EmployeeBaseSalaryHistory> list = getQueryResult(hql, map);
			if (list.size() == 0)
				return 0d;
			else
				return list.get(0).getValue();
		} else {
			return 0d;
		}
	}

	/**
	 * 批量获取员工基本薪资
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, EmployeeSalaryDataDTO> getEmployeeBaseSalaryValueByEmployeeList(SalaryItem salaryItem,
			List<Employee> listEmployee, String yearMonth) throws DAOException, ParseException {
		Date begin = null, end = null;
		String year = yearMonth.substring(0, 4);
		String month = yearMonth.substring(4, 6);

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = year + "-" + month + "-01";

		try {
			begin = formatter.parse(dateString);
		} catch (ParseException e) {
			throw e;
		}

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(begin);
		calendar.add(calendar.MONTH, 1);
		calendar.add(calendar.DATE, -1);
		end = calendar.getTime();

		Map<String, EmployeeSalaryDataDTO> mapEmployeeSalaryDataDTO = new HashMap<String, EmployeeSalaryDataDTO>();

		String findEmployeeHql = "select a.employee from EmployeeSalary a where a.employee in (:listEmployee) and a.effectiveDate < :date order by a.effectiveDate desc,a.updateDate desc";
		Map mapEmployeeSalary = new HashMap();
		mapEmployeeSalary.put("listEmployee", listEmployee);
		mapEmployeeSalary.put("date", end);
		List<Employee> listFindEmployee = getQueryResult(findEmployeeHql, mapEmployeeSalary);
		if (listFindEmployee.size() > 0) {
			Map map = new HashMap();
			String hql = "from EmployeeBaseSalary where employee in (:listEmployee) and baseSalaryItem.id =:specialValue";
			map.put("listEmployee", listFindEmployee);
			map.put("specialValue", salaryItem.getSpecialValue());

			List<EmployeeBaseSalary> list = getQueryResult(hql, map);
			for (EmployeeBaseSalary employeeSalary : list) {
				mapEmployeeSalaryDataDTO.put(employeeSalary.getEmployee().getId() + "_" + salaryItem.getCode(),
						new EmployeeSalaryDataDTO(employeeSalary.getEmployee().getId(), employeeSalary.getValue()));
			}
		}

		List<Employee> listNotFindEmployee = new ArrayList<Employee>();

		for (Employee employee : listEmployee) {
			boolean find = false;
			for (Employee employeeCheck : listFindEmployee) {
				if (employee.getId() == employeeCheck.getId()) {
					find = true;
					break;
				}
			}

			if (find == false) {
				listNotFindEmployee.add(employee);
			}
		}

		for (Employee employee : listNotFindEmployee) {
			// 取不到合适的数据就取历史数据
			Map mapEmployeeSalaryHistory = new HashMap();
			EmployeeSalaryHistory employeeSalaryHistory = null;
			String employeeSalaryHistoryHql = "from EmployeeSalaryHistory where effectiveDate < :date and employee = :employee order by effectiveDate desc,updateDate desc";
			mapEmployeeSalaryHistory.put("date", end);
			mapEmployeeSalaryHistory.put("employee", employee);

			List<EmployeeSalaryHistory> listEmployeeSalaryHistory = getQueryResult(employeeSalaryHistoryHql,
					mapEmployeeSalaryHistory);

			double value = 0d;
			if (listEmployeeSalaryHistory.size() > 0) {
				employeeSalaryHistory = listEmployeeSalaryHistory.get(0);
				// 取历史明细数据
				Map map = new HashMap();
				String hql = "from EmployeeBaseSalaryHistory where employeeSalaryHistory = :employeeSalaryHistory and baseSalaryItem.id =:specialValue";
				map.put("employeeSalaryHistory", employeeSalaryHistory);
				map.put("specialValue", salaryItem.getSpecialValue());

				List<EmployeeBaseSalaryHistory> list = getQueryResult(hql, map);
				if (list.size() != 0)
					value = list.get(0).getValue();
			}

			mapEmployeeSalaryDataDTO.put(employee.getId() + "_" + salaryItem.getCode(),
					new EmployeeSalaryDataDTO(employee.getId(), value));
		}

		return mapEmployeeSalaryDataDTO;
	}

	@Override
	public int deleteEmployeeBaseSalaryByEmployee(Employee employee) {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		
		hql.append("delete from EmployeeBaseSalary where employee = :employee");
		map.put("employee", employee);
		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery(hql.toString());
		query.setParameter("employee", employee);
		int count = query.executeUpdate();
		
		transaction.commit();
		session.close();
		
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBaseSalary> getEmployeeBaseSalaryByEmployee(Employee employee) throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();
		
		hql.append("from EmployeeBaseSalary where employee = :employee");
		map.put("employee", employee);
		List<EmployeeBaseSalary> list = super.getQueryResult(hql.toString(), map);
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<EmployeeBaseSalary> getSalaryByStructure(int salaryStructureId) throws DAOException {
		String hql = "select s from EmployeeBaseSalary s , EmployeeSalary e where s.employee.id = "
				+ "e.employee.id and e.salaryStructure.id = :salaryStructureId group by s.baseSalaryItem.id";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("salaryStructureId", salaryStructureId);
		List<EmployeeBaseSalary> salaryList =  super.getQueryResult(hql, map);
		if(salaryList != null && salaryList.size() > 0) {
			return salaryList;
		} else {
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBaseSalary> getSalarysByEmployee(Employee employee) throws DAOException {
		String hql = "from EmployeeBaseSalary where employee = :employee";
		Map paramMap = new HashMap();
		paramMap.put("employee", employee);
		return super.getQueryResult(hql, paramMap);
	}

}
