package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.WorkExperience;
import com.jyd.bms.dao.WorkExperienceDAO;
import com.jyd.bms.tool.exception.DAOException;

@Service("WorkExperienceService")
public class WorkExperienceService extends BaseService<WorkExperience>{

	@Autowired(required=true)
	private WorkExperienceDAO workExperienceDAO;
	
	@Override
	public void setDAO() {
		this.baseDAO = workExperienceDAO;
	}
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public int getWorkExperienceCount(String condition) throws DAOException{
		return workExperienceDAO.getWorkExperienceCount(condition);
	}

	/**
	 * 分页
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param condition
	 * @return
	 * @throws DAOException
	 */
	public List<WorkExperience> getPagingWorkExperience(int firstResult, int maxResults, String condition)
			throws DAOException{
		return workExperienceDAO.getPagingWorkExperience(firstResult, maxResults, condition);
	}

	/**
	 * 根据员工获取工作经历
	 * @param employee
	 * @return
	 * @throws DAOException 
	 */
	public List<WorkExperience> getWorkExperiencesByEmp(Employee employee) throws DAOException{
		return workExperienceDAO.getWorkExperiencesByEmp(employee);
	}
	
	
}
