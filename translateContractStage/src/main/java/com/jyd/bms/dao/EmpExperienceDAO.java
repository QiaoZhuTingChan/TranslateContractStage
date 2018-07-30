package com.jyd.bms.dao;

import java.text.ParseException;
import java.util.List;

import com.jyd.bms.bean.Department;
import com.jyd.bms.bean.EmpExperience;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.tool.exception.DAOException;

public interface EmpExperienceDAO extends HibernateBase<EmpExperience> {
	/**
	 * 员工的个人经历
	 * 
	 * @param emp
	 * @return
	 * @throws DAOException
	 */
	public List<EmpExperience> findEmpExperienceByEmp(Employee emp) throws DAOException;
	
	public int findEmpExperienceCountByTypeAndWeek(int type) throws DAOException;

	public int findEmpExperienceCountByEntryDeptAndWeek(Department dept) throws DAOException;
	
	public int findEmpExperienceCountByOutDeptAndWeek(Department dept) throws DAOException;
	
	public int findEmpExperienceCountByTypeAndMonth(int type) throws DAOException;
	
	public int findEmpExperienceCountByEntryDeptAndMonth(Department dept) throws DAOException;
	
	public int findEmpExperienceCountByOutDeptAndMonth(Department dept) throws DAOException;
	
	/**
	 * 原生sql查询
	 * @return
	 * @throws DAOException
	 */
	public List<Object[]> fingEmpExperienceAllId() throws DAOException;
	/**
	 * 原生sqlupdate
	 * @return
	 * @throws DAOException
	 */
	public int updateEmpExperiencBySQL(List<EmpExperience> empExperienceList, String type) throws DAOException;

	public List<EmpExperience> getEmpExperienceByTypeAndEffectiveDate(String yearMonth) throws ParseException, DAOException;
	
}
