package com.jyd.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyd.bms.bean.CusBorrowerCreditInformationTable;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.User;
import com.jyd.bms.dao.CusBorrowerCreditInformationTableDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-23 15:42:22 by GeneratedTool
 * @author mjy
 */
@Service("CusBorrowerCreditInformationTableService")
public class CusBorrowerCreditInformationTableService extends BaseService<CusBorrowerCreditInformationTable> {
	@Autowired(required = true)
	private CusBorrowerCreditInformationTableDAO cusBorrowerCreditInformationTableDAO;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserService userService;

	public int getCusBorrowerCreditInformationTableCount(String condition) throws DAOException {
		return cusBorrowerCreditInformationTableDAO.getCusBorrowerCreditInformationTableCount(condition);
	}

	public List<CusBorrowerCreditInformationTable> getPagingCusBorrowerCreditInformationTable(int firstResult,
			int maxResults, String condition) throws DAOException {
		return cusBorrowerCreditInformationTableDAO.getPagingCusBorrowerCreditInformationTable(firstResult, maxResults,
				condition);
	}

	public List<CusBorrowerCreditInformationTable> getAllCusBorrowerCreditInformationTable() throws DAOException {
		return cusBorrowerCreditInformationTableDAO.getAllCusBorrowerCreditInformationTable();
	}

	@Override
	public void setDAO() {
		this.baseDAO = cusBorrowerCreditInformationTableDAO;
	}

	public List<CusBorrowerCreditInformationTable> getPagingSuperiorSeeAllSubordinates(int firstResult, int maxResults,
			String condition, User user) throws Exception {

		List<Employee> employeeList = employeeService.getSuperiorSeeAllSubordinates(user);

		List<User> userList = null;
		if (employeeList != null && employeeList.size()>0) {
			userList = userService.getUsersByEmployeeList(employeeList);
		}

		if (userList != null && employeeList.size()>0) {
			return cusBorrowerCreditInformationTableDAO.getPagingSuperiorSeeAllSubordinates(firstResult, maxResults,
					condition, userList);
		}
		return null;
	}

	public int getSuperiorSeeAllSubordinatesCount(String condition, User user) throws Exception {
		List<Employee> employeeList =  employeeService.getSuperiorSeeAllSubordinates(user);
		
		List<User> userList = null;
		if(employeeList != null) {
			userList = userService.getUsersByEmployeeList(employeeList);
		}
		
		if(userList != null) {
			return cusBorrowerCreditInformationTableDAO.getSuperiorSeeAllSubordinatesCount(condition, userList);
		}
		return 0;
	}

}
