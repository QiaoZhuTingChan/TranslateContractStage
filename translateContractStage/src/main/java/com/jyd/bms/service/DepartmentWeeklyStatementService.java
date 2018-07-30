package com.jyd.bms.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.DepartmentWeeklyStatement;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.DepartmentDAO;
import com.jyd.bms.dao.DepartmentWeeklyStatementDAO;
import com.jyd.bms.dao.EmpExperienceDAO;
import com.jyd.bms.dao.StoreDAO;
import com.jyd.bms.tool.exception.CreateException;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DataNotFoundException;
import com.jyd.bms.tool.exception.UpdateException;


@Service("DepartmentWeeklyStatementService")
public class DepartmentWeeklyStatementService extends BaseService<DepartmentWeeklyStatement> {
	@Autowired(required = true)
	private DepartmentWeeklyStatementDAO departmentWeeklyStatementDAO;
	@Autowired(required = true)
	private EmpExperienceDAO empExperienceDAO;
	@Autowired(required = true)
	private DepartmentDAO departmentDAO;
	@Autowired(required = true)
	private StoreDAO storeDAO;

	public boolean addDepartmentWeeklyStatement(Department dept) throws DAOException, CreateException, UpdateException, DataNotFoundException {
		Calendar cal = Calendar.getInstance();
		DepartmentWeeklyStatement departmentWeeklyStatement = new DepartmentWeeklyStatement();	
		departmentWeeklyStatement.setDepartment(dept);
		departmentWeeklyStatement.setStore(storeDAO.getById(dept.getStore().getId()));
		departmentWeeklyStatement.setYear(cal.get(Calendar.YEAR));
		departmentWeeklyStatement.setWeekNumber(cal.get(Calendar.WEEK_OF_YEAR));
		cal.add(cal.DATE, -1);
		departmentWeeklyStatement.setEndDate(cal.getTime());
		cal.add(cal.DATE, -6);
		departmentWeeklyStatement.setBeginDate(cal.getTime());
		departmentWeeklyStatement.setTotalEmployee(dept.getActualNums());
		departmentWeeklyStatement.setTotalStaff(dept.getStaffNums());
		int count5 = empExperienceDAO.findEmpExperienceCountByTypeAndWeek(5);
		int count8 = empExperienceDAO.findEmpExperienceCountByTypeAndWeek(8);
		departmentWeeklyStatement.setTotalJoin(count5+count8);
		int count6 = empExperienceDAO.findEmpExperienceCountByTypeAndWeek(6);
		departmentWeeklyStatement.setTotalLeave(count6);
		int count1 = empExperienceDAO.findEmpExperienceCountByTypeAndWeek(1);
		departmentWeeklyStatement.setTotalPromotion(count1);
		int count2entry = empExperienceDAO.findEmpExperienceCountByEntryDeptAndWeek(dept);
		departmentWeeklyStatement.setTuningIn(count2entry);
		int count2out = empExperienceDAO.findEmpExperienceCountByOutDeptAndWeek(dept);
		departmentWeeklyStatement.setTotalLeave(count2out);
		int count3 = empExperienceDAO.findEmpExperienceCountByTypeAndWeek(3);
		departmentWeeklyStatement.setRaiseASalary(count3);
		departmentWeeklyStatementDAO.add(departmentWeeklyStatement);
		return true;
	}
	
	public void autoAddDepartmentWeeklyStatement() throws DAOException, CreateException, UpdateException, DataNotFoundException {
		List<Department> depts = departmentDAO.getAllDepartment();
		
		for(Department dept : depts) {
			//Department dept0 = departmentDAO.getById(dept.getId());
			//DepartmentWeeklyStatement departmentWeeklyStatement = new DepartmentWeeklyStatement();
			//departmentDAO.update(dept);			
			addDepartmentWeeklyStatement(dept);
		}
	}
	
	/**
	 * 获取门店部门周结
	 * @param store 门店
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @return 部门周结列表
	 */
	public List<DepartmentWeeklyStatement> getDepartmentWeeklyStatementByDate(Store store,Date time) throws DAOException{
		return departmentWeeklyStatementDAO.findDepartmentWeeklyStatementByDate(store, time);
	}
	
	/**
	 * 获取指定部门周结
	 * @param dept 部门
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @return 部门周结列表
	 */
	public List<DepartmentWeeklyStatement> getDepartmentWeeklyStatementByDeptAndDate(Department dept,Date begin,Date end) throws DAOException{
		return departmentWeeklyStatementDAO.findDepartmentWeeklyStatementByDeptAndDate(dept, begin, end);
	}
	
	
	
	@Override
	public void setDAO() {
		// TODO Auto-generated method stub
		
	}

}
