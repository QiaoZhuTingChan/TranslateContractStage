package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.DepartmentDAO;
import com.jyd.bms.dto.DepartmentDTO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
@Transactional
public class DepartmentDAOImpl extends HibernateBaseTemplate<Department> implements DepartmentDAO {

	public int getDepartmentCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from Department";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from Department where departmentName like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<Department> getPagingDepartment(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from Department";
		} else {
			hql = "from Department where departmentName like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<Department> getAllDepartment() throws DAOException {
		String hql = "";
		hql = "from Department where state = 0";
		return super.getQueryResult(hql.toString());

	}

	public List<Department> getDepartmentByParentDept(Department condition) throws DAOException {
		String hql = "";
		hql = "from Department as a where a.parentDepartment = :condition";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		return super.getQueryResult(hql, map);

	}

	public Department getDepartmentByName(String condition) throws DAOException {
		String hql = "";
		hql = "from Department where departmentName = :condition";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		return (Department) super.getUniqueResult(hql, map);

	}

	public Department getDepartmentById(int condition) throws DAOException {
		String hql = "";
		hql = "from Department where id = :condition";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		return (Department) super.getUniqueResult(hql, map);

	}

	public Department getDepartmentByEmpId(int condition) throws DAOException {
		String hql = "";
		hql = "select dept from Department dept inner join dept.employees emp where emp.id = :condition";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("condition", condition);
		return (Department) super.getUniqueResult(hql, map);

	}

	@Override
	public List<Department> getDepartmentByStore(Store store) throws DAOException {
		String hql = "";
		hql = "from Department where store = :store and state = 0";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		return super.getQueryResult(hql, map);
	}

	@Override
	public List<com.jyd.bms.dto.DepartmentDTO> getDepartmentDTOAll() throws DAOException {
		StringBuilder hql = new StringBuilder();
		hql.append("select new com.jyd.bms.dto.DepartmentDTO(");
		hql.append("d.id,");
		hql.append("d.departmentName,");
		hql.append("d.parentDepartment.id as parentDeptDTO,");
		hql.append("(select name from Employee where id=d.deparmentSupervisor and state=0) as supervisor,");
		hql.append("d.actualNums,");
		hql.append("d.totalActualNums,");
		hql.append("d.staffNums,");
		hql.append("d.totalStaffNums,");
		hql.append("d.store.shortName as storeName,");
		hql.append("d.remark)");
		hql.append(" from Department d where d.state=0");
		return super.getQueryResult(hql.toString());
	}

	@Override
	public List<DepartmentDTO> getDepartmentDTOByStore(Store store) throws DAOException {
		StringBuilder hql = new StringBuilder();
		hql.append("select new com.jyd.bms.dto.DepartmentDTO(");
		hql.append("d.id,");
		hql.append("d.departmentName,");
		hql.append("d.parentDepartment.id as parentDeptDTO,");
		hql.append("(select name from Employee where id=d.deparmentSupervisor and state=0) as supervisor,");
		hql.append("d.actualNums,");
		hql.append("d.totalActualNums,");
		hql.append("d.staffNums,");
		hql.append("d.totalStaffNums,");
		hql.append("d.store.shortName as storeName,");
		hql.append("d.remark)");
		hql.append(" from Department d where d.state=0");
		hql.append(" and d.store = :store");
		Map map = new HashMap();
		map.put("store", store);
		return super.getQueryResult(hql.toString(), map);
	}

	@Override
	public List<DepartmentDTO> getNubmerOfDepartments() throws DAOException {
		StringBuilder hql = new StringBuilder();
		hql.append("select new com.jyd.bms.dto.DepartmentDTO(");
		hql.append("d.id,");
		hql.append("d.parentDepartment.id as parentDeptDTO,");
		hql.append("(select count(1) from Employee where department=d.id and state=0) as actualNums,");
		hql.append("(select count(1) from Employee where department=d.id and state=0) as totalActualNums,");
		hql.append("(select sum(nums) from Staff where department=d.id) as staffNums,");
		hql.append("(select sum(nums) from Staff where department=d.id) as totalStaffNums)");
		hql.append(" from Department d where d.state=0");
		return super.getQueryResult(hql.toString());
	}

	@Override
	public List<Department> getSubDepartmentsByDeparmentSupervisor(Employee employee) throws DAOException{
		StringBuilder hql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();
		
		hql.append(" from Department d where d.deparmentSupervisor = :employee");
		map.put("employee", employee);
		
		List<Department> list = super.getQueryResult(hql.toString(), map);
		
		return list.isEmpty() ? null : list;
	}

}
