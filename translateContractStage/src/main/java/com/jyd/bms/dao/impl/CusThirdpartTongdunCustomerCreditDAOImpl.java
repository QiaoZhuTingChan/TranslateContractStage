package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.CusThirdpartTongdunCustomerCredit;
import com.jyd.bms.dao.CusThirdpartTongdunCustomerCreditDAO;

/**
 * @category Generated 2018-05-02 09:28:31 by GeneratedTool
 * @author mjy
 */
@Repository
public class CusThirdpartTongdunCustomerCreditDAOImpl extends HibernateBaseTemplate<CusThirdpartTongdunCustomerCredit>
		implements CusThirdpartTongdunCustomerCreditDAO {

	@SuppressWarnings("unchecked")
	public int getCusThirdpartTongdunCustomerCreditCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from CusThirdpartTongdunCustomerCredit";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from CusThirdpartTongdunCustomerCredit where idCard like :condition";
			Map<String, Object> map = new HashMap<>();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartTongdunCustomerCredit> getPagingCusThirdpartTongdunCustomerCredit(int firstResult,
			int maxResults, String condition) throws DAOException {
		String hql = "";
		Map<String, Object> map = new HashMap<>();
		if (condition.equals("")) {
			hql = "from CusThirdpartTongdunCustomerCredit";
		} else {
			hql = "from CusThirdpartTongdunCustomerCredit where idCard like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	public List<CusThirdpartTongdunCustomerCredit> getAllCusThirdpartTongdunCustomerCredit() throws DAOException {
		String hql = "";
		hql = "from CusThirdpartTongdunCustomerCredit";
		return super.getQueryResult(hql.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusThirdpartTongdunCustomerCredit> getCusThirdpartTongdunCustomerCreditByIdCard(String idCard)
			throws DAOException {
		StringBuilder hql = new StringBuilder("");
		Map<String, Object> map = new HashMap<>();

		hql.append(" from CusThirdpartTongdunCustomerCredit where idCard = :idCard order by queryDate desc");
		map.put("idCard", idCard);

		return super.getQueryResult(hql.toString(), map);
	}
}
