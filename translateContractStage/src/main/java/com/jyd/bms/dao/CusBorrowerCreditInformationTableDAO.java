package com.jyd.bms.dao;

import java.util.List;
import com.jyd.bms.bean.CusBorrowerCreditInformationTable;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.User;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-05-23 15:42:22 by GeneratedTool
 * @author mjy
 */
public interface CusBorrowerCreditInformationTableDAO extends HibernateBase<CusBorrowerCreditInformationTable> {
	public int getCusBorrowerCreditInformationTableCount(String condition) throws DAOException;

	public List<CusBorrowerCreditInformationTable> getPagingCusBorrowerCreditInformationTable(int firstResult,
			int maxResults, String condition) throws DAOException;

	public List<CusBorrowerCreditInformationTable> getAllCusBorrowerCreditInformationTable() throws DAOException;

	public List<CusBorrowerCreditInformationTable> getPagingSuperiorSeeAllSubordinates(int firstResult,
			int maxResults, String condition, List<User> userList ) throws DAOException;

	public int getSuperiorSeeAllSubordinatesCount(String condition, List<User> userList)
			throws DAOException;
}