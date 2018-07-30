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
import com.jyd.bms.bean.Insurance;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dao.InsuranceDAO;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * 工资保险dao实现类
 * 
 * @author li
 *
 */
@Repository
public class InsuranceDAOImpl extends HibernateBaseTemplate<Insurance> implements InsuranceDAO {

	@Override
	public List<Insurance> getInsurance() throws DAOException {
		String hql = "";
		hql = "from Insurance order by createDate desc";
		return super.getQueryResult(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getInsuranceCount(String condition) throws DAOException {
		String hql = "";
		List<Long> insuranceList = null;

		if (condition == null || condition.trim().equals("")) {
			hql = " select count(*) from Insurance ";
			insuranceList = super.getQueryResult(hql);
			return insuranceList.get(0).intValue();

		} else {
			hql = " select count(*) from Insurance where employee.name like :condition ";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", "%" + condition + "%");
			insuranceList = super.getQueryResult(hql, map);
			return insuranceList.get(0).intValue();

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insurance> getPagingInsurance(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if (condition == null || condition.trim().equals("")) {
			hql = " from Insurance  ";
		} else {
			hql = " from Insurance where employee.name like :condition order by createDate desc";
			map.put("condition", "%" + condition + "%");
		}

		return super.getPagingQueryResult(hql, map, firstResult, maxResults);
	}

	/**
	 * 获取员工的保险金额
	 * 
	 * @param employee
	 *            员工
	 * @param salaryItem
	 *            薪资项目
	 * @param yearMonth
	 *            年月
	 * @throws ParseException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public double getInsuranceTypeValue(SalaryItem salaryItem, Employee employee, String yearMonth)
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

		Insurance insurance = null;
		String insuranceHql = "from Insurance where employee =:employee and insuranceType.id = :specialValue and beginDate < :date and valid = 1 order by beginDate desc,updateDate desc";
		Map mapInsurance = new HashMap<>();
		mapInsurance.put("employee", employee);
		mapInsurance.put("specialValue", salaryItem.getSpecialValue());
		mapInsurance.put("date", end);
		List<Insurance> listInsurance = getQueryResult(insuranceHql, mapInsurance);

		if (listInsurance.size() > 0) {
			insurance = listInsurance.get(0);
			if (insurance.getEndDate() != null) {
				if (insurance.getEndDate().getTime() < begin.getTime())
					return 0d;
			}
			return insurance.getValue();
		} else {
			return 0d;
		}
	}

	/**
	 * 批量获取员工保险金额
	 * 
	 * @throws ParseException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, EmployeeSalaryDataDTO> getInsuranceTypeValueByEmployeeList(SalaryItem salaryItem,
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

		String insuranceHql = "from Insurance where employee in (:listEmployee) and insuranceType.id = :specialValue and beginDate <= :date and valid = 1 order by beginDate desc,updateDate desc";
		Map mapInsurance = new HashMap<>();
		mapInsurance.put("listEmployee", listEmployee);
		mapInsurance.put("date", begin);
		mapInsurance.put("specialValue", salaryItem.getSpecialValue());

		List<Insurance> list = getQueryResult(insuranceHql, mapInsurance);

		Map<String, EmployeeSalaryDataDTO> mapEmployeeSalaryDataDTO = new HashMap<String, EmployeeSalaryDataDTO>();

		for (Insurance insurance : list) {
			if (mapEmployeeSalaryDataDTO.size() != 0 && mapEmployeeSalaryDataDTO
					.containsKey(insurance.getEmployee().getId() + "_" + salaryItem.getCode()) == false) {
				if (insurance.getEndDate() != null) {
					if (insurance.getEndDate().getTime() < begin.getTime())
						continue;
				}
			}
			mapEmployeeSalaryDataDTO.put(insurance.getEmployee().getId() + "_" + salaryItem.getCode(),
					new EmployeeSalaryDataDTO(insurance.getEmployee().getId(), insurance.getValue()));
		}
		// 判断员工是否都有数据,有值就直接显示,无值就将value值赋为0
		for (Employee employee : listEmployee) {
			if (!mapEmployeeSalaryDataDTO.isEmpty()) {
				mapEmployeeSalaryDataDTO.put(employee.getId() + "_" + salaryItem.getCode(),
						new EmployeeSalaryDataDTO(employee.getId(), 0));
			} else {
				if (mapEmployeeSalaryDataDTO.containsKey(employee.getId() + "_" + salaryItem.getCode()) == false) {
					mapEmployeeSalaryDataDTO.put(employee.getId() + "_" + salaryItem.getCode(),
							new EmployeeSalaryDataDTO(employee.getId(), 0));
				}
			}
		}
		return mapEmployeeSalaryDataDTO;
	}

}
