package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundContractStageRepayment;
import com.jyd.bms.dao.FundContractStageRepaymentDAO;
/**
 * @category Generated 2018-05-25 14:10:49 by GeneratedTool
 * @author mjy
 */
@Repository
public class FundContractStageRepaymentDAOImpl extends HibernateBaseTemplate<FundContractStageRepayment> implements FundContractStageRepaymentDAO {

 public int getFundContractStageRepaymentCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from FundContractStageRepayment";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from FundContractStageRepayment where fundContractStageId like :condition";
	Map map = new HashMap();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 public List<FundContractStageRepayment> getPagingFundContractStageRepayment(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
	hql = "from FundContractStageRepayment";
	} else {
	hql = "from FundContractStageRepayment where fundContractStageId like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<FundContractStageRepayment> getAllFundContractStageRepayment() throws DAOException {
	String hql = "";
	hql = "from FundContractStageRepayment";
	return super.getQueryResult(hql.toString());
 }

@Override
public List<FundContractStageRepayment> findFundContractStageRepaymentByStageAll(FundContractStage stage)
		throws DAOException {
	String hql="";
	hql="from FundContractStageRepayment where fundContractStage=:stage";
	@SuppressWarnings("rawtypes")
	Map map = new HashMap();
	map.put("stage", stage);
	return super.getQueryResult(hql, map);
}
}
