package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.WorkExperience;
import com.jyd.bms.dao.WorkExperienceDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class WorkExperienceDAOImpl extends HibernateBaseTemplate<WorkExperience> implements WorkExperienceDAO{

	@Override
	public int getWorkExperienceCount(String condition) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<WorkExperience> getPagingWorkExperience(int firstResult, int maxResults, String condition)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkExperience> getAllWorkExperience() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkExperience> getWorkExperiencesByEmp(Employee employee) throws DAOException {
		String hql = "";
		hql = "from WorkExperience where employee = :employee";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("employee", employee);
		return super.getQueryResult(hql, map);
		
	}

}
