package com.jyd.bms.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractGpsLateFee;
import com.jyd.bms.bean.CusCarAssess;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.CusCarAssessDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class CusCarAssessDAOImpl extends HibernateBaseTemplate<CusCarAssess> implements CusCarAssessDAO {

	public List<CusCarAssess> getAllCusCarAssess() throws DAOException {
		String hql = "";
		hql = "from CusCarAssess";
		return super.getQueryResult(hql.toString());

	}

	@Override
	public CusCarAssess getCusCarAssessByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from CusCarAssess where customerContract = :contract order by id desc";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		List<CusCarAssess> list = new ArrayList<CusCarAssess>();
		list = super.getQueryResult(hql, map);
		if (list.isEmpty()) {
			return null;
		} else {
			return (CusCarAssess) list.get(0);
		}
	}

}
