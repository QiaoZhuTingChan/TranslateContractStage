package com.jyd.bms.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Store;
import com.jyd.bms.dao.ContractGpsLateFeeDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractGpsLateFeeDAOImpl extends HibernateBaseTemplate<ContractGpsLateFee>
		implements ContractGpsLateFeeDAO {

	public int getContractGpsLateFeeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractGpsLateFee";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractGpsLateFee where contract.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractGpsLateFee> getPagingContractGpsLateFee(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractGpsLateFee";
		} else {
			hql = "from ContractGpsLateFee where contract.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractGpsLateFee> getAllContractGpsLateFee() throws DAOException {
		String hql = "";
		hql = "from ContractGpsLateFee";
		return super.getQueryResult(hql.toString());

	}

	public List<ContractGpsLateFee> findContractGpsLateFeeByStore(Store store) throws DAOException {
		String hql = "";
		hql = "from ContractGpsLateFee where contract.store = :store";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("store", store);
		return super.getQueryResult(hql, map);
	}

	public int getSameContractGpsLateFeeCountByDay(CustomerContract contract) throws DAOException {
		Date date = Calendar.getInstance().getTime();
		String hql = "";
		hql = "select count(*) from ContractGpsLateFee where contract = :contract and createDate= :date";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("date", date);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	// 合同GPS费记录数
	public int getCountByCustomerContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "select count(*) from ContractGpsLateFee where contract = :contract and parkingFee is null";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<Long> lstCount = super.getQueryResult(hql, map);
		return lstCount.get(0).intValue();
	}

	public List<ContractGpsLateFee> findContractGpsLateFeeListByCustomerContract(CustomerContract contract)
			throws DAOException {
		String hql = "";
		hql = "from ContractGpsLateFee where contract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);

		return super.getQueryResult(hql, map);
	}

	public ContractGpsLateFee findContractGpsLateFeeByCustomerContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractGpsLateFee where contract = :contract order by id desc";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<ContractGpsLateFee> list = new ArrayList<ContractGpsLateFee>();
		list = super.getQueryResult(hql, map);
		if (list.isEmpty()) {
			return null;
		} else {
			return (ContractGpsLateFee) list.get(0);
		}
	}

	@Override
	public void deleteAll(CustomerContract contract) throws DAOException {
		String hql = "delete from ContractGpsLateFee where contract =:contract";
		Map<String, Object> map = new HashMap<>();
		map.put("contract", contract);
		super.executeUpdate(hql, map);
	}

	@Override
	public int excuteBatchInsertContractGpsLateFee(Set<ContractGpsLateFee> contractGpsLateFeeList) {
		// TODO Auto-generated method stub
		return 0;
	}
}
