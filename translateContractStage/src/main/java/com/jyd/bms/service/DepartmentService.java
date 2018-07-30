package com.jyd.bms.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.EmpExperience;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.ParentDepartment;
import com.jyd.bms.bean.SonDepartment;
import com.jyd.bms.bean.Staff;
import com.jyd.bms.bean.Store;
import com.jyd.bms.bean.User;
import com.jyd.bms.dao.CustomerContractDAO;
import com.jyd.bms.dao.DepartmentDAO;
import com.jyd.bms.dao.EmpExperienceDAO;
import com.jyd.bms.dao.EmployeeDAO;
import com.jyd.bms.dao.ParentDepartmentDAO;
import com.jyd.bms.dao.SonDepartmentDAO;
import com.jyd.bms.dao.StaffDAO;
import com.jyd.bms.dto.DepartmentDTO;
import com.jyd.bms.tool.exception.CreateException;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DataNotFoundException;
import com.jyd.bms.tool.exception.DeleteException;
import com.jyd.bms.tool.exception.UpdateException;
import com.jyd.bms.tool.zk.UserSession;

@Service("DepartmentService")
public class DepartmentService extends BaseService<Department> {
	@Autowired(required = true)
	private DepartmentDAO departmentDAO;
	@Autowired(required = true)
	private StaffDAO staffDAO;
	@Autowired(required = true)
	private EmployeeDAO employeeDAO;
	@Autowired(required = true)
	private EmpExperienceDAO empExperienceDAO;
	@Autowired(required = true)
	private CustomerContractDAO customerContractDAO;
	@Autowired(required = true)
	private ParentDepartmentDAO parentDepartmentDAO;
	@Autowired(required = true)
	private SonDepartmentDAO sonDepartmentDAO;

	public int getDepartmentCount(String condition) throws DAOException {
		return departmentDAO.getDepartmentCount(condition);
	}

	public List<Department> getPagingDepartment(int firstResult, int maxResults, String condition) throws DAOException {
		return departmentDAO.getPagingDepartment(firstResult, maxResults, condition);
	}

	public List<Department> getAllDepartment() throws DAOException {
		return departmentDAO.getAllDepartment();
	}

	public int facTotalActualNums(Department dept) throws DAOException {
		if (departmentDAO.getDepartmentByParentDept(dept).isEmpty()) {
			return dept.getActualNums();
		} else {
			List<Department> depts = departmentDAO.getDepartmentByParentDept(dept);
			int nums = dept.getActualNums();
			for (Department department : depts) {
				nums = nums + facTotalActualNums(department);
			}
			return nums;
		}
	}

	public int getTotalActualNums(Department dept) throws NumberFormatException, DAOException, DataNotFoundException {
		int num = dept.getActualNums();
		List<SonDepartment> sonDepartments = sonDepartmentDAO.findSonDepartmentByDept(dept);
		List<Department> sonDepts = new ArrayList<Department>();
		for (SonDepartment sonDept : sonDepartments) {
			sonDepts.add(sonDept.getSonDepartment());
		}
		for (Department department : sonDepts) {
			num += department.getActualNums();
		}
		return num;
	}

	public void getTotalActualNumsAndTotalStaffNums(Department dept)
			throws NumberFormatException, DAOException, DataNotFoundException, UpdateException {
		dept.setTotalActualNums(getTotalActualNums(dept));
		dept.setTotalStaffNums(getTotalStaffNums(dept));
		departmentDAO.update(dept);
	}

	public void facParentTANums(Department dept) throws DAOException, UpdateException, DataNotFoundException {
		if (dept.getParentDepartment() == null) {
			return;
		} else {
			Department ParentDept = departmentDAO.getById(dept.getParentDepartment().getId());
			List<Department> depts = departmentDAO.getDepartmentByParentDept(ParentDept);
			int nums = ParentDept.getActualNums();
			for (Department department : depts) {
				nums = nums + facTotalActualNums(department);
			}
			ParentDept.setTotalActualNums(nums);
			// departmentDAO.merge(ParentDept);
			departmentDAO.update(ParentDept);
			facParentTANums(ParentDept);
		}
	}

