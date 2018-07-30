package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractUploadfile;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.Form;
import com.jyd.bms.dao.ContractUploadfileDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractUploadfileDAOImpl extends HibernateBaseTemplate<ContractUploadfile>
		implements ContractUploadfileDAO {

	public int getContractUploadfileCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractUploadfile";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractUploadfile where contract.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractUploadfile> getPagingContractUploadfile(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractUploadfile";
		} else {
			hql = "from ContractUploadfile where contract.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractUploadfile> getAllContractUploadfile() throws DAOException {
		String hql = "";
		hql = "from ContractUploadfile";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public List<ContractUploadfile> getContractUploadFileByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractUploadfile where contract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

	@Override
	public void deleteAll(CustomerContract contract, Form form) throws DAOException {
		Map<String, Object> map = new HashMap<>();
		map.put("contract", contract);
		map.put("form", form);
		String hql = "delete from ContractUploadfile where uploadFileType.form = :form and contract=:contract";
		super.executeUpdate(hql, map);
	}

}
