package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.HrToLoan;
import com.jyd.bms.dao.HrToLoanDAO;

/**
 * @category Generated 2018-03-22 18:56:34 by GeneratedTool
 * @author mjy
 */
@Repository
public class HrToLoanDAOImpl extends HibernateBaseTemplate<HrToLoan> implements HrToLoanDAO {

	public int getHrToLoanCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from HrToLoan";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from HrToLoan where rawDepartment like :condition";
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<HrToLoan> getPagingHrToLoan(int firstResult, int maxResults, String condition) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from HrToLoan";
		} else {
			hql = "from HrToLoan where employee.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<HrToLoan> getAllHrToLoan() throws DAOException {
		String hql = "";
		hql = "from HrToLoan";
		return super.getQueryResult(hql.toString());
	}
}
