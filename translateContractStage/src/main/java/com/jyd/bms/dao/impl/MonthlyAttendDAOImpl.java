package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.MonthlyAttend;
import com.jyd.bms.bean.SalaryItem;
import com.jyd.bms.dao.MonthlyAttendDAO;
import com.jyd.bms.dto.EmployeeSalaryDataDTO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class MonthlyAttendDAOImpl extends HibernateBaseTemplate<MonthlyAttend> implements MonthlyAttendDAO {

	/**
	 * 获取员工月考勤结果
	 * 
	 * @param salaryItem
	 *            薪资项目
	 * @param employee
	 *            员工
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public double getEmployeeMonthAttendenceValue(SalaryItem salaryItem, Employee employee, String yearMonth)
			throws DAOException {
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		String hql = "from MonthlyAttend where empMonth.employee = :employee and empMonth.attendMonth =:yearMonth and attendType = :attendType and type = :type";

		map.put("employee", employee);
		map.put("yearMonth", yearMonth);
		map.put("attendType", salaryItem.getType());
		map.put("type", salaryItem.getSpecialValue());

		List<MonthlyAttend> list = getQueryResult(hql, map);
		if (list.size() == 0)
			return 0d;
		else
			return list.get(0).getValue();
	}

	
	/**
	 * 批量获取员工月考勤结果
	 * 
	 * @param salaryItem
	 *            薪资项目
	 * @param listEmployee
	 *            员工列表
	 * @param yearMonth
	 *            年月
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, EmployeeSalaryDataDTO> getEmployeeMonthAttendenceValueByEmployeeList(SalaryItem salaryItem,
			List<Employee> listEmployee, String yearMonth) throws DAOException {
		Map map = new HashMap();
		String hql = "select new com.jyd.bms.dto.EmployeeSalaryDataDTO(m.empMonth.employee.id,m.value) from MonthlyAttend m where m.empMonth.employee in (:listEmployee) and m.empMonth.attendMonth =:yearMonth and m.attendType = :attendType and m.type = :type";

		map.put("listEmployee", listEmployee);
		map.put("yearMonth", yearMonth);
		map.put("attendType", salaryItem.getType());
		map.put("type", salaryItem.getSpecialValue());

		List<EmployeeSalaryDataDTO> list = getQueryResult(hql, map);

		Map<String, EmployeeSalaryDataDTO> mapEmployeeSalaryDataDTO = new HashMap<String, EmployeeSalaryDataDTO>();

		for (EmployeeSalaryDataDTO employeeSalaryDataDTO : list) {
			mapEmployeeSalaryDataDTO.put(employeeSalaryDataDTO.getEmployeeId() + "_" + salaryItem.getCode(),
					employeeSalaryDataDTO);
		}

		return mapEmployeeSalaryDataDTO;
	}

}