	public void getParentTotalActualNums(Department dept) throws DAOException, DataNotFoundException, UpdateException {
		List<Department> parentDepts = new ArrayList<Department>();
		for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(dept)) {
			parentDepts.add(parentDepartment.getParentDepartment());
		}
		for (Department parentDept : parentDepts) {
			Department parentDepartment = departmentDAO.getById(parentDept.getId());
			parentDepartment.setTotalActualNums(getTotalActualNums(parentDepartment));
			// parentDept.setTotalStaffNums(getTotalStaffNums(parentDept));
			departmentDAO.update(parentDepartment);
		}
	}

	public int countStaffNums(Department dept) throws DAOException {
		List<Staff> staffs = staffDAO.getStaffByDept(dept);
		int staffNums = 0;
		for (Staff stf : staffs) {
			staffNums = staffNums + stf.getNums();
		}
		return staffNums;
	}

	public int facTotalStaffNums(Department dept) throws DAOException {
		if (departmentDAO.getDepartmentByParentDept(dept).isEmpty()) {
			return dept.getStaffNums();
		} else {
			List<Department> depts = departmentDAO.getDepartmentByParentDept(dept);
			int nums = dept.getStaffNums();
			for (Department department : depts) {
				nums = nums + facTotalStaffNums(department);
			}
			return nums;
		}
	}

	public int getTotalStaffNums(Department dept) throws NumberFormatException, DAOException, DataNotFoundException {
		int num = dept.getStaffNums();
		List<Department> sonDepts = new ArrayList<Department>();
		for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(dept)) {
			sonDepts.add(sonDepartment.getSonDepartment());
		}
		for (Department department : sonDepts) {
			num += department.getStaffNums();
		}
		return num;
	}

	public void facParentTSNums(Department dept) throws DAOException, UpdateException, DataNotFoundException {
		if (dept.getParentDepartment() == null) {
			return;
		} else {
			Department parentDept = departmentDAO.getById(dept.getParentDepartment().getId());
			List<Department> depts = departmentDAO.getDepartmentByParentDept(parentDept);
			int nums = parentDept.getStaffNums();
			for (Department department : depts) {
				nums = nums + facTotalStaffNums(department);
			}
			parentDept.setTotalStaffNums(nums);
			// departmentDAO.merge(parentDept);
			departmentDAO.update(parentDept);
			facParentTSNums(parentDept);
		}
	}

	public void getParentTotalStaffNums(Department dept) throws DAOException, DataNotFoundException, UpdateException {
		List<Department> parentDepts = new ArrayList<Department>();
		for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(dept)) {
			parentDepts.add(parentDepartment.getParentDepartment());
		}
		for (Department parentDept : parentDepts) {
			Department parentDepartment = departmentDAO.getById(parentDept.getId());
			// parentDept.setTotalActualNums(getTotalActualNums(parentDept));
			parentDepartment.setTotalStaffNums(getTotalStaffNums(parentDepartment));
			departmentDAO.update(parentDepartment);
		}
	}

	public void getParentTotalActualNumsAndTotalStaffNums(Department dept)
			throws DAOException, UpdateException, DataNotFoundException {
		List<Department> parentDepts = new ArrayList<Department>();
		for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(dept)) {
			parentDepts.add(parentDepartment.getParentDepartment());
		}
		for (Department parentDept : parentDepts) {
			Department parentDepartment = departmentDAO.getById(parentDept.getId());
			parentDepartment.setTotalActualNums(getTotalActualNums(parentDepartment));
			parentDepartment.setTotalStaffNums(getTotalStaffNums(parentDepartment));
			departmentDAO.update(parentDepartment);
		}
		// if (dept.getParentDepartment() == null) {
		// return;
		// } else {
		// Department parentDept =
		// departmentDAO.getById(dept.getParentDepartment().getId());
		// List<Department> depts = departmentDAO.getDepartmentByParentDept(parentDept);
		// int totalActualNums = parentDept.getActualNums();
		// for (Department department : depts) {
		// totalActualNums = totalActualNums + facTotalActualNums(department);
		// }
		// parentDept.setTotalActualNums(totalActualNums);
		// int totalStaffNums = parentDept.getStaffNums();
		// for (Department department : depts) {
		// totalStaffNums = totalStaffNums + facTotalStaffNums(department);
		// }
		// parentDept.setTotalStaffNums(totalStaffNums);
		// departmentDAO.update(parentDept);
		// getParentTotalActualNumsAndTotalStaffNums(parentDept);
		// }

	}

	public String getParentDeptIds(Department dept) throws DAOException {
		if (dept.getParentDepartment() != null) {
			String parentId = String.valueOf(dept.getParentDepartment().getId()) + ",";
			// String deptId = String.valueOf(dept.getId()) + ",";
			// String parentId =
			// getParentDeptIds(departmentDAO.getDepartmentById(dept.getParentDepartment().getId()));
			return getParentDeptIds(departmentDAO.getDepartmentById(dept.getParentDepartment().getId())) + parentId;
		} else {
			return "";
		}
	}

	public List<Department> getParentDepts(Department dept)
			throws DAOException, NumberFormatException, DataNotFoundException {
		List<Department> parentDepts = new ArrayList<Department>();
		if (getParentDeptIds(dept).equals("")) {
			return parentDepts;
		} else {
			String parentDeptIds[] = getParentDeptIds(dept).split(",");
			for (int i = 0; i < parentDeptIds.length; i++) {
				parentDepts.add(departmentDAO.getById(Integer.parseInt(parentDeptIds[i])));
			}
			return parentDepts;
		}
	}

	public boolean checkParentIdUp(Department dept) throws DAOException {
		if (dept.getParentDepartment() == null) {
			return true;
		} else {
			String str = getParentDeptIds(dept);
			String s[] = str.split(",");
			for (int i = 0; i < s.length - 1; i++) {
				if (departmentDAO.getDepartmentById(Integer.parseInt(s[i])).getId() == dept.getId()) {
					return false;
				}
			}
			return true;
		}
	}

	public String getSonDeptIds(Department dept) throws DAOException {
		if (!departmentDAO.getDepartmentByParentDept(dept).isEmpty()) {
			List<Department> depts = departmentDAO.getDepartmentByParentDept(dept);
			String son = "";
			for (Department department : depts) {
				son = son + String.valueOf(department.getId()) + "," + getSonDeptIds(department);
			}
			return son;
		} else {
			return "";
		}
	}

	public List<Department> getSonDepts(Department dept)
			throws DAOException, NumberFormatException, DataNotFoundException {
		List<Department> sonDepts = new ArrayList<Department>();
		if (getSonDeptIds(dept) == "") {
			return sonDepts;
		} else {
			String[] sonDeptIds = getSonDeptIds(dept).split(",");
			for (int i = 0; i < sonDeptIds.length; i++) {
				sonDepts.add(departmentDAO.getById(Integer.parseInt(sonDeptIds[i])));
			}
			return sonDepts;
		}
	}

	public boolean checkParentIdSelf(Department dept) {
		if (dept.getParentDepartment() == null) {
			return true;
		} else if (dept.getParentDepartment().getId() == dept.getId()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkParentIdDown(Department dept) throws DAOException {
		if (departmentDAO.getDepartmentByParentDept(dept).isEmpty()) {
			return true;
		} else {
			String sonDeptIds = getSonDeptIds(dept);
			String son[] = sonDeptIds.split(",");
			for (int i = 0; i < son.length; i++) {
				if (dept.getParentDepartment().getId() == departmentDAO.getDepartmentById(Integer.parseInt(son[i]))
						.getId()) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * 添加部门
	 * 
	 * @param dept
	 *            添加的部门
	 * @return 添加的结果
	 */
	public boolean addDept(Department dept)
			throws DAOException, CreateException, UpdateException, DataNotFoundException {
		departmentDAO.add(dept);
		updateNumberDepartments();
		return true;
	}

	/**
	 * 删除部门
	 * 
	 * @param dept
	 *            删除的部门
	 * @return 删除的结果
	 */
	public boolean deleteDept(Department dept)
			throws DeleteException, DAOException, UpdateException, DataNotFoundException {
		// departmentDAO.delete(dept);
		dept.setState(1);
		dept.setActualNums(0);
		dept.setStaffNums(0);
		departmentDAO.update(dept);
		getParentTotalActualNumsAndTotalStaffNums(dept);
		return true;
	}

	// public void deleteDeptAll(Department dept) throws DeleteException,
	// DAOException {

	// List<Employee> emps = employeeDAO.findEmpByDept(dept);
	// for(Employee emp : emps) {
	// employeeDAO.delete(emp);
	// }
	// departmentDAO.delete(dept);
	// List<ParentDepartment> ParentDepartments =
	// parentDepartmentDAO.findParentDepartmentByDept(dept);

	// }

	public void deleteEmp() throws DAOException, DeleteException {
		List<Employee> noDeptEmps = employeeDAO.findEmpByDept(null);
		for (Employee emp : noDeptEmps) {
			employeeDAO.delete(emp);
		}
	}

	public boolean checkSuper(Department dept, int newId) {
		if (dept.getParentDepartment() == null) {
			return false;
		} else {
			if (dept.getParentDepartment().getId() == newId) {
				return true;
			} else {
				return checkSuper(dept.getParentDepartment(), newId);
			}
		}
	}

	public String getSpacingParentDeptIds(Department dept, int newId) throws DAOException {
		if (dept.getParentDepartment().getId() == newId) {
			return "";
		} else {
			String deptId = String.valueOf(dept.getId());
			String parentId = getSpacingParentDeptIds(
					departmentDAO.getDepartmentById(dept.getParentDepartment().getId()), newId);
			return parentId + deptId;
		}
	}

	public boolean updateDeptCase(Department dept, Department originalParentDept, Department newParentDept)
			throws DataNotFoundException, UpdateException {
		List<Department> list = new ArrayList<Department>();

		Department parentDepartment = dept;
		while (parentDepartment.getParentDepartment() != null) {
			parentDepartment = parentDepartment.getParentDepartment();
			list.add(parentDepartment);
		}
		int total = 0;
		if (dept.getStaffs() != null) {
			Iterator<Staff> it = dept.getStaffs().iterator();
			while (it.hasNext()) {
				Staff value = it.next();
				total += value.getNums();
			}
		}

		Department oldDepartment = departmentDAO.getById(dept.getId());
		int oldStaffNums = oldDepartment.getStaffNums();

		int diffence = total - oldStaffNums;
		dept.setStaffNums(total);
		dept.setTotalStaffNums(dept.getTotalStaffNums() + diffence);

		departmentDAO.update(dept);

		if (diffence != 0) {
			for (Department tempDepartment : list) {
				tempDepartment.setTotalStaffNums(tempDepartment.getTotalStaffNums() + diffence);
				departmentDAO.update(tempDepartment);
			}
		}
		return true;
	}

	/**
	 * 修改部门
	 * 
	 * @param dept
	 *            修改的部门
	 * @param originalParentDept
	 *            修改的部门原来的父部门
	 * @param newParentDept
	 *            修改的部门修改后的父部门
	 * @return 修改的结果
	 */
	public boolean updateDeptPrevious(Department dept, Department originalParentDept, Department newParentDept)
			throws Exception {
		departmentDAO.update(dept);
		dept.setParentDepartment(newParentDept);
		dept.setTotalActualNums(getTotalActualNums(dept));
		dept.setStaffNums(countStaffNums(dept));
		dept.setTotalStaffNums(getTotalStaffNums(dept));
		// dept.setTotalActualNums(facTotalActualNums(dept));
		// dept.setTotalStaffNums(facTotalStaffNums(dept));
		departmentDAO.update(dept);
		getParentTotalActualNumsAndTotalStaffNums(dept);
		if (originalParentDept != null && originalParentDept.getId() != newParentDept.getId()) {
			originalParentDept = departmentDAO.getById(originalParentDept.getId());
			originalParentDept.setTotalActualNums(getTotalActualNums(originalParentDept));
			originalParentDept.setTotalStaffNums(getTotalStaffNums(originalParentDept));
			departmentDAO.update(originalParentDept);
			getParentTotalActualNumsAndTotalStaffNums(originalParentDept);
		}
		return true;
	}

	public boolean updateDeptQ(Department dept, Department originalParentDept, Department newParentDept)
			throws UpdateException, NumberFormatException, DAOException, DataNotFoundException, DeleteException,
			CreateException {
		departmentDAO.update(dept);
		dept.setParentDepartment(newParentDept);
		if (originalParentDept == null && newParentDept == null) {
			dept.setStaffNums(countStaffNums(dept));
			departmentDAO.update(dept);
		} else if (originalParentDept == null && newParentDept != null) {
			for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(newParentDept)) {
				parentDepartmentDAO.delete(parentDepartment);
			}
			// List<ParentDepartment> parentDepartments = new ArrayList<ParentDepartment>();
			for (Department parentDept : getParentDepts(newParentDept)) {
				ParentDepartment parentDepartment = new ParentDepartment();
				parentDepartment.setDepartment(newParentDept);
				parentDepartment.setParentDepartment(parentDept);
				parentDepartmentDAO.add(parentDepartment);
			}
			for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(newParentDept)) {
				sonDepartmentDAO.delete(sonDepartment);
			}
			for (Department sonDept : getSonDepts(newParentDept)) {
				SonDepartment sonDepartment = new SonDepartment();
				sonDepartment.setDepartment(newParentDept);
				sonDepartment.setSonDepartment(sonDept);
				sonDepartmentDAO.add(sonDepartment);
			}
			for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(dept)) {
				parentDepartmentDAO.delete(parentDepartment);
			}
			for (Department parentDept : getParentDepts(dept)) {
				ParentDepartment parentDepartment = new ParentDepartment();
				parentDepartment.setDepartment(dept);
				parentDepartment.setParentDepartment(parentDept);
				parentDepartmentDAO.add(parentDepartment);
			}
			for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(dept)) {
				sonDepartmentDAO.delete(sonDepartment);
			}
			for (Department sonDept : getSonDepts(dept)) {
				SonDepartment sonDepartment = new SonDepartment();
				sonDepartment.setDepartment(dept);
				sonDepartment.setSonDepartment(sonDept);
				sonDepartmentDAO.add(sonDepartment);
			}
			dept.setTotalActualNums(getTotalActualNums(dept));
			dept.setStaffNums(countStaffNums(dept));
			dept.setTotalStaffNums(getTotalStaffNums(dept));
			departmentDAO.update(dept);
			getParentTotalActualNumsAndTotalStaffNums(dept);
		} else if (originalParentDept != null && newParentDept == null) {
			for (ParentDepartment parentDepartment : parentDepartmentDAO
					.findParentDepartmentByDept(originalParentDept)) {
				parentDepartmentDAO.delete(parentDepartment);
			}
			// List<ParentDepartment> parentDepartments = new ArrayList<ParentDepartment>();
			for (Department parentDept : getParentDepts(originalParentDept)) {
				ParentDepartment parentDepartment = new ParentDepartment();
				parentDepartment.setDepartment(originalParentDept);
				parentDepartment.setParentDepartment(parentDept);
				parentDepartmentDAO.add(parentDepartment);
			}
			for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(originalParentDept)) {
				sonDepartmentDAO.delete(sonDepartment);
			}
			for (Department sonDept : getSonDepts(originalParentDept)) {
				SonDepartment sonDepartment = new SonDepartment();
				sonDepartment.setDepartment(originalParentDept);
				sonDepartment.setSonDepartment(sonDept);
				sonDepartmentDAO.add(sonDepartment);
			}
			for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(dept)) {
				parentDepartmentDAO.delete(parentDepartment);
			}
			for (Department parentDept : getParentDepts(dept)) {
				ParentDepartment parentDepartment = new ParentDepartment();
				parentDepartment.setDepartment(dept);
				parentDepartment.setParentDepartment(parentDept);
				parentDepartmentDAO.add(parentDepartment);
			}
			for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(dept)) {
				sonDepartmentDAO.delete(sonDepartment);
			}
			for (Department sonDept : getSonDepts(dept)) {
				SonDepartment sonDepartment = new SonDepartment();
				sonDepartment.setDepartment(dept);
				sonDepartment.setSonDepartment(sonDept);
				sonDepartmentDAO.add(sonDepartment);
			}
			dept.setTotalActualNums(getTotalActualNums(dept));
			dept.setStaffNums(countStaffNums(dept));
			dept.setTotalStaffNums(getTotalStaffNums(dept));
			departmentDAO.update(dept);
			getParentTotalActualNumsAndTotalStaffNums(dept);
		} else if (originalParentDept.getId() == newParentDept.getId()) {
			dept.setTotalActualNums(getTotalActualNums(dept));
			dept.setStaffNums(countStaffNums(dept));
			dept.setTotalStaffNums(getTotalStaffNums(dept));
			departmentDAO.update(dept);
			getParentTotalActualNumsAndTotalStaffNums(dept);
		} else {
			for (ParentDepartment parentDepartment : parentDepartmentDAO
					.findParentDepartmentByDept(originalParentDept)) {
				parentDepartmentDAO.delete(parentDepartment);
			}
			// List<ParentDepartment> parentDepartments = new ArrayList<ParentDepartment>();
			for (Department parentDept : getParentDepts(originalParentDept)) {
				ParentDepartment parentDepartment = new ParentDepartment();
				parentDepartment.setDepartment(originalParentDept);
				parentDepartment.setParentDepartment(parentDept);
				parentDepartmentDAO.add(parentDepartment);
			}
			for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(originalParentDept)) {
				sonDepartmentDAO.delete(sonDepartment);
			}
			for (Department sonDept : getSonDepts(originalParentDept)) {
				SonDepartment sonDepartment = new SonDepartment();
				sonDepartment.setDepartment(originalParentDept);
				sonDepartment.setSonDepartment(sonDept);
				sonDepartmentDAO.add(sonDepartment);
			}
			for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(newParentDept)) {
				parentDepartmentDAO.delete(parentDepartment);
			}
			// List<ParentDepartment> parentDepartments = new ArrayList<ParentDepartment>();
			for (Department parentDept : getParentDepts(newParentDept)) {
				ParentDepartment parentDepartment = new ParentDepartment();
				parentDepartment.setDepartment(newParentDept);
				parentDepartment.setParentDepartment(parentDept);
				parentDepartmentDAO.add(parentDepartment);
			}
			for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(newParentDept)) {
				sonDepartmentDAO.delete(sonDepartment);
			}
			for (Department sonDept : getSonDepts(newParentDept)) {
				SonDepartment sonDepartment = new SonDepartment();
				sonDepartment.setDepartment(newParentDept);
				sonDepartment.setSonDepartment(sonDept);
				sonDepartmentDAO.add(sonDepartment);
			}
			for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(dept)) {
				parentDepartmentDAO.delete(parentDepartment);
			}
			for (Department parentDept : getParentDepts(dept)) {
				ParentDepartment parentDepartment = new ParentDepartment();
				parentDepartment.setDepartment(dept);
				parentDepartment.setParentDepartment(parentDept);
				parentDepartmentDAO.add(parentDepartment);
			}
			for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(dept)) {
				sonDepartmentDAO.delete(sonDepartment);
			}
			for (Department sonDept : getSonDepts(dept)) {
				SonDepartment sonDepartment = new SonDepartment();
				sonDepartment.setDepartment(dept);
				sonDepartment.setSonDepartment(sonDept);
				sonDepartmentDAO.add(sonDepartment);
			}
			dept.setTotalActualNums(getTotalActualNums(dept));
			dept.setStaffNums(countStaffNums(dept));
			dept.setTotalStaffNums(getTotalStaffNums(dept));
			departmentDAO.update(dept);
			getParentTotalActualNumsAndTotalStaffNums(dept);
			originalParentDept = departmentDAO.getById(originalParentDept.getId());
			originalParentDept.setTotalActualNums(getTotalActualNums(originalParentDept));
			originalParentDept.setTotalStaffNums(getTotalStaffNums(originalParentDept));
			departmentDAO.update(originalParentDept);
			getParentTotalActualNumsAndTotalStaffNums(originalParentDept);
		}
		return true;
	}

	public boolean updateDept(Department dept, Department originalParentDept, Department newParentDept)
			throws UpdateException, DAOException, DeleteException, NumberFormatException, DataNotFoundException,
			CreateException {
		dept.setParentDepartment(newParentDept);
		departmentDAO.update(dept);
		if (originalParentDept != null) {
			for (ParentDepartment parentDepartment : parentDepartmentDAO
					.findParentDepartmentByDept(originalParentDept)) {
				parentDepartmentDAO.delete(parentDepartment);
			}
			for (Department parentDept : getParentDepts(originalParentDept)) {
				ParentDepartment parentDepartment = new ParentDepartment();
				parentDepartment.setDepartment(originalParentDept);
				parentDepartment.setParentDepartment(parentDept);
				parentDepartmentDAO.add(parentDepartment);
			}
			for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(originalParentDept)) {
				sonDepartmentDAO.delete(sonDepartment);
			}
			for (Department sonDept : getSonDepts(originalParentDept)) {
				SonDepartment sonDepartment = new SonDepartment();
				sonDepartment.setDepartment(originalParentDept);
				sonDepartment.setSonDepartment(sonDept);
				sonDepartmentDAO.add(sonDepartment);
			}
		}
		if (newParentDept != null) {
			for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(newParentDept)) {
				parentDepartmentDAO.delete(parentDepartment);
			}
			// List<ParentDepartment> parentDepartments = new ArrayList<ParentDepartment>();
			for (Department parentDept : getParentDepts(newParentDept)) {
				ParentDepartment parentDepartment = new ParentDepartment();
				parentDepartment.setDepartment(newParentDept);
				parentDepartment.setParentDepartment(parentDept);
				parentDepartmentDAO.add(parentDepartment);
			}
			for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(newParentDept)) {
				sonDepartmentDAO.delete(sonDepartment);
			}
			for (Department sonDept : getSonDepts(newParentDept)) {
				SonDepartment sonDepartment = new SonDepartment();
				sonDepartment.setDepartment(newParentDept);
				sonDepartment.setSonDepartment(sonDept);
				sonDepartmentDAO.add(sonDepartment);
			}
		}
		for (ParentDepartment parentDepartment : parentDepartmentDAO.findParentDepartmentByDept(dept)) {
			parentDepartmentDAO.delete(parentDepartment);
		}
		for (Department parentDept : getParentDepts(dept)) {
			ParentDepartment parentDepartment = new ParentDepartment();
			parentDepartment.setDepartment(dept);
			parentDepartment.setParentDepartment(parentDept);
			parentDepartmentDAO.add(parentDepartment);
		}
		for (SonDepartment sonDepartment : sonDepartmentDAO.findSonDepartmentByDept(dept)) {
			sonDepartmentDAO.delete(sonDepartment);
		}
		for (Department sonDept : getSonDepts(dept)) {
			SonDepartment sonDepartment = new SonDepartment();
			sonDepartment.setDepartment(dept);
			sonDepartment.setSonDepartment(sonDept);
			sonDepartmentDAO.add(sonDepartment);
		}
		dept.setTotalActualNums(getTotalActualNums(dept));
		dept.setStaffNums(countStaffNums(dept));
		dept.setTotalStaffNums(getTotalStaffNums(dept));
		departmentDAO.update(dept);
		getParentTotalActualNumsAndTotalStaffNums(dept);
		if (originalParentDept != null && originalParentDept.getId() != newParentDept.getId()) {
			originalParentDept = departmentDAO.getById(originalParentDept.getId());
			originalParentDept.setTotalActualNums(getTotalActualNums(originalParentDept));
			originalParentDept.setTotalStaffNums(getTotalStaffNums(originalParentDept));
			departmentDAO.update(originalParentDept);
			getParentTotalActualNumsAndTotalStaffNums(originalParentDept);
		}
		return true;
	}

	public Department getDept(int deptId) throws DAOException, DataNotFoundException {
		return departmentDAO.getDepartmentById(deptId);
	}

	/**
	 * 获取部门的员工列表
	 * 
	 * @param dept
	 *            员工所在部门
	 * @param tag
	 *            是否获取下级部门员工
	 * @return 部门的员工列表
	 */
	public List<Employee> getEmpByDept(Department dept, boolean tag) throws DAOException {
		if (tag) {
			List<Employee> emps = employeeDAO.getEmpByDeptAndState(dept, 0);
			String sonDeptIds = getSonDeptIds(dept);
			if (sonDeptIds == "") {
				return emps;
			} else {
				String sonDepts[] = sonDeptIds.split(",");
				for (int i = 0; i < sonDepts.length; i++) {
					Department department = departmentDAO.getDepartmentById(Integer.parseInt(sonDepts[i]));
					for (Employee emp : employeeDAO.getEmpByDeptAndState(department, 0)) {
						emps.add(emp);
					}
				}
				return emps;
			}
		} else {
			return employeeDAO.getEmpByDeptAndState(dept, 0);
		}
	}

	public List<Employee> getEmpByDept(Department dept) throws DAOException {
		List<Employee> emps = employeeDAO.findEmpByDept(dept);
		String sonDeptIds = getSonDeptIds(dept);
		if (sonDeptIds == "") {
			return emps;
		} else {
			String sonDepts[] = sonDeptIds.split(",");
			for (int i = 0; i < sonDepts.length; i++) {
				Department department = departmentDAO.getDepartmentById(Integer.parseInt(sonDepts[i]));
				for (Employee emp : employeeDAO.findEmpByDept(department)) {
					emps.add(emp);
				}
			}
			return emps;
		}
	}

	public List<Employee> getEmpByDept(List<Department> depts) throws DAOException {
		List<Employee> emps = new ArrayList<Employee>();
		for (Department dept : depts) {
			emps.addAll(getEmpByDept(dept));
		}
		return emps;
	}

	/**
	 * 添加员工
	 * 
	 * @param emp
	 *            添加的员工
	 * @return 添加的结果
	 */
	public boolean addEmp(Employee emp) throws CreateException, DAOException, UpdateException, DataNotFoundException {
		// long start=System.currentTimeMillis(); //获取开始时间
		employeeDAO.add(emp);
		Department dept = departmentDAO.getById(emp.getDepartment().getId());
		// emp.setDept(dept);
		dept.setActualNums(dept.getActualNums() + 1);
		// departmentDAO.update(dept);
		// dept.setTotalActualNums(facTotalActualNums(dept));
		dept.setTotalActualNums(getTotalActualNums(dept));
		departmentDAO.update(dept);
		// facParentTANums(dept);
		getParentTotalActualNums(dept);
		// long end=System.currentTimeMillis(); //获取结束时间
		// System.out.println("程序运行时间： "+(end-start)+"ms");
		return true;
	}

	/**
	 * 修改员工部门
	 * 
	 * @param emp
	 *            员工
	 * @param newDeptId
	 *            修改后的部门ID
	 * @return 修改的结果
	 */
	public boolean updateEmp(Employee emp, Department oldDept, Department newDept, int oldState, int newState)
			throws DAOException, UpdateException, DataNotFoundException {

		// Department oldDept = departmentDAO.getDepartmentByEmpId(emp.getId());
		// int actual = oldDept.getActualNums() - 1;

		if (oldDept.getId() != newDept.getId() && oldState == newState && oldState == 0) {// 在职改部门
			// long start=System.currentTimeMillis(); //获取开始时间
			// Department newDept = departmentDAO.getById(newDeptId);
			emp.setDepartment(newDept);
			employeeDAO.update(emp);
			// Department oldDept = departmentDAO.getById(oldDeptId);
			oldDept.setActualNums(oldDept.getActualNums() - 1);
			departmentDAO.update(oldDept);
			// int actuals = newDept.getActualNums() + 1;
			newDept.setActualNums(newDept.getActualNums() + 1);
			departmentDAO.update(newDept);
			// oldDept.setTotalActualNums(facTotalActualNums(oldDept));
			oldDept.setTotalActualNums(getTotalActualNums(oldDept));
			departmentDAO.update(oldDept);
			// facParentTANums(oldDept);
			getParentTotalActualNums(oldDept);
			// newDept.setTotalActualNums(facTotalActualNums(newDept));
			newDept.setTotalActualNums(getTotalActualNums(newDept));
			departmentDAO.update(newDept);
			// facParentTANums(newDept);
			getParentTotalActualNums(newDept);
			// long end=System.currentTimeMillis(); //获取结束时间
			// System.out.println("程序运行时间： "+(end-start)+"ms");
		} else if (oldDept.getId() != newDept.getId() && oldState != newState && oldState == 0) {// 在职改离职又改部门不成立

			return false;
		} else if (oldDept.getId() == newDept.getId() && oldState != newState && oldState == 0) {// 在职改离职
			emp.setState(1);
			employeeDAO.update(emp);
			// int originalDeptId = emp.getDept().getId();
			// Department originalDept = departmentDAO.getById(originalDeptId);
			oldDept.setActualNums(oldDept.getActualNums() - 1);
			oldDept.setTotalActualNums(oldDept.getTotalActualNums() - 1);
			departmentDAO.update(oldDept);
			// facParentTANums(oldDept);
			getParentTotalActualNums(oldDept);
		} else if (oldDept.getId() == newDept.getId() && oldState != newState && oldState == 1) {// 离职改在职部门不变
			emp.setState(0);
			employeeDAO.update(emp);
			// int originalDeptId = emp.getDept().getId();
			// Department originalDept = departmentDAO.getById(originalDeptId);
			oldDept.setActualNums(oldDept.getActualNums() + 1);
			oldDept.setTotalActualNums(oldDept.getTotalActualNums() + 1);
			departmentDAO.update(oldDept);
			// facParentTANums(oldDept);
			getParentTotalActualNums(oldDept);
		} else if (oldDept.getId() != newDept.getId() && oldState != newState && oldState == 1) {// 离职改在职且修改部门
			emp.setState(0);
			employeeDAO.update(emp);
			// Department newDept = departmentDAO.getById(newDeptId);
			int actuals = newDept.getActualNums() + 1;
			newDept.setActualNums(newDept.getActualNums() + 1);
			newDept.setTotalActualNums(newDept.getTotalActualNums() + 1);
			departmentDAO.update(newDept);
			// facParentTANums(newDept);
			getParentTotalActualNums(newDept);
		} else if (oldDept.getId() == newDept.getId() && oldState == newState) {
			employeeDAO.update(emp);
		} else if (oldDept.getId() != newDept.getId() && oldState == newState && oldState == 1) {
			return false;
		}
		return true;
	}

	/**
	 * 员工离职
	 * 
	 * @param emp
	 *            员工
	 * @return 结果
	 */
	public boolean empLeave(Employee emp) throws DeleteException, DAOException, UpdateException, DataNotFoundException {

		int originalDeptId = emp.getDepartment().getId();
		Department originalDept = departmentDAO.getById(originalDeptId);
		originalDept.setUpdateDate(emp.getUpdateDate());
		originalDept.setUpdateUser(emp.getUpdateUser());
		originalDept.setActualNums(originalDept.getActualNums() - 1);
		originalDept.setTotalActualNums(facTotalActualNums(originalDept));
		departmentDAO.update(originalDept);
		facParentTANums(originalDept);
		emp.setState(1);
		employeeDAO.update(emp);
		return true;
	}

	/**
	 * 获取员工经历
	 * 
	 * @param emp
	 *            员工
	 * @return 员工的经历
	 */
	public List<EmpExperience> getEmpExperienceByEmp(Employee emp) throws DAOException {
		return empExperienceDAO.findEmpExperienceByEmp(emp);
	}

	public List<CustomerContract> getCanSeeCustomerContractByEmp(int firstResult, int maxResults, Employee emp,
			String condition) throws DAOException {
		List<Department> depts = departmentDAO.getAllDepartment();
		for (Department dept : depts) {
			if (dept.getDeparmentSupervisor() != null) {
				if (emp.getId() == dept.getDeparmentSupervisor().getId()) {
					List<Employee> emps = getEmpByDept(depts);
					return customerContractDAO.findPagingCustomerContractByEmp(emps, condition, firstResult,
							maxResults);
				}
			}

		}
		return customerContractDAO.findPagingCustomerContractByEmp(emp, condition, firstResult, maxResults);

	}

	public int getCanSeeCustomerContractCountByEmp(Employee emp, String condition) throws DAOException {
		List<Department> depts = departmentDAO.getAllDepartment();
		for (Department dept : depts) {
			if (dept.getDeparmentSupervisor() != null) {
				if (emp.getId() == dept.getDeparmentSupervisor().getId()) {
					List<Employee> emps = getEmpByDept(depts);
					return customerContractDAO.findCustomerContractCountByEmp(emps, condition);
				}
			}

		}
		return customerContractDAO.findCustomerContractCountByEmp(emp, condition);
	}

	public void addParentDepartment()
			throws DAOException, CreateException, NumberFormatException, DataNotFoundException {
		for (Department dept : departmentDAO.getAllDepartment()) {
			if (dept.getParentDepartment() != null) {
				for (Department parentDept : getParentDepts(dept)) {
					ParentDepartment parentDepartment = new ParentDepartment();
					parentDepartment.setDepartment(dept);
					parentDepartment.setParentDepartment(parentDept);
					parentDepartmentDAO.add(parentDepartment);
				}
			}
		}
	}

	public void addSonDepartment() throws DAOException, NumberFormatException, DataNotFoundException, CreateException {
		for (Department dept : departmentDAO.getAllDepartment()) {
			if (!departmentDAO.getDepartmentByParentDept(dept).isEmpty()) {
				for (Department sonDept : getSonDepts(dept)) {
					SonDepartment sonDepartment = new SonDepartment();
					sonDepartment.setDepartment(dept);
					sonDepartment.setSonDepartment(sonDept);
					sonDepartmentDAO.add(sonDepartment);
				}
			}
		}
	}

	public static void main(String args[])
			throws NumberFormatException, DAOException, DataNotFoundException, CreateException, IOException {
		File writename = new File("/home/henry/Desktop/sql.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
		writename.createNewFile(); // 创建新文件
		BufferedWriter out = new BufferedWriter(new FileWriter(writename));
		int amount = 0;

		// ResultSet resultSet = pstmt.executeQuery();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
		DepartmentDAO departmentDAO = (DepartmentDAO) context.getBean(DepartmentDAO.class);
		DepartmentService departmentService = (DepartmentService) context.getBean(DepartmentService.class);
		for (Department dept : departmentDAO.getAllDepartment()) {
			if (dept.getParentDepartment() != null) {
				for (Department parentDept : departmentService.getParentDepts(dept)) {
					// ParentDepartment parentDepartment = new ParentDepartment();
					// parentDepartment.setDept(dept);
					// parentDepartment.setParentDept(parentDept);
					// parentDepartmentDAO1.add(parentDepartment);
					String sql = "insert into hr_parent_department(dept_id,parent_dept_id)" + " values(" + dept.getId()
							+ "," + parentDept.getId() + ");";
					System.out.println(sql);
					out.write(sql + "\r\n");
					amount += 1;
				}
			}
		}
		for (Department dept : departmentDAO.getAllDepartment()) {
			if (!departmentDAO.getDepartmentByParentDept(dept).isEmpty()) {
				for (Department sonDept : departmentService.getSonDepts(dept)) {
					// SonDepartment sonDepartment = new SonDepartment();
					// sonDepartment.setDept(dept);
					// sonDepartment.setSonDept(sonDept);
					// sonDepartmentDAO1.add(sonDepartment);
					String sql = "insert into hr_son_department(dept_id,son_dept_id)" + " values(" + dept.getId() + ","
							+ sonDept.getId() + ");";
					System.out.println(sql);
					out.write(sql + "\r\n");
					amount += 1;
				}
			}
		}
		// resultSet.close();
		// jdbcUtils.closeConnection();
		out.flush(); // 把缓存区内容压入文件
		out.close(); // 最后记得关闭文件
		System.out.println("Process Over!");
		System.out.println(amount);
	}

	/**
	 * 当员工离职时，所在部门人数的变化及所在部门的父级部门人数的相应变化
	 * 
	 * @param employee
	 * @param state
	 *            state=0:部门减人数； state=1:部门加人数
	 * @return
	 * @throws DAOException
	 */
	public boolean changeDeptPersonNumber(Department dept, int state) throws DAOException {
		try {
			java.sql.Timestamp updateDate = new java.sql.Timestamp(System.currentTimeMillis());
			User user = UserSession.getUser();
			// 修改当前部门的实际人数跟总实际人数
			// Department dept = employee.getDept();
			if (state == 0) {
				dept.setActualNums(dept.getActualNums() - 1);
				dept.setTotalActualNums(dept.getTotalActualNums() - 1);
			}
			if (state == 1) {
				dept.setActualNums(dept.getActualNums() + 1);
				dept.setTotalActualNums(dept.getTotalActualNums() + 1);
			}
			dept.setUpdateDate(updateDate);
			dept.setUpdateUser(user.getLoginName());
			departmentDAO.update(dept);
			// 查找并修改当前部门的父级部门的实际人数跟总实际人数
			findParentDepartment(dept, state);

			return true;
		} catch (UpdateException e) {
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查找并修改当前部门的父级部门的实际人数跟总实际人数
	 * 
	 * @param dept
	 * @param state
	 * @throws DataNotFoundException
	 * @throws UpdateException
	 * @throws DAOException
	 */
	private void findParentDepartment(Department dept, int state)
			throws DataNotFoundException, UpdateException, DAOException {
		// 得到所有的部门
		List<Department> deptList = departmentDAO.getAllDepartment();

		// 存储找到的父级部门
		List<Department> findedDeptList = new ArrayList<>();

		// 找到的父级部门并封装在findedDeptList中；
		if (dept.getParentDepartment() != null) {
			int parentId = dept.getParentDepartment().getId();
			Department parentDepartment = departmentDAO.getById(parentId);
			findedDeptList.add(parentDepartment);
			findParentDepartment(parentDepartment, state);
		}

		// 修改父级部门的实际人数跟总实际人数
		if (!findedDeptList.isEmpty()) {
			for (Department department : findedDeptList) {
				for (Department predept : deptList) {
					if (predept.getId() == department.getId()) {

						System.out.println(
								"原 实际人数" + predept.getActualNums() + "----" + "原 总实际人数" + predept.getTotalActualNums());

						if (state == 0) {
							predept.setActualNums(predept.getActualNums() - 1);
							predept.setTotalActualNums(predept.getTotalActualNums() - 1);
						}
						if (state == 1) {
							predept.setActualNums(predept.getActualNums() + 1);
							predept.setTotalActualNums(predept.getTotalActualNums() + 1);
						}
						predept.setUpdateDate(dept.getUpdateDate());
						predept.setUpdateUser(dept.getUpdateUser());
						departmentDAO.update(predept);

						System.out.println(
								"现 实际人数" + predept.getActualNums() + "----" + "现 总实际人数" + predept.getTotalActualNums());

						break;
					}
				}
			}
		}

	}

	/**
	 * @category 校验部门实际人数以及编制人数
	 * @throws DAOException
	 * @throws UpdateException
	 * @throws DataNotFoundException
	 */
	public void updateNumberDepartments() throws DAOException, UpdateException, DataNotFoundException {
		List<Department> deptList = departmentDAO.getAllDepartment();
		List<DepartmentDTO> deptDTOList = new ArrayList<DepartmentDTO>();
		deptDTOList = departmentDAO.getNubmerOfDepartments();
		sortIndex(deptDTOList, 0, 1);
		int maxIndex = getMaxIndex(deptDTOList);
		for (int index = maxIndex; index > 0; index--) {
			for (int i = 0; i < deptDTOList.size(); i++) {
				if (deptDTOList.get(i).getIndex() == index) {
					countDeparmtentEmp(deptDTOList, deptDTOList.get(i).getParentDeptDTO(),
							deptDTOList.get(i).getActualNums());
					countDeparmtentStaff(deptDTOList, deptDTOList.get(i).getParentDeptDTO(),
							deptDTOList.get(i).getStaffNums());
				}
			}
		}
		List<Department> tempList = new ArrayList<Department>();
		for (DepartmentDTO deptDTO : deptDTOList) {
			Department dept = getDeptById(deptDTO.getId(), deptList);
			if (dept.getActualNums() == deptDTO.getActualNums()
					&& dept.getTotalActualNums() == deptDTO.getTotalActualNums()
					&& dept.getStaffNums() == deptDTO.getStaffNums()
					&& dept.getTotalStaffNums() == deptDTO.getTotalStaffNums()) {
				continue;
			} else {
				tempList.add(dept);
			}
		}
		for (Department dept : tempList) {
			DepartmentDTO deptDTO = getDeptDTOById(dept.getId(), deptDTOList);
			dept.setActualNums(deptDTO.getActualNums());
			dept.setTotalActualNums(deptDTO.getTotalActualNums());
			dept.setStaffNums(deptDTO.getStaffNums());
			dept.setTotalStaffNums(deptDTO.getTotalStaffNums());
			departmentDAO.update(dept);
		}
	}

	private DepartmentDTO getDeptDTOById(int id, List<DepartmentDTO> list) {
		for (DepartmentDTO dept : list) {
			if (dept.getId() == id) {
				return dept;
			}
		}
		return null;
	}

	private Department getDeptById(int id, List<Department> list) {
		for (Department dept : list) {
			if (dept.getId() == id) {
				return dept;
			}
		}
		return null;
	}

	private void countDeparmtentStaff(List<DepartmentDTO> list, Integer parentId, int count) {
		if (parentId == null)
			return;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == parentId.intValue()) {
				int totalStaffNums = list.get(i).getTotalStaffNums();
				list.get(i).setTotalStaffNums(totalStaffNums + count);
				countDeparmtentStaff(list, list.get(i).getParentDeptDTO(), count);
				break;
			}
		}
	}

	private void countDeparmtentEmp(List<DepartmentDTO> list, Integer parentId, int count) {
		if (parentId == null)
			return;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == parentId.intValue()) {
				int totalActualNums = list.get(i).getTotalActualNums();
				list.get(i).setTotalActualNums(totalActualNums + count);
				countDeparmtentEmp(list, list.get(i).getParentDeptDTO(), count);
				break;
			}
		}
	}

	private int getMaxIndex(List<DepartmentDTO> list) {
		int index = 0;
		for (DepartmentDTO departmentDTO : list) {
			if (departmentDTO.getIndex() > index)
				index = departmentDTO.getIndex();
		}
		return index;
	}

	private void sortIndex(List<DepartmentDTO> list, Integer parentId, int index) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getParentDeptDTO() == parentId.intValue()) {
				list.get(i).setIndex(index);
				sortIndex(list, list.get(i).getId(), index + 1);
			}
		}
	}

	/**
	 * @category 获取部门通过门店
	 * @param store
	 * @return
	 * @throws DAOException
	 */
	public List<Department> getDepartmentByStore(Store store) throws DAOException {
		return departmentDAO.getDepartmentByStore(store);
	}

	public List<DepartmentDTO> getDepartmentDTOAll() throws DAOException {
		return departmentDAO.getDepartmentDTOAll();
	}

	public List<DepartmentDTO> getDepartmentDTOByStore(Store store) throws DAOException {
		return departmentDAO.getDepartmentDTOByStore(store);
	}

	@Override
	public void setDAO() {
		this.baseDAO = departmentDAO;
	}

}
