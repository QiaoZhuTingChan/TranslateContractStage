package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.FundContract;
import com.jyd.bms.bean.FundContractCost;
import com.jyd.bms.dao.FundContractCostDAO;

/**
 * @category Generated 2018-05-25 14:19:55 by GeneratedTool
 * @author mjy
 */
@Repository
public class FundContractCostDAOImpl extends HibernateBaseTemplate<FundContractCost> implements FundContractCostDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int getFundContractCostCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from FundContractCost";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from FundContractCost where costTypeId like :condition";
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FundContractCost> getPagingFundContractCost(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from FundContractCost";
		} else {
			hql = "from FundContractCost where costTypeId like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<FundContractCost> getAllFundContractCost() throws DAOException {
		String hql = "";
		hql = "from FundContractCost";
		return super.getQueryResult(hql.toString());
	}

	/**
	 * 根据资金方合同查费用
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FundContractCost> getAllFundContractCostByfundContract(FundContract fundContract) throws DAOException {
		String hql = "from FundContractCost where fundContract = :fundContract";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fundContract", fundContract);
		return super.getQueryResult(hql, map);
	}
}
