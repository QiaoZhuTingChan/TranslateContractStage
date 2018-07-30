package com.jyd.bms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ContractRepaymentDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractRepaymentDAOImpl extends HibernateBaseTemplate<ContractRepayment> implements ContractRepaymentDAO {

	public int getContractRepaymentCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractRepayment";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractRepayment where stage.contract.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractRepayment> getPagingContractRepayment(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractRepayment";
		} else {
			hql = "from ContractRepayment where stage.contract.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractRepayment> getAllContractRepayment() throws DAOException {
		String hql = "";
		hql = "from ContractRepayment";
		return super.getQueryResult(hql.toString());

	}

	public List<ContractRepayment> findContractRepaymentByStage(ContractStage stage) throws DAOException {
		String hql = "";
		hql = "from ContractRepayment where stage = :stage";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("stage", stage);
		return super.getQueryResult(hql, map);
	}

	public ContractRepayment findContractRepaymentByStageAndLast(ContractStage stage) throws DAOException {
		String hql = "";
		hql = "from ContractRepayment where stage = :stage group by stage having repaymentDate = max(repaymentDate)";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("stage", stage);
		return (ContractRepayment) super.getUniqueResult(hql, map);
	}

	public List<ContractRepayment> findContractRepaymentByStoreAndDate(Store store, Date begin, Date end)
			throws DAOException {
		String hql = "";
		hql = "from ContractRepayment where stage.contract.store = :store and repaymentDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		map.put("begin", begin);
		map.put("end", end);
		return super.getQueryResult(hql, map);
	}

	public List<ContractRepayment> findContractRepaymentByDate(Date begin, Date end) throws DAOException {
		String hql = "";
		hql = "from ContractRepayment where repaymentDate between :begin and :end";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		// map.put("store", store);
		map.put("begin", begin);
		map.put("end", end);
		return super.getQueryResult(hql, map);
	}

	@Override
	public List<ContractRepayment> findContractRepaymentByStageAll(ContractStage stage) throws DAOException {
		String hql = "";
		hql = "from ContractRepayment where stage = :stage";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("stage", stage);
		return super.getQueryResult(hql, map);
	}

	@Override
	public void delAll(ContractStage stage) throws DAOException {
		String hql = "delete from ContractRepayment where stage =:stage";
		Map<String, Object> map = new HashMap<>();
		map.put("stage", stage);
		super.executeUpdate(hql, map);
	}

	@Override
	public int excuteBatchInsertContractRepayment(Set<ContractRepayment> contractRepaymentList) {
		// TODO Auto-generated method stub
		return 0;
	}

}
