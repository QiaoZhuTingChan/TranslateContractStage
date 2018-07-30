package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.RepaymentStage;
import com.jyd.bms.dao.RepaymentStageDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class RepaymentStageDAOImpl extends HibernateBaseTemplate<RepaymentStage> implements RepaymentStageDAO {

	public int getRepaymentStageCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from RepaymentStage";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {

			hql = "select count(*) from RepaymentStage where repaymentStage like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();

		}
	}

	public List<RepaymentStage> getPagingRepaymentStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from RepaymentStage";
		} else {
			hql = "from RepaymentStage where repaymentStage like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<RepaymentStage> getAllRepaymentStage() throws DAOException {
		String hql = "";
		hql = "from RepaymentStage";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public RepaymentStage getRepaymentStageByRepaymentStage(int repaymentStage) throws DAOException {
		StringBuilder hql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();

		hql.append(" from RepaymentStage where repaymentStage = :repaymentStage");
		map.put("repaymentStage", repaymentStage);

		List<RepaymentStage> list = super.getQueryResult(hql.toString(), map);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public RepaymentStage getRepaymentStageById(int stage) throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("stage", stage);
		hql="from RepaymentStage where repaymentStage=:stage";
		List<RepaymentStage> lisre=super.getQueryResult(hql,map);
		
		return lisre.isEmpty()?null:lisre.get(0);
	}

}
