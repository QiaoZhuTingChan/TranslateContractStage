package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusThirdpartCustomerCredit;
import com.jyd.bms.dao.CusThirdpartCustomerCreditDAO;

/**
 * @category Generated 2018-04-21 12:18:37 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusThirdpartCustomerCreditDAOImpl extends HibernateBaseTemplate<CusThirdpartCustomerCredit>
		implements CusThirdpartCustomerCreditDAO {

	@SuppressWarnings("unchecked")
	public int getCusThirdpartCustomerCreditCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusThirdpartCustomerCredit";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusThirdpartCustomerCredit where idCard like :condition";
			Map<String, Object> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartCustomerCredit> getPagingCusThirdpartCustomerCredit(int firstResult, int maxResults,
			String condition) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		if (condition.equals("")) {
			hql = " from CusThirdpartCustomerCredit";
		} else {
			hql = " from CusThirdpartCustomerCredit where idCard like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartCustomerCredit> getAllCusThirdpartCustomerCredit() throws DAOException {
		String hql = "";
		hql = "from CusThirdpartCustomerCredit";
		return super.getQueryResult(hql.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusThirdpartCustomerCredit> getCusThirdpartCustomerCreditByIdCard(String idCard) throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();

		hql.append(" from CusThirdpartCustomerCredit where idCard = :idCard order by queryDate desc");
		map.put("idCard", idCard);

		return super.getQueryResult(hql.toString(), map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusThirdpartCustomerCredit> getCusThirdpartCustomerCreditByIdCardAndQueryTypeId(String idCard, int id)
			throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();

		hql.append(" from CusThirdpartCustomerCredit where idCard = :idCard and baThirdpartQueryType.id = :id order by queryDate desc");
		map.put("idCard", idCard);
		map.put("id", id);

		return super.getQueryResult(hql.toString(), map);
	}
}
