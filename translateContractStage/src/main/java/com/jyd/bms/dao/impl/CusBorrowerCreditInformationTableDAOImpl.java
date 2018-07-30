package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusBorrowerCreditInformationTable;
import com.jyd.bms.bean.Employee;
import com.jyd.bms.bean.User;
import com.jyd.bms.dao.CusBorrowerCreditInformationTableDAO;

/**
 * @category Generated 2018-05-23 15:42:22 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusBorrowerCreditInformationTableDAOImpl extends HibernateBaseTemplate<CusBorrowerCreditInformationTable>
		implements CusBorrowerCreditInformationTableDAO {

	@SuppressWarnings("unchecked")
	public int getCusBorrowerCreditInformationTableCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusBorrowerCreditInformationTable";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusBorrowerCreditInformationTable where user.userName like :condition";
			Map<String, Object> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CusBorrowerCreditInformationTable> getPagingCusBorrowerCreditInformationTable(int firstResult,
			int maxResults, String condition) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from CusBorrowerCreditInformationTable";
		} else {
			hql = "from CusBorrowerCreditInformationTable where user.userName like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<CusBorrowerCreditInformationTable> getAllCusBorrowerCreditInformationTable() throws DAOException {
		String hql = "";
		hql = "from CusBorrowerCreditInformationTable";
		return super.getQueryResult(hql.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusBorrowerCreditInformationTable> getPagingSuperiorSeeAllSubordinates(int firstResult,
			int maxResults, String condition, List<User> userList )
			throws DAOException {

		StringBuilder hql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();
		
		hql.append(" from CusBorrowerCreditInformationTable where user in(:userList)");
		if(!condition.equals("")) {
			hql.append(" and (user.userName like :condition or name like :condition)");
			map.put("condition", "%" + condition + "%");
		}
		map.put("userList", userList);
		
		List<CusBorrowerCreditInformationTable> list = super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
		
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getSuperiorSeeAllSubordinatesCount(String condition, List<User> userList )
					throws DAOException {
		
		StringBuilder hql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();
		
		hql.append(" select count(*) from CusBorrowerCreditInformationTable where user in(:userList)");
		if(!condition.equals("")) {
			hql.append(" and (user.userName like :condition or name like :condition)");
			map.put("condition", "%" + condition + "%");
		}
		map.put("userList", userList);
		
		List<Long> lstCount = super.getQueryResult(hql.toString(), map);
		
		return lstCount.get(0).intValue();
	}
}
