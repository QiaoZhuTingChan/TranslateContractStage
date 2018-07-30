package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusContractRepaymentStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.dao.CusContractRepaymentStageDAO;

/**
 * @category Generated 2018-07-03 10:33:55 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusContractRepaymentStageDAOImpl extends HibernateBaseTemplate<CusContractRepaymentStage>
		implements CusContractRepaymentStageDAO {

	public int getCusContractRepaymentStageCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusContractRepaymentStage";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusContractRepaymentStage where cusContractId like :condition";
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<CusContractRepaymentStage> getPagingCusContractRepaymentStage(int firstResult, int maxResults,
			String condition) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CusContractRepaymentStage";
		} else {
			hql = "from CusContractRepaymentStage where cusContractId like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<CusContractRepaymentStage> getAllCusContractRepaymentStage() throws DAOException {
		String hql = "";
		hql = "from CusContractRepaymentStage";
		return super.getQueryResult(hql.toString());
	}

	@Override
	public CusContractRepaymentStage getCusContractRepaymentStage(CustomerContract contract) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		map.put("contract", contract);
		hql = "from CusContractRepaymentStage where contract = :contract";
		return (CusContractRepaymentStage) super.getUniqueResult(hql, map);
	}
}
