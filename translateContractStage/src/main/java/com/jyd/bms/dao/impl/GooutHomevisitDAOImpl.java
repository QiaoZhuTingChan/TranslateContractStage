package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.GooutHomevisit;
import com.jyd.bms.dao.GooutHomevisitDAO;
import com.jyd.bms.tool.exception.DAOException;

@Repository
public class GooutHomevisitDAOImpl extends HibernateBaseTemplate<GooutHomevisit> implements GooutHomevisitDAO {

	@Override
	public void seva() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GooutHomevisit> getGooutHomevisitByContract(CustomerContract contract) throws DAOException {
		String hql = "";
		hql = "from GooutHomevisit where contract = :contract";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("contract", contract);
		return super.getQueryResult(hql, map);
	}

}
