package com.jyd.bms.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jyd.bms.tool.exception.DAOException;
import com.jyd.bms.bean.ContractRepayment;
import com.jyd.bms.bean.ContractStage;
import com.jyd.bms.bean.CustomerContract;
import com.jyd.bms.bean.FundContract;
import com.jyd.bms.bean.FundContractStage;
import com.jyd.bms.bean.FundContractStageRepayment;
import com.jyd.bms.dao.FundContractStageDAO;

/**
 * @category Generated 2018-05-25 14:09:02 by GeneratedTool
 * @author mjy
 */
@Repository
public class FundContractStageDAOImpl extends HibernateBaseTemplate<FundContractStage> implements FundContractStageDAO {

	public int getFundContractStageCount(String condition) throws DAOException {
		String hql = "";
		if (condition.equals("")) {
			hql = "select count(*) from FundContractStage";
			List<Long> lstCount = super.getQueryResult(hql);
			return lstCount.get(0).intValue();
		} else {
			hql = "select count(*) from FundContractStage where stage like :condition";
			Map map = new HashMap();
			map.put("condition", "%" + condition + "%");
			List<Long> lstCount = super.getQueryResult(hql, map);
			return lstCount.get(0).intValue();
		}
	}

	public List<FundContractStage> getPagingFundContractStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		String hql = "";
		Map map = new HashMap();
		if (condition.equals("")) {
			hql = "from FundContractStage";
		} else {
			hql = "from FundContractStage where stage like :condition";
			map.put("condition", "%" + condition + "%");
		}
		return super.getPagingQueryResult(hql.toString(), map, firstResult, maxResults);
	}

	public List<FundContractStage> getAllFundContractStage() throws DAOException {
		String hql = "";
		hql = "from FundContractStage";
		return super.getQueryResult(hql.toString());
	}

	// 通过合同查期数
	@SuppressWarnings("unchecked")
	public List<FundContractStage> getAllFundContractStageByfundContract(FundContract fundContract)
			throws DAOException {
		String hql = "";
		hql = "from FundContractStage where fundContractId = :fundContract";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fundContract", fundContract);
		return super.getQueryResult(hql, map);
	}

	// 通过合同分期查还款
	@SuppressWarnings("unchecked")
	@Override
	public List<FundContractStageRepayment> findContractRepaymentByStage(FundContractStage fundContractStage)
			throws DAOException {
		String hql = "from FundContractStageRepayment where fundContractStage = :fundContractStage and state=0";
		Map<String, Object> map = new HashMap<>();
		map.put("fundContractStage", fundContractStage);
		return super.getQueryResult(hql, map);
	}

	@Override
	public int getFundContractStageCount(Integer para, String customer, Date startDate, Date endDate)
			throws DAOException {
		StringBuilder hql=new StringBuilder();
		Map parameterMap=new HashMap();
		hql.append("select count(*) from FundContractStage where 1=1");
		if(para!=-1) {
			parameterMap.put("para", para);
			hql.append(" and state=:para");
		}
		if (!customer.equals("")) {
			parameterMap.put("customer", "%" + customer + "%");
			hql.append(" and fundContractId.cusContract.name like :customer");
		}
		if (startDate != null) {
			parameterMap.put("startDate", startDate);
			hql.append(" and repaymentDate>=:startDate");
		}
		if (endDate != null) {
			parameterMap.put("endDate", endDate);
			hql.append(" and repaymentDate<=:endDate");
		}

		List<Long> lstCount = super.getQueryResult(hql.toString(), parameterMap);
		return lstCount.get(0).intValue();
	}

	@Override
	public List<FundContractStage> getFundContractStageByPara(int firstResult, int maxResults, Integer para,
			String customer, String startDate, String endDate) throws DAOException, ParseException {
		StringBuilder hql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("rawtypes")
		Map parameterMap = new HashMap();
		hql.append("from FundContractStage where 1=1");

		if (para != -1) {
			parameterMap.put("para", para);
			hql.append(" and state = :para");
		}

		if (!customer.equals("")) {
			parameterMap.put("customer", "%" + customer + "%");
			hql.append(" and fundContractId.cusContract.name like :customer");
		}
		if (!startDate.equals("")) {
			parameterMap.put("startDate", sdf.parse(startDate));
			hql.append(" and repaymentDate>=:startDate");
		}
		if (!endDate.equals("")) {
			parameterMap.put("endDate", sdf.parse(endDate));
			hql.append(" and repaymentDate<=:endDate");
		}
		return super.getPagingQueryResult(hql.toString(), parameterMap, firstResult, maxResults);
	}

	/*@Override
	public List<ContractStage> getPagingContractStage(int firstResult, int maxResults, String condition)
			throws DAOException {
		try {
			String hql="";
			@SuppressWarnings("rawtypes")
			Map parameterMap = new HashMap();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			date = sdf.parse(sdf.format(new Date()));
			if (firstResult == 0) {
				date = sdf.parse(sdf.format(new Date()));
				parameterMap.put("date", date);
			} else {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				calendar.add(calendar.DATE, firstResult);
				// 把日期往后增加一天.整数往后推,负数往前移动
				date = calendar.getTime();
				// 这个时间就是日期往后推一天的结果
				parameterMap.put("date", date);
			}
			hql = "from FundContractStage where repaymentDate =:date";
			return super.getQueryResult(hql, parameterMap);
		}catch(ParseException e) {
			return null;
		}*/
		
	}

	/**
	 * 查产品分期期数
	 */
	// @Override
	// public List<FundContractStage> getAllFundContractStage(FundContractStage
	// fundContractStage) throws DAOException {
	// String hql = "from FundContractStage where stage = :stage";
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("stage", fundContractStage.getStage());
	// return super.getQueryResult(hql,map);
	// }


