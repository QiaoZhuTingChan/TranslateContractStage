package com.jyd.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.FundProduct;
import com.jyd.bms.bean.FundProductPara;
import com.jyd.bms.dao.FundProductParaDAO;

/**
 * @category Generated 2018-05-25 14:19:07 by GeneratedTool
 * @author mjy
 */
@Repository
public class FundProductParaDAOImpl extends HibernateBaseTemplate<FundProductPara> implements FundProductParaDAO {

	public int getFundProductParaCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from FundProductPara";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from FundProductPara where parameter like :condition";
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<FundProductPara> getPagingFundProductPara(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from FundProductPara";
		} else {
			hql = "from FundProductPara where parameter like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<FundProductPara> getAllFundProductPara() throws DAOException {
		String hql = "";
		hql = "from FundProductPara";
		return super.getQueryResult(hql.toString());
	}

	/**
	 * 根据资金方产品查产品参数
	 */
	@Override
	public List<FundProductPara> getAllFundProductParaByFundProduct(FundProduct fundProduct) throws DAOException {
		String hql = "from FundProductPara where fundProduct = :fundProduct";
		Map<String, Object> map = new HashMap<>();
		map.put("fundProduct",fundProduct);
		return super.getQueryResult(hql,map);
	}
}
