package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.InsuranceType;
import com.jyd.bms.dao.SalaryInsuranceTypeDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * 工资保险类型dao实现
 * 
 * @author zhi
 *
 */
@Repository
public class SalaryInsuranceTypeDAOImpl extends HibernateBaseTemplate<InsuranceType> implements SalaryInsuranceTypeDAO {

	@Override
	public int getSalaryInsuranceTypeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.trim().equals("")) {
			hql = "select count(*) from InsuranceType";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from InsuranceType where insuranceType like :condition";
			Map<String, String> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@Override
	public List<InsuranceType> getPagingSalaryInsuranceType(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map<String, String> map = new HashMap<>();
		if (condition.trim().equals("")) {
			hql = "from InsuranceType";
		} else {
			hql = "from InsuranceType where insuranceType like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@Override
	public List<InsuranceType> getAllSalaryInsuranceType() throws DAOException {
		String hql = "";
		hql = "from InsuranceType";
		return super.getQueryResult(hql.toString());
	}

}
