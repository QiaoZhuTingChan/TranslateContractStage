package com.jyd.bms.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractFaceTrial;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.ContractFaceTrialDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContactFaceTrialDAOImpl extends HibernateBaseTemplate<ContractFaceTrial> implements ContractFaceTrialDAO {

	public int getContractFaceTrialCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractFaceTrial";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractFaceTrial where ContractFaceTrial.customerInfo.idNum = :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractFaceTrial> getPagingContractFaceTrial(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractFaceTrial";
		} else {
			hql = "from ContractFaceTrial where Contact.employee.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractFaceTrial> getAllContractFaceTrial() throws DAOException {
		String hql = "";
		hql = "from ContractFaceTrial";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public ContractFaceTrial getContractFaceTrialByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractFaceTrial where customerContract = :contract order by id desc";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<ContractFaceTrial> list = new ArrayList<ContractFaceTrial>();
		list = super.getQueryResult(hql, map);
		if (list.isEmpty()) {
			return null;
		} else {
			return (ContractFaceTrial) list.get(0);
		}
	}

}
