package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.CusContractRepaymentOtherFee;
import com.jyd.bms.dao.CusContractRepaymentOtherFeeDAO;
import com.jyd.bms.tool.exception.DAOException;

/**
 * @category Generated 2018-06-27 10:54:48 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusContractRepaymentOtherFeeDAOImpl extends HibernateBaseTemplate<CusContractRepaymentOtherFee>
		implements CusContractRepaymentOtherFeeDAO {

	public int getCusContractRepaymentOtherFeeCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusContractRepaymentOtherFee";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusContractRepaymentOtherFee where cusContractStageId like :condition";
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<CusContractRepaymentOtherFee> getPagingCusContractRepaymentOtherFee(int firstResult, int maxResults,
			String condition) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from CusContractRepaymentOtherFee";
		} else {
			hql = "from CusContractRepaymentOtherFee where cusContractStageId like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<CusContractRepaymentOtherFee> getAllCusContractRepaymentOtherFee() throws DAOException {
		String hql = "";
		hql = "from CusContractRepaymentOtherFee";
		return super.getQueryResult(hql.toString());
	}

	@Override
	public List<CusContractRepaymentOtherFee> getOtherFeeByStage(ContractRepayment rep) throws DAOException {
		String hql = "";
		Map map = new HashMap();
		hql = "from CusContractRepaymentOtherFee where repayment = :rep";
		map.put("rep", rep);
		return super.getQueryResult(hql, map);
	}

	@Override
	public void delAll(ContractRepayment rep) throws DAOException {
		String hql = "delete from CusContractRepaymentOtherFee where repayment =:rep";
		Map map = new HashMap();
		map.put("rep", rep);
		super.executeUpdate(hql, map);
	}

	@Override
	public int excuteBatchInsertCusContractRepaymentOtherFee(
			Set<CusContractRepaymentOtherFee> cusContractRepaymentOtherFeeList) {
		// TODO Auto-generated method stub
		return 0;
	}
}
