package com.jyd.bms.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.DepartmentMonthlyStatement;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.DepartmentDAO;
import com.jyd.bms.dao.DepartmentMonthlyStatementDAO;
import com.jyd.bms.dao.EmpExperienceDAO;
import com.jyd.bms.dao.StoreDAO;
import com.jyd.bms.tool.exception.CreateException;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.tool.exception.DataNotFoundException;


@Service("DepartmentMonthlyStatementService")
public class DepartmentMonthlyStatementService extends BaseService<DepartmentMonthlyStatement> {
	@Autowired(required = true)
	private DepartmentMonthlyStatementDAO departmentMonthlyStatementDAO;
	@Autowired(required = true)
	private EmpExperienceDAO empExperienceDAO;
	@Autowired(required = true)
	private DepartmentDAO departmentDAO;
	@Autowired(required = true)
	private StoreDAO storeDAO;
	
	
	public String getYearMonth() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		if(month==0) {
			year = year-1;
			month = 12;
		}
		String yearMonth = String.valueOf(year)+"-"+String.valueOf(month);
		return yearMonth;
	}
	
	
	public boolean addDepartmentMonthlyStatement(Department dept) throws DAOException, CreateException, DataNotFoundException {
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, -1);
		DepartmentMonthlyStatement departmentMonthlyStatement = new DepartmentMonthlyStatement();
		departmentMonthlyStatement.setDepartment(dept);
		departmentMonthlyStatement.setStore(storeDAO.getById(dept.getStore().getId()));
		departmentMonthlyStatement.setYearMonth(getYearMonth());
		
		departmentMonthlyStatement.setTotalEmployee(dept.getActualNums());
		departmentMonthlyStatement.setTotalStaff(dept.getStaffNums());
		int count5 = empExperienceDAO.findEmpExperienceCountByTypeAndMonth(5);
		int count8 = empExperienceDAO.findEmpExperienceCountByTypeAndMonth(8);
		departmentMonthlyStatement.setTotalJoin(count5+count8);
		int count6 = empExperienceDAO.findEmpExperienceCountByTypeAndMonth(6);
		departmentMonthlyStatement.setTotalLeave(count6);
		int count1 = empExperienceDAO.findEmpExperienceCountByTypeAndMonth(1);
		departmentMonthlyStatement.setTotalPromotion(count1);
		int count2entry = empExperienceDAO.findEmpExperienceCountByEntryDeptAndMonth(dept);
		departmentMonthlyStatement.setTuningIn(count2entry);
		int count2out = empExperienceDAO.findEmpExperienceCountByOutDeptAndMonth(dept);
		departmentMonthlyStatement.setTuningOut(count2out);
		int count3 = empExperienceDAO.findEmpExperienceCountByTypeAndMonth(3);
		departmentMonthlyStatement.setRaiseASalary(count3);
		departmentMonthlyStatementDAO.add(departmentMonthlyStatement);
		return true;
	}
	
	public void autoAddDepartmentMonthlyStatement() throws DAOException, CreateException, DataNotFoundException {
		List<Department> depts = departmentDAO.getAllDepartment();
		for(Department dept : depts) {
			addDepartmentMonthlyStatement(dept);
		}
		
	}
	
	/**
	 * 获取门店部门月结
	 * @param store 门店
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @return 部门月结列表
	 */
	public List<DepartmentMonthlyStatement> getDepartmentMonthlyStatementByDate(Store store,String time) throws DAOException{
		return departmentMonthlyStatementDAO.findDepartmentMonthlyStatementByDate(store,time);
	}
	
	/**
	 * 获取指定部门月结
	 * @param dept 部门
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @return 部门月结列表
	 */
	public List<DepartmentMonthlyStatement> getDepartmentMonthlyStatementByDeptAndDate(Department dept,String begin,String end) throws DAOException{
		return departmentMonthlyStatementDAO.findDepartmentMonthlyStatementByDeptAndDate(dept, begin, end);
	}

	
	
	@Override
	public void setDAO() {
		// TODO Auto-generated method stub
		
	}

}
