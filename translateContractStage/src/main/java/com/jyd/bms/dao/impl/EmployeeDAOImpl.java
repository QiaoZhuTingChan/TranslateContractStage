package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.DutyType;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.PositionType;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.EmployeeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class EmployeeDAOImpl extends HibernateBaseTemplate<Employee> implements EmployeeDAO {

	public int getEmployeeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Employee";// state=1：员工离职 state=0:在职
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Employee where name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<Employee> getPagingEmployee(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Employee";
		} else {
			hql = "from Employee where name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Employee> getAllEmployee() throws DAOException {
		String hql = "";
		hql = "from Employee";
		return super.getQueryResult(hql.toString());

	}

	public List<Employee> getEmpByDept(Department condition) throws DAOException {
		String hql = "";
		hql = "from Employee where department = :condition";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		return super.getQueryResult(hql, map);
	}

	public List<Employee> getEmpByDeptAndPosition(Department dept, PositionType position) throws DAOException {
		String hql = "";
		hql = "from Employee where department = :dept and position = :position and state=0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		map.put("position", position);
		return super.getQueryResult(hql, map);
	}

	public List<Employee> getEmpByDeptAndDuty(Department dept, DutyType duty) throws DAOException {
		String hql = "";
		hql = "select emp from Employee emp inner join emp.employeeDutys empDuty where emp.department = :dept and empDuty.dutyType = :duty";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		map.put("duty", duty);
		return super.getQueryResult(hql, map);
	}

	public Employee getHeadByDept(Department dept) throws DAOException {
		if (dept.getDeparmentSupervisor() == null) {
			return null;
		}
		String hql = "";
		hql = "from Employee where id = :id and state = 0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("id", dept.getDeparmentSupervisor().getId());
		Object obj = super.getUniqueResult(hql, map);
		return obj == null ? null : (Employee) obj;
	}

	public List<Employee> getEmpByDeptAndState(Department dept, int state) throws DAOException {
		String hql = "";
		hql = "from Employee where department = :dept and state = :state";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		map.put("state", state);
		return super.getQueryResult(hql, map);
	}

	@Override
	public int getStoreEmployeeCount(String condition, Store store) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Employee employee where employee.department.store = :store";
			Map map = new HashMap();
			map.put("store", store);
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Employee employee where employee.name like :condition and employee.department.store = :store";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			map.put("store", store);
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@Override
	public List<Employee> getPagingStoreEmployee(int firstResult, int maxResults, String condition, Store store)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Employee employee where employee.department.store = :store";
		} else {
			hql = "from Employee employee where employee.name like :condition and employee.department.store = :store";
			map.put("condition", "%" + condition + "%");
		}
		map.put("store", store);
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Employee> findEmpByStoreAndDuty(Store store, DutyType duty) throws DAOException {
		String hql = "";
		hql = "select emp from Employee emp inner join emp.employeeDutys empDuty where emp.department.store = :store and empDuty.dutyType = :duty and emp.state=0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		map.put("duty", duty);
		return super.getQueryResult(hql, map);
	}

	public List<Employee> findEmpByDept(Department dept) throws DAOException {
		String hql = "";
		hql = "from Employee where department = :dept";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		return super.getQueryResult(hql, map);
	}

	/**
	 * 查询员工是否存在，通过身份证查询
	 * 
	 * @throws DAOException
	 */
	@Override
	public int getEmployeeByIdCard(String idCard) throws DAOException {
		String hql = "";
		hql = "select count(*) from Employee where IDNo =:idCard";
		Map map = new HashMap();
		map.put("idCard", idCard);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();

	}

	public Employee findEmpById(int id) throws DAOException {
		String hql = "";
		hql = "from Employee where id = :id and state=0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("id", id);
		return (Employee) super.getUniqueResult(hql, map);
	}

	public List<Employee> findEmpByStateAndShiftStateAndDept(Department dept) throws DAOException {
		String hql = "";
		hql = "from Employee where state = 0 and department = :dept and shiftState != 1";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("dept", dept);
		return super.getQueryResult(hql, map);
	}

	public List<Employee> findEmpByStateAndShiftStateAndStore(Store store) throws DAOException {
		String hql = "";
		hql = "from Employee where state = 0 and department.store = :store and shiftState in (0,3)";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		return super.getQueryResult(hql, map);
	}

	@Override
	public int getEmpCountByDept(Department dept) throws DAOException {
		String hql = "";
		hql = "select count(1) from Employee where department = :dept and state = 0";
		Map map = new HashMap();
		map.put("dept", dept);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getPagingEmployeeWhoNoSelectedSalaryStructure(int firstResult, int maxResults,
			String condition, List<Integer> employeeIds) throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();

		hql.append("from Employee e where 1=1 and e.state = 0");
		if (!condition.equals("")) {
			hql.append(" and e.name like :condition");
			map.put("condition", "%" + condition + "%");
		}
		if (employeeIds != null) {
			hql.append(" and e.id not in(:employeeIds)");
			map.put("employeeIds", employeeIds);
		}

		List<Employee> list = super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getPagingEmployeeWhoNoSelectedSalaryStructure(String condition, List<Integer> employeeIds)
			throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();

		hql.append("select count(*) from Employee e where 1=1 and e.state = 0");
		if (!condition.equals("")) {
			hql.append(" and e.name like :condition");
			map.put("condition", "%" + condition + "%");
		}
		if (employeeIds != null) {
			hql.append(" and e.id not in(:employeeIds)");
			map.put("employeeIds", employeeIds);
		}

		List<Long> list = super.getQueryResult(hql.toString(), map);
		return list.get(0).intValue();
	}

	@Override
	public Employee getEmployeeByIdNo(String idNo) throws Exception {
		if (idNo.trim().length() != 18) {
			return null;
		} else {
			String hql = "from Employee where IDNo = :IDNo";
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("IDNo", idNo);
			List<Employee> employeeList = super.getQueryResult(hql, paramMap);
			if (employeeList.size() > 0) {
				return employeeList.get(0);
			} else {
				return null;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getallDepartmentSupervisor() throws Exception {
		StringBuilder hql = new StringBuilder();

		hql.append(" from Employee e inner join e.department d where e = d.deparmentSupervisor");

		List<Employee> list = this.getQueryResult(hql.toString());

		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findSubordinates(Employee employee) throws Exception {
		StringBuilder hql = new StringBuilder();
		Map<String, Object> map = new HashMap<String, Object>();

		hql.append(" from Employee e inner join Department d where d.deparmentSupervisor = :employee");
		map.put("employee", employee);
		List<Employee> list = super.getQueryResult(hql.toString(), map);

		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeByDepartment(List<Department> departmentList) throws Exception {
		StringBuilder hql = new StringBuilder();
		Map<String, Object> map = new HashMap<String, Object>();
		
		hql.append(" from Employee e  where e.department in (:departmentList) and e.state = 0");
		map.put("departmentList", departmentList);
		
		List<Employee> list = super.getQueryResult(hql.toString(), map);
		return list.isEmpty() ? null : list;
	}
}
