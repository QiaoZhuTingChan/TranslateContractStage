package com.jyd.bms.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundContractStageFee;
import com.jyd.bms.dao.FundContractStageFeeDAO;
/**
 * @category Generated 2018-05-25 14:10:14 by GeneratedTool
 * @author mjy
 */
@Repository
public class FundContractStageFeeDAOImpl extends HibernateBaseTemplate<FundContractStageFee> implements FundContractStageFeeDAO {

 public int getFundContractStageFeeCount(String condition) throws DAOException {
	String hql = "";
	if (condition.equals("")) {
	hql = "select count(*) from FundContractStageFee";
	List<Long> lstCount = super.getQueryResult(hql);
	return lstCount.get(0).intValue();
	} else {
	hql = "select count(*) from FundContractStageFee where fee like :condition";
	Map map = new HashMap();
	map.put("condition", "%" + condition + "%");
	List<Long> lstCount = super.getQueryResult(hql, map);
	return lstCount.get(0).intValue();
	}
 }

 public List<FundContractStageFee> getPagingFundContractStageFee(int firstResult, int maxResults, String condition)throws DAOException {
	String hql = "";
	Map map = new HashMap();
	if (condition.equals("")) {
	hql = "from FundContractStageFee";
	} else {
	hql = "from FundContractStageFee where fee like :condition";
	map.put("condition", "%" + condition + "%");
	}
	return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
 }

 public List<FundContractStageFee> getAllFundContractStageFee() throws DAOException {
	String hql = "";
	hql = "from FundContractStageFee";
	return super.getQueryResult(hql.toString());
 }

@Override
public double getExtraCharges(FundContractStage fundContractStage) throws DAOException {
	String hql="";
	
	hql="select sum(fee) from FundContractStageFee where fundContractStageId=:fundContractStage";
	Map map=new HashMap();
	map.put("fundContractStage", fundContractStage);
	List<Double> lstCount=super.getQueryResult(hql,map);
	return lstCount.get(0)==null?0:lstCount.get(0).doubleValue();
}
}
