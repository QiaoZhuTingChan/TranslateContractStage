package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractPara;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.ProductParameter;
import com.jyd.bms.dao.ContractParaDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class ContractParaDAOImpl extends HibernateBaseTemplate<ContractPara> implements ContractParaDAO {

	public int getContractParaCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from ContractPara";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from ContractPara where contract.name like :condition";
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<ContractPara> getPagingContractPara(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from ContractPara";
		} else {
			hql = "from ContractPara where contract.name like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<ContractPara> getAllContractPara() throws DAOException {
		String hql = "";
		hql = "from ContractPara";
		return super.getQueryResult(hql.toString());

	}

	public double findValueByContractAndPara(CustomerContract contract, ProductParameter para) throws DAOException {
		String hql = "";
		hql = "select value from ContractPara where contract = :contract and para = :para";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		map.put("para", para);
		return super.getUniqueResult(hql, map) == null ? 0.0 : (double) super.getUniqueResult(hql, map);
	}

	@Override
	public List<ContractPara> getContractParaByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from ContractPara where contract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

	@Override
	public void deleteAll(CustomerContract contract) throws DAOException {
		String hql = "delete from ContractPara where contract =:contract";
		Map<String, Object> map = new HashMap<>();
		map.put("contract", contract);
		super.executeUpdate(hql, map);
	}

	@Override
	public int excuteBatchInsertContractPara(Set<ContractPara> contractParaList) {
		// TODO Auto-generated method stub
		return 0;
	}

}
