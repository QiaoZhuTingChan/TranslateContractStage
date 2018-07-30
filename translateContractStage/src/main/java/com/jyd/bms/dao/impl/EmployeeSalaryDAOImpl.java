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
import com.jyd.bms.bean.EmployeeSalary;
import com.jyd.bms.bean.EmployeeSalaryHistory;
import com.jyd.bms.bean.SalaryStructure;
import com.jyd.bms.dao.EmployeeSalaryDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class EmployeeSalaryDAOImpl extends HibernateBaseTemplate<EmployeeSalary> implements EmployeeSalaryDAO {

	public int getEmployeeSalaryCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from EmployeeSalary";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from EmployeeSalary where employee.name like :condition";
			Map<String, String> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<EmployeeSalary> getPagingEmployeeSalary(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, String> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from EmployeeSalary";
		} else {
			hql = "from EmployeeSalary where employee.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<EmployeeSalary> getAllEmployeeSalary() throws DAOException {
		String hql = "";
		hql = "from EmployeeSalary";
		return super.getQueryResult(hql.toString());
	}

	@Override
	public EmployeeSalary getEmployeeSalaryByEmployee(Employee employee) throws DAOException {
		String hql = "";
		Map<String, Integer> map = new HashMap<>();
		if (null != employee) {
			hql = "from EmployeeSalary where employee.id = :empId";
			map.put("empId", employee.getId());
			return (EmployeeSalary) super.getUniqueResult(hql, map);
		}
		return null;
	}

	/**
	 * 获取员工薪资结构
	 * 
	 * @param employee
	 *            员工
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public SalaryStructure getEmployeeSalaryStructureByYearMonth(Employee employee, String yearMonth)
			throws DAOException, ParseException {
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

		EmployeeSalary employeeSalary = null;
		String employeeSalaryHql = "select a.salaryStructure from EmployeeSalary a where a.employee =:employee and a.effectiveDate < :date order by a.effectiveDate desc,a.updateDate desc";
		Map mapEmployeeSalary = new HashMap();
		mapEmployeeSalary.put("employee", employee);
		mapEmployeeSalary.put("date", end);
		List<SalaryStructure> listSalaryStructure = getQueryResult(employeeSalaryHql, mapEmployeeSalary);
		if (listSalaryStructure.size() > 0) {
			return listSalaryStructure.get(0);
		} else {
			// 取不到合适的数据就取历史数据
			Map mapEmployeeSalaryHistory = new HashMap();
			EmployeeSalaryHistory employeeSalaryHistory = null;
			String employeeSalaryHistoryHql = "select a.salaryStructure from EmployeeSalaryHistory a where a.effectiveDate < :date and a.employee = :employee order by a.effectiveDate desc,a.updateDate desc";
			mapEmployeeSalaryHistory.put("date", end);
			mapEmployeeSalaryHistory.put("employee", employee);
			List<SalaryStructure> listSalaryStructureHistory = getQueryResult(employeeSalaryHistoryHql,
					mapEmployeeSalary);
			if (listSalaryStructureHistory.size() > 0) {
				return listSalaryStructureHistory.get(0);
			}
		}
		return null;
	}

	/**
	 * 获取员工薪资结构
	 * 
	 * @param listEmployee
	 *            员工列表
	 * @param yearMonth
	 *            年月
	 * @param listUnkownSalaryStructureEmployee
	 *            找不到员工薪资结构的员工
	 * @return
	 * @throws DAOException
	 * @throws ParseException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EmployeeSalary> getEmployeeSalaryStructureByYearMonth(List<Employee> listEmployee, String yearMonth,
			List<Employee> listUnkownSalaryStructureEmployee) throws DAOException, ParseException {
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
		// end=formatter.parse(formatter.format(end));

		String employeeSalaryHql = "from EmployeeSalary a where a.employee in (:listEmployee) and a.effectiveDate < :date order by a.effectiveDate desc,a.updateDate desc";
		Map mapEmployeeSalary = new HashMap();
		mapEmployeeSalary.put("listEmployee", listEmployee);
		mapEmployeeSalary.put("date", end);
		List<EmployeeSalary> listEmployeeSalary = getQueryResult(employeeSalaryHql, mapEmployeeSalary);

		for (Employee employee : listEmployee) {
			boolean find = false;

			for (EmployeeSalary employeeSalary : listEmployeeSalary) {
				if (employeeSalary.getEmployee().getId() == employee.getId()) {
					find = true;
					break;
				}
			}

			if (find == false) {
				// 取不到合适的数据就取历史数据
				Map mapEmployeeSalaryHistory = new HashMap();
				EmployeeSalaryHistory employeeSalaryHistory = null;
				String employeeSalaryHistoryHql = "select a.salaryStructure from EmployeeSalaryHistory a where a.effectiveDate < :date and a.employee = :employee order by a.effectiveDate desc,a.updateDate desc";
				mapEmployeeSalaryHistory.put("date", end);
				mapEmployeeSalaryHistory.put("employee", employee);
				List<SalaryStructure> listSalaryStructureHistory = getQueryResult(employeeSalaryHistoryHql,
						mapEmployeeSalaryHistory);
				if (listSalaryStructureHistory.size() > 0) {
					EmployeeSalary employeeSalary = new EmployeeSalary();
					employeeSalary.setEmployee(employee);
					employeeSalary.setSalaryStructure(listSalaryStructureHistory.get(0));

					listEmployeeSalary.add(employeeSalary);
				} else {
					listUnkownSalaryStructureEmployee.add(employee);
				}
			}
		}
		return listEmployeeSalary;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeWhoHasSalaryStracture() throws DAOException {
		StringBuilder hql = new StringBuilder("");
		hql.append("select distinct(s.employee) from EmployeeSalary s where s.salaryStructure is not null");

		List<Employee> list = super.getQueryResult(hql.toString());
		return list;
	}

	@Override
	public EmployeeSalary getSalaryAndStructureByEmployee(Employee employee) throws DAOException {
		// select  s.salary_level_id,s4.salary_level,s.salary_structure_id,s3.salary_structure 
//		,s2.base_salary_item,s1.value,s.employee_id
//
//		from sal_employee_salary s INNER JOIN sal_employee_base_salary s1 on s.employee_id = s1.employee_id
//		INNER JOIN sal_base_salary_item s2 on s1.base_salary_item_id = s2.id
//		inner join sal_salary_structure s3 on s.salary_structure_id = s3.id
//		INNER JOIN ba_salary_level s4 on s.salary_level_id = s4.id
		
		StringBuilder sb = new StringBuilder();
		sb.append(" from EmployeeSalary s ");
		sb.append(" where s.employee = :employee ");
		Map map = new HashMap();
		map.put("employee", employee);
		return  super.getQueryResult(sb.toString(),map) == null ? null:(EmployeeSalary)super.getQueryResult(sb.toString(),map).get(0);
	}

}